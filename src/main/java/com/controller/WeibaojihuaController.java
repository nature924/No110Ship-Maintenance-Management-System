
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.annotation.ColumnInfo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;

import org.springframework.format.annotation.DateTimeFormat;
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
 * 维保计划
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/weibaojihua")
public class WeibaojihuaController {
    private static final Logger logger = LoggerFactory.getLogger(WeibaojihuaController.class);

    private static final String TABLE_NAME = "weibaojihua";

    @Autowired
    private WeibaojihuaService weibaojihuaService;


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
    private GuzhangService guzhangService;//故障上报
    @Autowired
    private WeibaogongsiService weibaogongsiService;//维保公司
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
        PageUtils page = weibaojihuaService.queryPage(params);

        //字典表数据转换
        List<WeibaojihuaView> list =(List<WeibaojihuaView>)page.getList();
        for(WeibaojihuaView c:list){
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
        WeibaojihuaEntity weibaojihua = weibaojihuaService.selectById(id);
        if(weibaojihua !=null){
            //entity转view
            WeibaojihuaView view = new WeibaojihuaView();
            BeanUtils.copyProperties( weibaojihua , view );//把实体数据重构到view中
            //级联表 船舶
            //级联表
            ChaunboEntity chaunbo = chaunboService.selectById(weibaojihua.getChaunboId());
            if(chaunbo != null){
            BeanUtils.copyProperties( chaunbo , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "weibaogongsiId"
, "weibaorenyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setChaunboId(chaunbo.getId());
            }
            //级联表 维保公司
            //级联表
            WeibaogongsiEntity weibaogongsi = weibaogongsiService.selectById(weibaojihua.getWeibaogongsiId());
            if(weibaogongsi != null){
            BeanUtils.copyProperties( weibaogongsi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "weibaogongsiId"
, "weibaorenyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setWeibaogongsiId(weibaogongsi.getId());
            }
            //级联表 维保人员
            //级联表
            WeibaorenyuanEntity weibaorenyuan = weibaorenyuanService.selectById(weibaojihua.getWeibaorenyuanId());
            if(weibaorenyuan != null){
            BeanUtils.copyProperties( weibaorenyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "weibaogongsiId"
, "weibaorenyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
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
    public R save(@RequestBody WeibaojihuaEntity weibaojihua, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,weibaojihua:{}",this.getClass().getName(),weibaojihua.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("维保公司".equals(role))
            weibaojihua.setWeibaogongsiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("维保人员".equals(role))
            weibaojihua.setWeibaorenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        ChaunboEntity chaunboEntity = chaunboService.selectById(weibaojihua.getChaunboId());
        if(chaunboEntity == null)
            return R.error("查不到船舶信息");
        if(chaunboEntity.getChaunboZhuangtaiTypes() ==1)
            return R.error("该船舶运行中,无法添加维保计划");


        Wrapper<WeibaojihuaEntity> queryWrapper = new EntityWrapper<WeibaojihuaEntity>()
            .eq("chaunbo_id", weibaojihua.getChaunboId())
            .eq("weibaogongsi_id", weibaojihua.getWeibaogongsiId())
            .eq("weibaorenyuan_id", weibaojihua.getWeibaorenyuanId())
            .eq("weibaojihua_name", weibaojihua.getWeibaojihuaName())
            .eq("weibaojihua_types", weibaojihua.getWeibaojihuaTypes())
            .eq("weibaojihua_buwei", weibaojihua.getWeibaojihuaBuwei())
            .eq("weibaojihua_address", weibaojihua.getWeibaojihuaAddress())
            .in("weibaojihua_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeibaojihuaEntity weibaojihuaEntity = weibaojihuaService.selectOne(queryWrapper);
        if(weibaojihuaEntity==null){
            weibaojihua.setInsertTime(new Date());
            weibaojihua.setWeibaojihuaYesnoTypes(1);
            weibaojihua.setCreateTime(new Date());
            weibaojihuaService.insert(weibaojihua);
            return R.ok();
        }else {
            if(weibaojihuaEntity.getWeibaojihuaYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(weibaojihuaEntity.getWeibaojihuaYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WeibaojihuaEntity weibaojihua, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,weibaojihua:{}",this.getClass().getName(),weibaojihua.toString());
        WeibaojihuaEntity oldWeibaojihuaEntity = weibaojihuaService.selectById(weibaojihua.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("维保公司".equals(role))
//            weibaojihua.setWeibaogongsiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("维保人员".equals(role))
//            weibaojihua.setWeibaorenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(weibaojihua.getWeibaojihuaFile()) || "null".equals(weibaojihua.getWeibaojihuaFile())){
                weibaojihua.setWeibaojihuaFile(null);
        }
        if("".equals(weibaojihua.getWeibaojihuaContent()) || "null".equals(weibaojihua.getWeibaojihuaContent())){
                weibaojihua.setWeibaojihuaContent(null);
        }
        if("".equals(weibaojihua.getWeibaojihuaYesnoText()) || "null".equals(weibaojihua.getWeibaojihuaYesnoText())){
                weibaojihua.setWeibaojihuaYesnoText(null);
        }

            weibaojihuaService.updateById(weibaojihua);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody WeibaojihuaEntity weibaojihuaEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,weibaojihuaEntity:{}",this.getClass().getName(),weibaojihuaEntity.toString());

        WeibaojihuaEntity oldWeibaojihua = weibaojihuaService.selectById(weibaojihuaEntity.getId());//查询原先数据

        if(weibaojihuaEntity.getWeibaojihuaYesnoTypes() == 2){//通过
            GuzhangEntity guzhangEntity = new GuzhangEntity();
            guzhangEntity.setChaunboId(oldWeibaojihua.getChaunboId());
            guzhangEntity.setCreateTime(new Date());
            guzhangEntity.setGuzhangAddress("正常维保");
            guzhangEntity.setWeibaorenyuanId(oldWeibaojihua.getWeibaorenyuanId());
            guzhangEntity.setGuzhangUuidNumber(String.valueOf(new Date().getTime()));
            guzhangEntity.setGuzhangName(oldWeibaojihua.getWeibaojihuaName());
            guzhangEntity.setGuzhangPhoto(null);
            guzhangEntity.setGuzhangAddress("正常维保");
            guzhangEntity.setGuzhangTypes(1);
            guzhangEntity.setGuzhangContent(oldWeibaojihua.getWeibaojihuaName()+"的正常维保");
            guzhangEntity.setGuzhangZhuangtaiTypes(1);
            guzhangEntity.setInsertTime(new Date());
            guzhangService.insert(guzhangEntity);
        }else if(weibaojihuaEntity.getWeibaojihuaYesnoTypes() == 3){//拒绝
        }
        weibaojihuaEntity.setWeibaojihuaShenheTime(new Date());//审核时间
        weibaojihuaService.updateById(weibaojihuaEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WeibaojihuaEntity> oldWeibaojihuaList =weibaojihuaService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        weibaojihuaService.deleteBatchIds(Arrays.asList(ids));

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
            List<WeibaojihuaEntity> weibaojihuaList = new ArrayList<>();//上传的东西
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
                            WeibaojihuaEntity weibaojihuaEntity = new WeibaojihuaEntity();
//                            weibaojihuaEntity.setChaunboId(Integer.valueOf(data.get(0)));   //船舶 要改的
//                            weibaojihuaEntity.setWeibaogongsiId(Integer.valueOf(data.get(0)));   //维保公司 要改的
//                            weibaojihuaEntity.setWeibaorenyuanId(Integer.valueOf(data.get(0)));   //维保人员 要改的
//                            weibaojihuaEntity.setWeibaojihuaUuidNumber(data.get(0));                    //维保计划编号 要改的
//                            weibaojihuaEntity.setWeibaojihuaName(data.get(0));                    //维保计划标题 要改的
//                            weibaojihuaEntity.setWeibaojihuaFile(data.get(0));                    //维保计划附件 要改的
//                            weibaojihuaEntity.setWeibaojihuaTypes(Integer.valueOf(data.get(0)));   //维保计划类型 要改的
//                            weibaojihuaEntity.setWeibaojihuaBuwei(data.get(0));                    //维保部位 要改的
//                            weibaojihuaEntity.setWeibaoTime(sdf.parse(data.get(0)));          //维保时间 要改的
//                            weibaojihuaEntity.setWeibaojihuaAddress(data.get(0));                    //维保地点 要改的
//                            weibaojihuaEntity.setWeibaojihuaContent("");//详情和图片
//                            weibaojihuaEntity.setInsertTime(date);//时间
//                            weibaojihuaEntity.setWeibaojihuaYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            weibaojihuaEntity.setWeibaojihuaYesnoText(data.get(0));                    //审核意见 要改的
//                            weibaojihuaEntity.setWeibaojihuaShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            weibaojihuaEntity.setCreateTime(date);//时间
                            weibaojihuaList.add(weibaojihuaEntity);


                            //把要查询是否重复的字段放入map中
                                //维保计划编号
                                if(seachFields.containsKey("weibaojihuaUuidNumber")){
                                    List<String> weibaojihuaUuidNumber = seachFields.get("weibaojihuaUuidNumber");
                                    weibaojihuaUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> weibaojihuaUuidNumber = new ArrayList<>();
                                    weibaojihuaUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("weibaojihuaUuidNumber",weibaojihuaUuidNumber);
                                }
                        }

                        //查询是否重复
                         //维保计划编号
                        List<WeibaojihuaEntity> weibaojihuaEntities_weibaojihuaUuidNumber = weibaojihuaService.selectList(new EntityWrapper<WeibaojihuaEntity>().in("weibaojihua_uuid_number", seachFields.get("weibaojihuaUuidNumber")));
                        if(weibaojihuaEntities_weibaojihuaUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WeibaojihuaEntity s:weibaojihuaEntities_weibaojihuaUuidNumber){
                                repeatFields.add(s.getWeibaojihuaUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [维保计划编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        weibaojihuaService.insertBatch(weibaojihuaList);
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

