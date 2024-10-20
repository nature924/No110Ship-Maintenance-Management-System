
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
 * 维保公司
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/weibaogongsi")
public class WeibaogongsiController {
    private static final Logger logger = LoggerFactory.getLogger(WeibaogongsiController.class);

    private static final String TABLE_NAME = "weibaogongsi";

    @Autowired
    private WeibaogongsiService weibaogongsiService;


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
        PageUtils page = weibaogongsiService.queryPage(params);

        //字典表数据转换
        List<WeibaogongsiView> list =(List<WeibaogongsiView>)page.getList();
        for(WeibaogongsiView c:list){
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
        WeibaogongsiEntity weibaogongsi = weibaogongsiService.selectById(id);
        if(weibaogongsi !=null){
            //entity转view
            WeibaogongsiView view = new WeibaogongsiView();
            BeanUtils.copyProperties( weibaogongsi , view );//把实体数据重构到view中
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
    public R save(@RequestBody WeibaogongsiEntity weibaogongsi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,weibaogongsi:{}",this.getClass().getName(),weibaogongsi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<WeibaogongsiEntity> queryWrapper = new EntityWrapper<WeibaogongsiEntity>()
            .eq("username", weibaogongsi.getUsername())
            .or()
            .eq("weibaogongsi_phone", weibaogongsi.getWeibaogongsiPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeibaogongsiEntity weibaogongsiEntity = weibaogongsiService.selectOne(queryWrapper);
        if(weibaogongsiEntity==null){
            weibaogongsi.setCreateTime(new Date());
            weibaogongsi.setPassword(MD5Utils.md5("123456"));
            weibaogongsiService.insert(weibaogongsi);
            return R.ok();
        }else {
            return R.error(511,"账户或者维保公司手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WeibaogongsiEntity weibaogongsi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,weibaogongsi:{}",this.getClass().getName(),weibaogongsi.toString());
        WeibaogongsiEntity oldWeibaogongsiEntity = weibaogongsiService.selectById(weibaogongsi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(weibaogongsi.getWeibaogongsiPhoto()) || "null".equals(weibaogongsi.getWeibaogongsiPhoto())){
                weibaogongsi.setWeibaogongsiPhoto(null);
        }

            weibaogongsiService.updateById(weibaogongsi);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WeibaogongsiEntity> oldWeibaogongsiList =weibaogongsiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        weibaogongsiService.deleteBatchIds(Arrays.asList(ids));

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
            List<WeibaogongsiEntity> weibaogongsiList = new ArrayList<>();//上传的东西
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
                            WeibaogongsiEntity weibaogongsiEntity = new WeibaogongsiEntity();
//                            weibaogongsiEntity.setUsername(data.get(0));                    //账户 要改的
//                            weibaogongsiEntity.setPassword("123456");//密码
//                            weibaogongsiEntity.setWeibaogongsiUuidNumber(data.get(0));                    //维保公司编号 要改的
//                            weibaogongsiEntity.setWeibaogongsiName(data.get(0));                    //维保公司名称 要改的
//                            weibaogongsiEntity.setWeibaogongsiFuzeren(data.get(0));                    //负责人 要改的
//                            weibaogongsiEntity.setWeibaogongsiPhone(data.get(0));                    //维保公司手机号 要改的
//                            weibaogongsiEntity.setWeibaogongsiPhoto("");//详情和图片
//                            weibaogongsiEntity.setWeibaogongsiAddress(data.get(0));                    //公司位置 要改的
//                            weibaogongsiEntity.setJinyongTypes(Integer.valueOf(data.get(0)));   //账户状态 要改的
//                            weibaogongsiEntity.setCreateTime(date);//时间
                            weibaogongsiList.add(weibaogongsiEntity);


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
                                //维保公司编号
                                if(seachFields.containsKey("weibaogongsiUuidNumber")){
                                    List<String> weibaogongsiUuidNumber = seachFields.get("weibaogongsiUuidNumber");
                                    weibaogongsiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> weibaogongsiUuidNumber = new ArrayList<>();
                                    weibaogongsiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("weibaogongsiUuidNumber",weibaogongsiUuidNumber);
                                }
                                //维保公司手机号
                                if(seachFields.containsKey("weibaogongsiPhone")){
                                    List<String> weibaogongsiPhone = seachFields.get("weibaogongsiPhone");
                                    weibaogongsiPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> weibaogongsiPhone = new ArrayList<>();
                                    weibaogongsiPhone.add(data.get(0));//要改的
                                    seachFields.put("weibaogongsiPhone",weibaogongsiPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<WeibaogongsiEntity> weibaogongsiEntities_username = weibaogongsiService.selectList(new EntityWrapper<WeibaogongsiEntity>().in("username", seachFields.get("username")));
                        if(weibaogongsiEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WeibaogongsiEntity s:weibaogongsiEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //维保公司编号
                        List<WeibaogongsiEntity> weibaogongsiEntities_weibaogongsiUuidNumber = weibaogongsiService.selectList(new EntityWrapper<WeibaogongsiEntity>().in("weibaogongsi_uuid_number", seachFields.get("weibaogongsiUuidNumber")));
                        if(weibaogongsiEntities_weibaogongsiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WeibaogongsiEntity s:weibaogongsiEntities_weibaogongsiUuidNumber){
                                repeatFields.add(s.getWeibaogongsiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [维保公司编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //维保公司手机号
                        List<WeibaogongsiEntity> weibaogongsiEntities_weibaogongsiPhone = weibaogongsiService.selectList(new EntityWrapper<WeibaogongsiEntity>().in("weibaogongsi_phone", seachFields.get("weibaogongsiPhone")));
                        if(weibaogongsiEntities_weibaogongsiPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WeibaogongsiEntity s:weibaogongsiEntities_weibaogongsiPhone){
                                repeatFields.add(s.getWeibaogongsiPhone());
                            }
                            return R.error(511,"数据库的该表中的 [维保公司手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        weibaogongsiService.insertBatch(weibaogongsiList);
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
        WeibaogongsiEntity weibaogongsi = weibaogongsiService.selectOne(new EntityWrapper<WeibaogongsiEntity>().eq("username", username));
        if(weibaogongsi==null || !weibaogongsi.getPassword().equals(MD5Utils.md5(password)))
            return R.error("账号或密码不正确");
        else if(weibaogongsi.getJinyongTypes() != 1)
            return R.error("账户已被禁用");
        String token = tokenService.generateToken(weibaogongsi.getId(),username, "weibaogongsi", "维保公司");
        R r = R.ok();
        r.put("token", token);
        r.put("role","维保公司");
        r.put("username",weibaogongsi.getWeibaogongsiName());
        r.put("tableName","weibaogongsi");
        r.put("userId",weibaogongsi.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody WeibaogongsiEntity weibaogongsi, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<WeibaogongsiEntity> queryWrapper = new EntityWrapper<WeibaogongsiEntity>()
            .eq("username", weibaogongsi.getUsername())
            .or()
            .eq("weibaogongsi_phone", weibaogongsi.getWeibaogongsiPhone())
            ;
        WeibaogongsiEntity weibaogongsiEntity = weibaogongsiService.selectOne(queryWrapper);
        if(weibaogongsiEntity != null)
            return R.error("账户或者维保公司手机号已经被使用");
        weibaogongsi.setWeibaogongsiUuidNumber(String.valueOf(new Date().getTime()));
        weibaogongsi.setPassword(MD5Utils.md5(weibaogongsi.getPassword()));
        weibaogongsi.setJinyongTypes(1);//启用
        weibaogongsi.setCreateTime(new Date());
        weibaogongsiService.insert(weibaogongsi);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        WeibaogongsiEntity weibaogongsi = weibaogongsiService.selectById(id);
        weibaogongsi.setPassword(MD5Utils.md5("123456"));
        weibaogongsiService.updateById(weibaogongsi);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        WeibaogongsiEntity weibaogongsi = weibaogongsiService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!MD5Utils.md5(oldPassword).equals(weibaogongsi.getPassword())){
			return R.error("原密码输入错误");
		}
		if(MD5Utils.md5(newPassword).equals(weibaogongsi.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        weibaogongsi.setPassword(MD5Utils.md5(newPassword));
		weibaogongsiService.updateById(weibaogongsi);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        WeibaogongsiEntity weibaogongsi = weibaogongsiService.selectOne(new EntityWrapper<WeibaogongsiEntity>().eq("username", username));
        if(weibaogongsi!=null){
            weibaogongsi.setPassword(MD5Utils.md5("123456"));
            weibaogongsiService.updateById(weibaogongsi);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrWeibaogongsi(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        WeibaogongsiEntity weibaogongsi = weibaogongsiService.selectById(id);
        if(weibaogongsi !=null){
            //entity转view
            WeibaogongsiView view = new WeibaogongsiView();
            BeanUtils.copyProperties( weibaogongsi , view );//把实体数据重构到view中

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

