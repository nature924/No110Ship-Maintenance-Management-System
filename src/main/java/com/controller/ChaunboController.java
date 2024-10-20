
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
 * 船舶
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chaunbo")
public class ChaunboController {
    private static final Logger logger = LoggerFactory.getLogger(ChaunboController.class);

    private static final String TABLE_NAME = "chaunbo";

    @Autowired
    private ChaunboService chaunboService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChengbenService chengbenService;//维修成本
    @Autowired
    private ChuanjiaService chuanjiaService;//船家
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private GuzhangService guzhangService;//故障上报
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
        else if("维保人员".equals(role))
            params.put("weibaorenyuanId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = chaunboService.queryPage(params);

        //字典表数据转换
        List<ChaunboView> list =(List<ChaunboView>)page.getList();
        for(ChaunboView c:list){
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
        ChaunboEntity chaunbo = chaunboService.selectById(id);
        if(chaunbo !=null){
            //entity转view
            ChaunboView view = new ChaunboView();
            BeanUtils.copyProperties( chaunbo , view );//把实体数据重构到view中
            //级联表 船家
            //级联表
            ChuanjiaEntity chuanjia = chuanjiaService.selectById(chaunbo.getChuanjiaId());
            if(chuanjia != null){
            BeanUtils.copyProperties( chuanjia , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "chuanjiaId"
, "weibaogongsiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setChuanjiaId(chuanjia.getId());
            }
            //级联表 维保公司
            //级联表
            WeibaogongsiEntity weibaogongsi = weibaogongsiService.selectById(chaunbo.getWeibaogongsiId());
            if(weibaogongsi != null){
            BeanUtils.copyProperties( weibaogongsi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "chuanjiaId"
, "weibaogongsiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setWeibaogongsiId(weibaogongsi.getId());
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
    public R save(@RequestBody ChaunboEntity chaunbo, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chaunbo:{}",this.getClass().getName(),chaunbo.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("船家".equals(role))
            chaunbo.setChuanjiaId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("维保公司".equals(role))
            chaunbo.setWeibaogongsiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ChaunboEntity> queryWrapper = new EntityWrapper<ChaunboEntity>()
            .eq("chuanjia_id", chaunbo.getChuanjiaId())
            .eq("weibaogongsi_id", chaunbo.getWeibaogongsiId())
            .eq("chaunbo_name", chaunbo.getChaunboName())
            .eq("chaunbo_types", chaunbo.getChaunboTypes())
            .eq("chaunbo_zhuangtai_types", chaunbo.getChaunboZhuangtaiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChaunboEntity chaunboEntity = chaunboService.selectOne(queryWrapper);
        if(chaunboEntity==null){
            chaunbo.setInsertTime(new Date());
            chaunbo.setCreateTime(new Date());
            chaunboService.insert(chaunbo);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChaunboEntity chaunbo, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,chaunbo:{}",this.getClass().getName(),chaunbo.toString());
        ChaunboEntity oldChaunboEntity = chaunboService.selectById(chaunbo.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("船家".equals(role))
//            chaunbo.setChuanjiaId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("维保公司".equals(role))
//            chaunbo.setWeibaogongsiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(chaunbo.getChaunboPhoto()) || "null".equals(chaunbo.getChaunboPhoto())){
                chaunbo.setChaunboPhoto(null);
        }
        if("".equals(chaunbo.getChaunboFile()) || "null".equals(chaunbo.getChaunboFile())){
                chaunbo.setChaunboFile(null);
        }
        if("".equals(chaunbo.getChaunboContent()) || "null".equals(chaunbo.getChaunboContent())){
                chaunbo.setChaunboContent(null);
        }

            chaunboService.updateById(chaunbo);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ChaunboEntity> oldChaunboList =chaunboService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        chaunboService.deleteBatchIds(Arrays.asList(ids));

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
            List<ChaunboEntity> chaunboList = new ArrayList<>();//上传的东西
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
                            ChaunboEntity chaunboEntity = new ChaunboEntity();
//                            chaunboEntity.setChuanjiaId(Integer.valueOf(data.get(0)));   //船家 要改的
//                            chaunboEntity.setWeibaogongsiId(Integer.valueOf(data.get(0)));   //维保公司 要改的
//                            chaunboEntity.setChaunboUuidNumber(data.get(0));                    //船舶编号 要改的
//                            chaunboEntity.setChaunboName(data.get(0));                    //船舶名字 要改的
//                            chaunboEntity.setChaunboPhoto("");//详情和图片
//                            chaunboEntity.setChaunboFile(data.get(0));                    //附件 要改的
//                            chaunboEntity.setChaunboTypes(Integer.valueOf(data.get(0)));   //船舶类型 要改的
//                            chaunboEntity.setChaunboZhuangtaiTypes(Integer.valueOf(data.get(0)));   //船舶状态 要改的
//                            chaunboEntity.setChaunboContent("");//详情和图片
//                            chaunboEntity.setInsertTime(date);//时间
//                            chaunboEntity.setCreateTime(date);//时间
                            chaunboList.add(chaunboEntity);


                            //把要查询是否重复的字段放入map中
                                //船舶编号
                                if(seachFields.containsKey("chaunboUuidNumber")){
                                    List<String> chaunboUuidNumber = seachFields.get("chaunboUuidNumber");
                                    chaunboUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chaunboUuidNumber = new ArrayList<>();
                                    chaunboUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("chaunboUuidNumber",chaunboUuidNumber);
                                }
                        }

                        //查询是否重复
                         //船舶编号
                        List<ChaunboEntity> chaunboEntities_chaunboUuidNumber = chaunboService.selectList(new EntityWrapper<ChaunboEntity>().in("chaunbo_uuid_number", seachFields.get("chaunboUuidNumber")));
                        if(chaunboEntities_chaunboUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChaunboEntity s:chaunboEntities_chaunboUuidNumber){
                                repeatFields.add(s.getChaunboUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [船舶编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chaunboService.insertBatch(chaunboList);
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

