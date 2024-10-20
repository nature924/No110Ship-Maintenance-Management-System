
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
 * 维保人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/weibaorenyuan")
public class WeibaorenyuanController {
    private static final Logger logger = LoggerFactory.getLogger(WeibaorenyuanController.class);

    private static final String TABLE_NAME = "weibaorenyuan";

    @Autowired
    private WeibaorenyuanService weibaorenyuanService;


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
    private WeibaojihuaService weibaojihuaService;//维保计划
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
        PageUtils page = weibaorenyuanService.queryPage(params);

        //字典表数据转换
        List<WeibaorenyuanView> list =(List<WeibaorenyuanView>)page.getList();
        for(WeibaorenyuanView c:list){
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
        WeibaorenyuanEntity weibaorenyuan = weibaorenyuanService.selectById(id);
        if(weibaorenyuan !=null){
            //entity转view
            WeibaorenyuanView view = new WeibaorenyuanView();
            BeanUtils.copyProperties( weibaorenyuan , view );//把实体数据重构到view中
            //级联表 维保公司
            //级联表
            WeibaogongsiEntity weibaogongsi = weibaogongsiService.selectById(weibaorenyuan.getWeibaogongsiId());
            if(weibaogongsi != null){
            BeanUtils.copyProperties( weibaogongsi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "weibaogongsiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
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
    public R save(@RequestBody WeibaorenyuanEntity weibaorenyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,weibaorenyuan:{}",this.getClass().getName(),weibaorenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("维保公司".equals(role))
            weibaorenyuan.setWeibaogongsiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<WeibaorenyuanEntity> queryWrapper = new EntityWrapper<WeibaorenyuanEntity>()
            .eq("username", weibaorenyuan.getUsername())
            .or()
            .eq("weibaorenyuan_phone", weibaorenyuan.getWeibaorenyuanPhone())
            .or()
            .eq("weibaorenyuan_id_number", weibaorenyuan.getWeibaorenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeibaorenyuanEntity weibaorenyuanEntity = weibaorenyuanService.selectOne(queryWrapper);
        if(weibaorenyuanEntity==null){
            weibaorenyuan.setCreateTime(new Date());
            weibaorenyuan.setPassword(MD5Utils.md5("123456"));
            weibaorenyuanService.insert(weibaorenyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者维保人员手机号或者维保人员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WeibaorenyuanEntity weibaorenyuan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,weibaorenyuan:{}",this.getClass().getName(),weibaorenyuan.toString());
        WeibaorenyuanEntity oldWeibaorenyuanEntity = weibaorenyuanService.selectById(weibaorenyuan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("维保公司".equals(role))
//            weibaorenyuan.setWeibaogongsiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(weibaorenyuan.getWeibaorenyuanPhoto()) || "null".equals(weibaorenyuan.getWeibaorenyuanPhoto())){
                weibaorenyuan.setWeibaorenyuanPhoto(null);
        }

            weibaorenyuanService.updateById(weibaorenyuan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WeibaorenyuanEntity> oldWeibaorenyuanList =weibaorenyuanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        weibaorenyuanService.deleteBatchIds(Arrays.asList(ids));

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
            List<WeibaorenyuanEntity> weibaorenyuanList = new ArrayList<>();//上传的东西
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
                            WeibaorenyuanEntity weibaorenyuanEntity = new WeibaorenyuanEntity();
//                            weibaorenyuanEntity.setWeibaogongsiId(Integer.valueOf(data.get(0)));   //维保公司 要改的
//                            weibaorenyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            weibaorenyuanEntity.setPassword("123456");//密码
//                            weibaorenyuanEntity.setWeibaorenyuanUuidNumber(data.get(0));                    //维保人员编号 要改的
//                            weibaorenyuanEntity.setWeibaorenyuanName(data.get(0));                    //维保人员姓名 要改的
//                            weibaorenyuanEntity.setWeibaorenyuanPhone(data.get(0));                    //维保人员手机号 要改的
//                            weibaorenyuanEntity.setWeibaorenyuanIdNumber(data.get(0));                    //维保人员身份证号 要改的
//                            weibaorenyuanEntity.setWeibaorenyuanPhoto("");//详情和图片
//                            weibaorenyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            weibaorenyuanEntity.setWeibaorenyuanEmail(data.get(0));                    //维保人员邮箱 要改的
//                            weibaorenyuanEntity.setJinyongTypes(Integer.valueOf(data.get(0)));   //账户状态 要改的
//                            weibaorenyuanEntity.setCreateTime(date);//时间
                            weibaorenyuanList.add(weibaorenyuanEntity);


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
                                //维保人员编号
                                if(seachFields.containsKey("weibaorenyuanUuidNumber")){
                                    List<String> weibaorenyuanUuidNumber = seachFields.get("weibaorenyuanUuidNumber");
                                    weibaorenyuanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> weibaorenyuanUuidNumber = new ArrayList<>();
                                    weibaorenyuanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("weibaorenyuanUuidNumber",weibaorenyuanUuidNumber);
                                }
                                //维保人员手机号
                                if(seachFields.containsKey("weibaorenyuanPhone")){
                                    List<String> weibaorenyuanPhone = seachFields.get("weibaorenyuanPhone");
                                    weibaorenyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> weibaorenyuanPhone = new ArrayList<>();
                                    weibaorenyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("weibaorenyuanPhone",weibaorenyuanPhone);
                                }
                                //维保人员身份证号
                                if(seachFields.containsKey("weibaorenyuanIdNumber")){
                                    List<String> weibaorenyuanIdNumber = seachFields.get("weibaorenyuanIdNumber");
                                    weibaorenyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> weibaorenyuanIdNumber = new ArrayList<>();
                                    weibaorenyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("weibaorenyuanIdNumber",weibaorenyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<WeibaorenyuanEntity> weibaorenyuanEntities_username = weibaorenyuanService.selectList(new EntityWrapper<WeibaorenyuanEntity>().in("username", seachFields.get("username")));
                        if(weibaorenyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WeibaorenyuanEntity s:weibaorenyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //维保人员编号
                        List<WeibaorenyuanEntity> weibaorenyuanEntities_weibaorenyuanUuidNumber = weibaorenyuanService.selectList(new EntityWrapper<WeibaorenyuanEntity>().in("weibaorenyuan_uuid_number", seachFields.get("weibaorenyuanUuidNumber")));
                        if(weibaorenyuanEntities_weibaorenyuanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WeibaorenyuanEntity s:weibaorenyuanEntities_weibaorenyuanUuidNumber){
                                repeatFields.add(s.getWeibaorenyuanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [维保人员编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //维保人员手机号
                        List<WeibaorenyuanEntity> weibaorenyuanEntities_weibaorenyuanPhone = weibaorenyuanService.selectList(new EntityWrapper<WeibaorenyuanEntity>().in("weibaorenyuan_phone", seachFields.get("weibaorenyuanPhone")));
                        if(weibaorenyuanEntities_weibaorenyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WeibaorenyuanEntity s:weibaorenyuanEntities_weibaorenyuanPhone){
                                repeatFields.add(s.getWeibaorenyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [维保人员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //维保人员身份证号
                        List<WeibaorenyuanEntity> weibaorenyuanEntities_weibaorenyuanIdNumber = weibaorenyuanService.selectList(new EntityWrapper<WeibaorenyuanEntity>().in("weibaorenyuan_id_number", seachFields.get("weibaorenyuanIdNumber")));
                        if(weibaorenyuanEntities_weibaorenyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WeibaorenyuanEntity s:weibaorenyuanEntities_weibaorenyuanIdNumber){
                                repeatFields.add(s.getWeibaorenyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [维保人员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        weibaorenyuanService.insertBatch(weibaorenyuanList);
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
        WeibaorenyuanEntity weibaorenyuan = weibaorenyuanService.selectOne(new EntityWrapper<WeibaorenyuanEntity>().eq("username", username));
        if(weibaorenyuan==null || !weibaorenyuan.getPassword().equals(MD5Utils.md5(password)))
            return R.error("账号或密码不正确");
        else if(weibaorenyuan.getJinyongTypes() != 1)
            return R.error("账户已被禁用");
        String token = tokenService.generateToken(weibaorenyuan.getId(),username, "weibaorenyuan", "维保人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","维保人员");
        r.put("username",weibaorenyuan.getWeibaorenyuanName());
        r.put("tableName","weibaorenyuan");
        r.put("userId",weibaorenyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody WeibaorenyuanEntity weibaorenyuan, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<WeibaorenyuanEntity> queryWrapper = new EntityWrapper<WeibaorenyuanEntity>()
            .eq("username", weibaorenyuan.getUsername())
            .or()
            .eq("weibaorenyuan_phone", weibaorenyuan.getWeibaorenyuanPhone())
            .or()
            .eq("weibaorenyuan_id_number", weibaorenyuan.getWeibaorenyuanIdNumber())
            ;
        WeibaorenyuanEntity weibaorenyuanEntity = weibaorenyuanService.selectOne(queryWrapper);
        if(weibaorenyuanEntity != null)
            return R.error("账户或者维保人员手机号或者维保人员身份证号已经被使用");
        weibaorenyuan.setWeibaorenyuanUuidNumber(String.valueOf(new Date().getTime()));
        weibaorenyuan.setPassword(MD5Utils.md5(weibaorenyuan.getPassword()));
        weibaorenyuan.setJinyongTypes(1);//启用
        weibaorenyuan.setCreateTime(new Date());
        weibaorenyuanService.insert(weibaorenyuan);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        WeibaorenyuanEntity weibaorenyuan = weibaorenyuanService.selectById(id);
        weibaorenyuan.setPassword(MD5Utils.md5("123456"));
        weibaorenyuanService.updateById(weibaorenyuan);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        WeibaorenyuanEntity weibaorenyuan = weibaorenyuanService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!MD5Utils.md5(oldPassword).equals(weibaorenyuan.getPassword())){
			return R.error("原密码输入错误");
		}
		if(MD5Utils.md5(newPassword).equals(weibaorenyuan.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        weibaorenyuan.setPassword(MD5Utils.md5(newPassword));
		weibaorenyuanService.updateById(weibaorenyuan);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        WeibaorenyuanEntity weibaorenyuan = weibaorenyuanService.selectOne(new EntityWrapper<WeibaorenyuanEntity>().eq("username", username));
        if(weibaorenyuan!=null){
            weibaorenyuan.setPassword(MD5Utils.md5("123456"));
            weibaorenyuanService.updateById(weibaorenyuan);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrWeibaorenyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        WeibaorenyuanEntity weibaorenyuan = weibaorenyuanService.selectById(id);
        if(weibaorenyuan !=null){
            //entity转view
            WeibaorenyuanView view = new WeibaorenyuanView();
            BeanUtils.copyProperties( weibaorenyuan , view );//把实体数据重构到view中

            //级联表
                            WeibaogongsiEntity weibaogongsi = weibaogongsiService.selectById(weibaorenyuan.getWeibaogongsiId());
            if(weibaogongsi != null){
                BeanUtils.copyProperties( weibaogongsi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
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
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



}

