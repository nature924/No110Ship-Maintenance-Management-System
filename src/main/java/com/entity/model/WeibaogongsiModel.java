package com.entity.model;

import com.entity.WeibaogongsiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 维保公司
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WeibaogongsiModel implements Serializable {
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
     * 维保公司编号
     */
    private String weibaogongsiUuidNumber;


    /**
     * 维保公司名称
     */
    private String weibaogongsiName;


    /**
     * 负责人
     */
    private String weibaogongsiFuzeren;


    /**
     * 维保公司手机号
     */
    private String weibaogongsiPhone;


    /**
     * 公司logo
     */
    private String weibaogongsiPhoto;


    /**
     * 公司位置
     */
    private String weibaogongsiAddress;


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
	 * 获取：维保公司编号
	 */
    public String getWeibaogongsiUuidNumber() {
        return weibaogongsiUuidNumber;
    }


    /**
	 * 设置：维保公司编号
	 */
    public void setWeibaogongsiUuidNumber(String weibaogongsiUuidNumber) {
        this.weibaogongsiUuidNumber = weibaogongsiUuidNumber;
    }
    /**
	 * 获取：维保公司名称
	 */
    public String getWeibaogongsiName() {
        return weibaogongsiName;
    }


    /**
	 * 设置：维保公司名称
	 */
    public void setWeibaogongsiName(String weibaogongsiName) {
        this.weibaogongsiName = weibaogongsiName;
    }
    /**
	 * 获取：负责人
	 */
    public String getWeibaogongsiFuzeren() {
        return weibaogongsiFuzeren;
    }


    /**
	 * 设置：负责人
	 */
    public void setWeibaogongsiFuzeren(String weibaogongsiFuzeren) {
        this.weibaogongsiFuzeren = weibaogongsiFuzeren;
    }
    /**
	 * 获取：维保公司手机号
	 */
    public String getWeibaogongsiPhone() {
        return weibaogongsiPhone;
    }


    /**
	 * 设置：维保公司手机号
	 */
    public void setWeibaogongsiPhone(String weibaogongsiPhone) {
        this.weibaogongsiPhone = weibaogongsiPhone;
    }
    /**
	 * 获取：公司logo
	 */
    public String getWeibaogongsiPhoto() {
        return weibaogongsiPhoto;
    }


    /**
	 * 设置：公司logo
	 */
    public void setWeibaogongsiPhoto(String weibaogongsiPhoto) {
        this.weibaogongsiPhoto = weibaogongsiPhoto;
    }
    /**
	 * 获取：公司位置
	 */
    public String getWeibaogongsiAddress() {
        return weibaogongsiAddress;
    }


    /**
	 * 设置：公司位置
	 */
    public void setWeibaogongsiAddress(String weibaogongsiAddress) {
        this.weibaogongsiAddress = weibaogongsiAddress;
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
