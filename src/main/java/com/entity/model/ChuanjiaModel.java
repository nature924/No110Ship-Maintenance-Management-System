package com.entity.model;

import com.entity.ChuanjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 船家
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChuanjiaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 船家编号
     */
    private String chuanjiaUuidNumber;


    /**
     * 船家姓名
     */
    private String chuanjiaName;


    /**
     * 船家手机号
     */
    private String chuanjiaPhone;


    /**
     * 船家身份证号
     */
    private String chuanjiaIdNumber;


    /**
     * 船家头像
     */
    private String chuanjiaPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 船家邮箱
     */
    private String chuanjiaEmail;


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
	 * 获取：船家编号
	 */
    public String getChuanjiaUuidNumber() {
        return chuanjiaUuidNumber;
    }


    /**
	 * 设置：船家编号
	 */
    public void setChuanjiaUuidNumber(String chuanjiaUuidNumber) {
        this.chuanjiaUuidNumber = chuanjiaUuidNumber;
    }
    /**
	 * 获取：船家姓名
	 */
    public String getChuanjiaName() {
        return chuanjiaName;
    }


    /**
	 * 设置：船家姓名
	 */
    public void setChuanjiaName(String chuanjiaName) {
        this.chuanjiaName = chuanjiaName;
    }
    /**
	 * 获取：船家手机号
	 */
    public String getChuanjiaPhone() {
        return chuanjiaPhone;
    }


    /**
	 * 设置：船家手机号
	 */
    public void setChuanjiaPhone(String chuanjiaPhone) {
        this.chuanjiaPhone = chuanjiaPhone;
    }
    /**
	 * 获取：船家身份证号
	 */
    public String getChuanjiaIdNumber() {
        return chuanjiaIdNumber;
    }


    /**
	 * 设置：船家身份证号
	 */
    public void setChuanjiaIdNumber(String chuanjiaIdNumber) {
        this.chuanjiaIdNumber = chuanjiaIdNumber;
    }
    /**
	 * 获取：船家头像
	 */
    public String getChuanjiaPhoto() {
        return chuanjiaPhoto;
    }


    /**
	 * 设置：船家头像
	 */
    public void setChuanjiaPhoto(String chuanjiaPhoto) {
        this.chuanjiaPhoto = chuanjiaPhoto;
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
	 * 获取：船家邮箱
	 */
    public String getChuanjiaEmail() {
        return chuanjiaEmail;
    }


    /**
	 * 设置：船家邮箱
	 */
    public void setChuanjiaEmail(String chuanjiaEmail) {
        this.chuanjiaEmail = chuanjiaEmail;
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
