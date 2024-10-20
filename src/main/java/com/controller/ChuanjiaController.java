
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
 * 船家
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chuanjia")
public class ChuanjiaController {
    private static final Logger logger = LoggerFactory.getLogger(ChuanjiaController.class);

    private static final String TABLE_NAME = "chuanjia";

    @Autowired
    private ChuanjiaService chuanjiaService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChaunboService chaunboService;//船舶
    @Autowired
    private ChengbenService chengbenService;//维修成本
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
        PageUtils page = chuanjiaService.queryPage(params);

        //字典表数据转换
        List<ChuanjiaView> list =(List<ChuanjiaView>)page.getList();
        for(ChuanjiaView c:list){
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
        ChuanjiaEntity chuanjia = chuanjiaService.selectById(id);
        if(chuanjia !=null){
            //entity转view
            ChuanjiaView view = new ChuanjiaView();
            BeanUtils.copyProperties( chuanjia , view );//把实体数据重构到view中
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
    public R save(@RequestBody ChuanjiaEntity chuanjia, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chuanjia:{}",this.getClass().getName(),chuanjia.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ChuanjiaEntity> queryWrapper = new EntityWrapper<ChuanjiaEntity>()
            .eq("username", chuanjia.getUsername())
            .or()
            .eq("chuanjia_phone", chuanjia.getChuanjiaPhone())
            .or()
            .eq("chuanjia_id_number", chuanjia.getChuanjiaIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuanjiaEntity chuanjiaEntity = chuanjiaService.selectOne(queryWrapper);
        if(chuanjiaEntity==null){
            chuanjia.setCreateTime(new Date());
            chuanjia.setPassword(MD5Utils.md5("123456"));
            chuanjiaService.insert(chuanjia);
            return R.ok();
        }else {
            return R.error(511,"账户或者船家手机号或者船家身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChuanjiaEntity chuanjia, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,chuanjia:{}",this.getClass().getName(),chuanjia.toString());
        ChuanjiaEntity oldChuanjiaEntity = chuanjiaService.selectById(chuanjia.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(chuanjia.getChuanjiaPhoto()) || "null".equals(chuanjia.getChuanjiaPhoto())){
                chuanjia.setChuanjiaPhoto(null);
        }

            chuanjiaService.updateById(chuanjia);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ChuanjiaEntity> oldChuanjiaList =chuanjiaService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        chuanjiaService.deleteBatchIds(Arrays.asList(ids));

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
            List<ChuanjiaEntity> chuanjiaList = new ArrayList<>();//上传的东西
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
                            ChuanjiaEntity chuanjiaEntity = new ChuanjiaEntity();
//                            chuanjiaEntity.setUsername(data.get(0));                    //账户 要改的
//                            chuanjiaEntity.setPassword("123456");//密码
//                            chuanjiaEntity.setChuanjiaUuidNumber(data.get(0));                    //船家编号 要改的
//                            chuanjiaEntity.setChuanjiaName(data.get(0));                    //船家姓名 要改的
//                            chuanjiaEntity.setChuanjiaPhone(data.get(0));                    //船家手机号 要改的
//                            chuanjiaEntity.setChuanjiaIdNumber(data.get(0));                    //船家身份证号 要改的
//                            chuanjiaEntity.setChuanjiaPhoto("");//详情和图片
//                            chuanjiaEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            chuanjiaEntity.setChuanjiaEmail(data.get(0));                    //船家邮箱 要改的
//                            chuanjiaEntity.setJinyongTypes(Integer.valueOf(data.get(0)));   //账户状态 要改的
//                            chuanjiaEntity.setCreateTime(date);//时间
                            chuanjiaList.add(chuanjiaEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //船家编号
                                if(seachFields.containsKey("chuanjiaUuidNumber")){
                                    List<String> chuanjiaUuidNumber = seachFields.get("chuanjiaUuidNumber");
                                    chuanjiaUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chuanjiaUuidNumber = new ArrayList<>();
                                    chuanjiaUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("chuanjiaUuidNumber",chuanjiaUuidNumber);
                                }
                                //船家手机号
                                if(seachFields.containsKey("chuanjiaPhone")){
                                    List<String> chuanjiaPhone = seachFields.get("chuanjiaPhone");
                                    chuanjiaPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> chuanjiaPhone = new ArrayList<>();
                                    chuanjiaPhone.add(data.get(0));//要改的
                                    seachFields.put("chuanjiaPhone",chuanjiaPhone);
                                }
                                //船家身份证号
                                if(seachFields.containsKey("chuanjiaIdNumber")){
                                    List<String> chuanjiaIdNumber = seachFields.get("chuanjiaIdNumber");
                                    chuanjiaIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chuanjiaIdNumber = new ArrayList<>();
                                    chuanjiaIdNumber.add(data.get(0));//要改的
                                    seachFields.put("chuanjiaIdNumber",chuanjiaIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<ChuanjiaEntity> chuanjiaEntities_username = chuanjiaService.selectList(new EntityWrapper<ChuanjiaEntity>().in("username", seachFields.get("username")));
                        if(chuanjiaEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChuanjiaEntity s:chuanjiaEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //船家编号
                        List<ChuanjiaEntity> chuanjiaEntities_chuanjiaUuidNumber = chuanjiaService.selectList(new EntityWrapper<ChuanjiaEntity>().in("chuanjia_uuid_number", seachFields.get("chuanjiaUuidNumber")));
                        if(chuanjiaEntities_chuanjiaUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChuanjiaEntity s:chuanjiaEntities_chuanjiaUuidNumber){
                                repeatFields.add(s.getChuanjiaUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [船家编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //船家手机号
                        List<ChuanjiaEntity> chuanjiaEntities_chuanjiaPhone = chuanjiaService.selectList(new EntityWrapper<ChuanjiaEntity>().in("chuanjia_phone", seachFields.get("chuanjiaPhone")));
                        if(chuanjiaEntities_chuanjiaPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChuanjiaEntity s:chuanjiaEntities_chuanjiaPhone){
                                repeatFields.add(s.getChuanjiaPhone());
                            }
                            return R.error(511,"数据库的该表中的 [船家手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //船家身份证号
                        List<ChuanjiaEntity> chuanjiaEntities_chuanjiaIdNumber = chuanjiaService.selectList(new EntityWrapper<ChuanjiaEntity>().in("chuanjia_id_number", seachFields.get("chuanjiaIdNumber")));
                        if(chuanjiaEntities_chuanjiaIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChuanjiaEntity s:chuanjiaEntities_chuanjiaIdNumber){
                                repeatFields.add(s.getChuanjiaIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [船家身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chuanjiaService.insertBatch(chuanjiaList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ChuanjiaEntity chuanjia = chuanjiaService.selectOne(new EntityWrapper<ChuanjiaEntity>().eq("username", username));
        if(chuanjia==null || !chuanjia.getPassword().equals(MD5Utils.md5(password)))
            return R.error("账号或密码不正确");
        else if(chuanjia.getJinyongTypes() != 1)
            return R.error("账户已被禁用");
        String token = tokenService.generateToken(chuanjia.getId(),username, "chuanjia", "船家");
        R r = R.ok();
        r.put("token", token);
        r.put("role","船家");
        r.put("username",chuanjia.getChuanjiaName());
        r.put("tableName","chuanjia");
        r.put("userId",chuanjia.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody ChuanjiaEntity chuanjia, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<ChuanjiaEntity> queryWrapper = new EntityWrapper<ChuanjiaEntity>()
            .eq("username", chuanjia.getUsername())
            .or()
            .eq("chuanjia_phone", chuanjia.getChuanjiaPhone())
            .or()
            .eq("chuanjia_id_number", chuanjia.getChuanjiaIdNumber())
            ;
        ChuanjiaEntity chuanjiaEntity = chuanjiaService.selectOne(queryWrapper);
        if(chuanjiaEntity != null)
            return R.error("账户或者船家手机号或者船家身份证号已经被使用");
        chuanjia.setChuanjiaUuidNumber(String.valueOf(new Date().getTime()));
        chuanjia.setPassword(MD5Utils.md5(chuanjia.getPassword()));
        chuanjia.setJinyongTypes(1);//启用
        chuanjia.setCreateTime(new Date());
        chuanjiaService.insert(chuanjia);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        ChuanjiaEntity chuanjia = chuanjiaService.selectById(id);
        chuanjia.setPassword(MD5Utils.md5("123456"));
        chuanjiaService.updateById(chuanjia);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        ChuanjiaEntity chuanjia = chuanjiaService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!MD5Utils.md5(oldPassword).equals(chuanjia.getPassword())){
			return R.error("原密码输入错误");
		}
		if(MD5Utils.md5(newPassword).equals(chuanjia.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        chuanjia.setPassword(MD5Utils.md5(newPassword));
		chuanjiaService.updateById(chuanjia);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        ChuanjiaEntity chuanjia = chuanjiaService.selectOne(new EntityWrapper<ChuanjiaEntity>().eq("username", username));
        if(chuanjia!=null){
            chuanjia.setPassword(MD5Utils.md5("123456"));
            chuanjiaService.updateById(chuanjia);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrChuanjia(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        ChuanjiaEntity chuanjia = chuanjiaService.selectById(id);
        if(chuanjia !=null){
            //entity转view
            ChuanjiaView view = new ChuanjiaView();
            BeanUtils.copyProperties( chuanjia , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



}

