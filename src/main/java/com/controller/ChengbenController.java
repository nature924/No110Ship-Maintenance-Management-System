
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
 * 维修成本
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chengben")
public class ChengbenController {
    private static final Logger logger = LoggerFactory.getLogger(ChengbenController.class);

    private static final String TABLE_NAME = "chengben";

    @Autowired
    private ChengbenService chengbenService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChaunboService chaunboService;//船舶
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
        PageUtils page = chengbenService.queryPage(params);

        //字典表数据转换
        List<ChengbenView> list =(List<ChengbenView>)page.getList();
        for(ChengbenView c:list){
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
        ChengbenEntity chengben = chengbenService.selectById(id);
        if(chengben !=null){
            //entity转view
            ChengbenView view = new ChengbenView();
            BeanUtils.copyProperties( chengben , view );//把实体数据重构到view中
            //级联表 故障上报
            //级联表
            GuzhangEntity guzhang = guzhangService.selectById(chengben.getGuzhangId());
            if(guzhang != null){
            BeanUtils.copyProperties( guzhang , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setGuzhangId(guzhang.getId());
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
    public R save(@RequestBody ChengbenEntity chengben, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chengben:{}",this.getClass().getName(),chengben.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ChengbenEntity> queryWrapper = new EntityWrapper<ChengbenEntity>()
            .eq("guzhang_id", chengben.getGuzhangId())
            .eq("chengben_types", chengben.getChengbenTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChengbenEntity chengbenEntity = chengbenService.selectOne(queryWrapper);
        if(chengbenEntity==null){
            chengben.setInsertTime(new Date());
            chengben.setCreateTime(new Date());
            chengbenService.insert(chengben);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChengbenEntity chengben, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,chengben:{}",this.getClass().getName(),chengben.toString());
        ChengbenEntity oldChengbenEntity = chengbenService.selectById(chengben.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(chengben.getChengbenFile()) || "null".equals(chengben.getChengbenFile())){
                chengben.setChengbenFile(null);
        }
        if("".equals(chengben.getChengbenContent()) || "null".equals(chengben.getChengbenContent())){
                chengben.setChengbenContent(null);
        }

            chengbenService.updateById(chengben);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ChengbenEntity> oldChengbenList =chengbenService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        chengbenService.deleteBatchIds(Arrays.asList(ids));

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
            List<ChengbenEntity> chengbenList = new ArrayList<>();//上传的东西
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
                            ChengbenEntity chengbenEntity = new ChengbenEntity();
//                            chengbenEntity.setGuzhangId(Integer.valueOf(data.get(0)));   //故障 要改的
//                            chengbenEntity.setChengbenUuidNumber(data.get(0));                    //维修成本编号 要改的
//                            chengbenEntity.setChengbenTypes(Integer.valueOf(data.get(0)));   //维修成本类型 要改的
//                            chengbenEntity.setChengbenFile(data.get(0));                    //附件 要改的
//                            chengbenEntity.setChengbenJine(data.get(0));                    //金额 要改的
//                            chengbenEntity.setChengbenTime(sdf.parse(data.get(0)));          //花费时间 要改的
//                            chengbenEntity.setChengbenContent("");//详情和图片
//                            chengbenEntity.setInsertTime(date);//时间
//                            chengbenEntity.setCreateTime(date);//时间
                            chengbenList.add(chengbenEntity);


                            //把要查询是否重复的字段放入map中
                                //维修成本编号
                                if(seachFields.containsKey("chengbenUuidNumber")){
                                    List<String> chengbenUuidNumber = seachFields.get("chengbenUuidNumber");
                                    chengbenUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chengbenUuidNumber = new ArrayList<>();
                                    chengbenUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("chengbenUuidNumber",chengbenUuidNumber);
                                }
                        }

                        //查询是否重复
                         //维修成本编号
                        List<ChengbenEntity> chengbenEntities_chengbenUuidNumber = chengbenService.selectList(new EntityWrapper<ChengbenEntity>().in("chengben_uuid_number", seachFields.get("chengbenUuidNumber")));
                        if(chengbenEntities_chengbenUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChengbenEntity s:chengbenEntities_chengbenUuidNumber){
                                repeatFields.add(s.getChengbenUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [维修成本编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chengbenService.insertBatch(chengbenList);
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

