package com.entity.model;

import com.entity.WeibaorenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 维保人员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WeibaorenyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 维保公司
     */
    private Integer weibaogongsiId;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 维保人员编号
     */
    private String weibaorenyuanUuidNumber;


    /**
     * 维保人员姓名
     */
    private String weibaorenyuanName;


    /**
     * 维保人员手机号
     */
    private String weibaorenyuanPhone;


    /**
     * 维保人员身份证号
     */
    private String weibaorenyuanIdNumber;


    /**
     * 维保人员头像
     */
    private String weibaorenyuanPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 维保人员邮箱
     */
    private String weibaorenyuanEmail;


    /**
     * 账户状态
     */
    private Integer jinyongTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：维保公司
	 */
    public Integer getWeibaogongsiId() {
        return weibaogongsiId;
    }


    /**
	 * 设置：维保公司
	 */
    public void setWeibaogongsiId(Integer weibaogongsiId) {
        this.weibaogongsiId = weibaogongsiId;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：维保人员编号
	 */
    public String getWeibaorenyuanUuidNumber() {
        return weibaorenyuanUuidNumber;
    }


    /**
	 * 设置：维保人员编号
	 */
    public void setWeibaorenyuanUuidNumber(String weibaorenyuanUuidNumber) {
        this.weibaorenyuanUuidNumber = weibaorenyuanUuidNumber;
    }
    /**
	 * 获取：维保人员姓名
	 */
    public String getWeibaorenyuanName() {
        return weibaorenyuanName;
    }


    /**
	 * 设置：维保人员姓名
	 */
    public void setWeibaorenyuanName(String weibaorenyuanName) {
        this.weibaorenyuanName = weibaorenyuanName;
    }
    /**
	 * 获取：维保人员手机号
	 */
    public String getWeibaorenyuanPhone() {
        return weibaorenyuanPhone;
    }


    /**
	 * 设置：维保人员手机号
	 */
    public void setWeibaorenyuanPhone(String weibaorenyuanPhone) {
        this.weibaorenyuanPhone = weibaorenyuanPhone;
    }
    /**
	 * 获取：维保人员身份证号
	 */
    public String getWeibaorenyuanIdNumber() {
        return weibaorenyuanIdNumber;
    }


    /**
	 * 设置：维保人员身份证号
	 */
    public void setWeibaorenyuanIdNumber(String weibaorenyuanIdNumber) {
        this.weibaorenyuanIdNumber = weibaorenyuanIdNumber;
    }
    /**
	 * 获取：维保人员头像
	 */
    public String getWeibaorenyuanPhoto() {
        return weibaorenyuanPhoto;
    }


    /**
	 * 设置：维保人员头像
	 */
    public void setWeibaorenyuanPhoto(String weibaorenyuanPhoto) {
        this.weibaorenyuanPhoto = weibaorenyuanPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：维保人员邮箱
	 */
    public String getWeibaorenyuanEmail() {
        return weibaorenyuanEmail;
    }


    /**
	 * 设置：维保人员邮箱
	 */
    public void setWeibaorenyuanEmail(String weibaorenyuanEmail) {
        this.weibaorenyuanEmail = weibaorenyuanEmail;
    }
    /**
	 * 获取：账户状态
	 */
    public Integer getJinyongTypes() {
        return jinyongTypes;
    }


    /**
	 * 设置：账户状态
	 */
    public void setJinyongTypes(Integer jinyongTypes) {
        this.jinyongTypes = jinyongTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
