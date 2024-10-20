
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 故障上报
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/guzhang")
public class GuzhangController {
    private static final Logger logger = LoggerFactory.getLogger(GuzhangController.class);

    private static final String TABLE_NAME = "guzhang";

    @Autowired
    private GuzhangService guzhangService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChaunboService chaunboService;//船舶
    @Autowired
    private ChengbenService chengbenService;//维修成本
    @Autowired
    private ChuanjiaService chuanjiaService;//船家
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private WeibaogongsiService weibaogongsiService;//维保公司
    @Autowired
    private WeibaojihuaService weibaojihuaService;//维保计划
    @Autowired
    private WeibaorenyuanService weibaorenyuanService;//维保人员
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("船家".equals(role))
            params.put("chuanjiaId",request.getSession().getAttribute("userId"));
        else if("维保公司".equals(role))
            params.put("weibaogongsiId",request.getSession().getAttribute("userId"));
        else if("维保人员".equals(role)){
            WeibaorenyuanEntity weibaorenyuanEntity = weibaorenyuanService.selectById((Integer) request.getSession().getAttribute("userId"));
            params.put("weibaorenyuanId",weibaorenyuanEntity.getId());
            params.put("weibaogongsiId",weibaorenyuanEntity.getWeibaogongsiId());
        }
        CommonUtil.checkMap(params);
        PageUtils page = guzhangService.queryPage(params);

        //字典表数据转换
        List<GuzhangView> list =(List<GuzhangView>)page.getList();
        for(GuzhangView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GuzhangEntity guzhang = guzhangService.selectById(id);
        if(guzhang !=null){
            //entity转view
            GuzhangView view = new GuzhangView();
            BeanUtils.copyProperties( guzhang , view );//把实体数据重构到view中
            //级联表 船舶
            //级联表
            ChaunboEntity chaunbo = chaunboService.selectById(guzhang.getChaunboId());
            if(chaunbo != null){
            BeanUtils.copyProperties( chaunbo , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "weibaorenyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setChaunboId(chaunbo.getId());
            }
            //级联表 维保人员
            //级联表
            WeibaorenyuanEntity weibaorenyuan = weibaorenyuanService.selectById(guzhang.getWeibaorenyuanId());
            if(weibaorenyuan != null){
            BeanUtils.copyProperties( weibaorenyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "weibaorenyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setWeibaorenyuanId(weibaorenyuan.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody GuzhangEntity guzhang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,guzhang:{}",this.getClass().getName(),guzhang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("维保人员".equals(role))
            guzhang.setWeibaorenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("船家".equals(role)){
            guzhang.setGuzhangZhuangtaiTypes(1);
        }

        Wrapper<GuzhangEntity> queryWrapper = new EntityWrapper<GuzhangEntity>()
            .eq("chaunbo_id", guzhang.getChaunboId())
            .eq("weibaorenyuan_id", guzhang.getWeibaorenyuanId())
            .eq("guzhang_name", guzhang.getGuzhangName())
            .eq("guzhang_address", guzhang.getGuzhangAddress())
            .eq("guzhang_types", guzhang.getGuzhangTypes())
            .eq("guzhang_zhuangtai_types", guzhang.getGuzhangZhuangtaiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GuzhangEntity guzhangEntity = guzhangService.selectOne(queryWrapper);
        if(guzhangEntity==null){
            guzhang.setInsertTime(new Date());
            guzhang.setCreateTime(new Date());
            guzhangService.insert(guzhang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GuzhangEntity guzhang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,guzhang:{}",this.getClass().getName(),guzhang.toString());
        GuzhangEntity oldGuzhangEntity = guzhangService.selectById(guzhang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("维保人员".equals(role))
//            guzhang.setWeibaorenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(guzhang.getGuzhangPhoto()) || "null".equals(guzhang.getGuzhangPhoto())){
                guzhang.setGuzhangPhoto(null);
        }
        if("".equals(guzhang.getGuzhangContent()) || "null".equals(guzhang.getGuzhangContent())){
                guzhang.setGuzhangContent(null);
        }
        if("".equals(guzhang.getGuzhangText()) || "null".equals(guzhang.getGuzhangText())){
                guzhang.setGuzhangText(null);
        }

            guzhangService.updateById(guzhang);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<GuzhangEntity> oldGuzhangList =guzhangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        guzhangService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer chuanjiaId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<GuzhangEntity> guzhangList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            GuzhangEntity guzhangEntity = new GuzhangEntity();
//                            guzhangEntity.setChaunboId(Integer.valueOf(data.get(0)));   //船舶 要改的
//                            guzhangEntity.setWeibaorenyuanId(Integer.valueOf(data.get(0)));   //维保人员 要改的
//                            guzhangEntity.setGuzhangUuidNumber(data.get(0));                    //故障编号 要改的
//                            guzhangEntity.setGuzhangName(data.get(0));                    //故障标题 要改的
//                            guzhangEntity.setGuzhangPhoto("");//详情和图片
//                            guzhangEntity.setGuzhangAddress(data.get(0));                    //故障位置 要改的
//                            guzhangEntity.setGuzhangTypes(Integer.valueOf(data.get(0)));   //故障类型 要改的
//                            guzhangEntity.setGuzhangContent("");//详情和图片
//                            guzhangEntity.setGuzhangZhuangtaiTypes(Integer.valueOf(data.get(0)));   //故障状态 要改的
//                            guzhangEntity.setInsertTime(date);//时间
//                            guzhangEntity.setGuzhangText(data.get(0));                    //维修评价 要改的
//                            guzhangEntity.setCreateTime(date);//时间
                            guzhangList.add(guzhangEntity);


                            //把要查询是否重复的字段放入map中
                                //故障编号
                                if(seachFields.containsKey("guzhangUuidNumber")){
                                    List<String> guzhangUuidNumber = seachFields.get("guzhangUuidNumber");
                                    guzhangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> guzhangUuidNumber = new ArrayList<>();
                                    guzhangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("guzhangUuidNumber",guzhangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //故障编号
                        List<GuzhangEntity> guzhangEntities_guzhangUuidNumber = guzhangService.selectList(new EntityWrapper<GuzhangEntity>().in("guzhang_uuid_number", seachFields.get("guzhangUuidNumber")));
                        if(guzhangEntities_guzhangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GuzhangEntity s:guzhangEntities_guzhangUuidNumber){
                                repeatFields.add(s.getGuzhangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [故障编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        guzhangService.insertBatch(guzhangList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




}

