package com.entity.vo;

import com.entity.WeibaorenyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 维保人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("weibaorenyuan")
public class WeibaorenyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 维保公司
     */

    @TableField(value = "weibaogongsi_id")
    private Integer weibaogongsiId;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 维保人员编号
     */

    @TableField(value = "weibaorenyuan_uuid_number")
    private String weibaorenyuanUuidNumber;


    /**
     * 维保人员姓名
     */

    @TableField(value = "weibaorenyuan_name")
    private String weibaorenyuanName;


    /**
     * 维保人员手机号
     */

    @TableField(value = "weibaorenyuan_phone")
    private String weibaorenyuanPhone;


    /**
     * 维保人员身份证号
     */

    @TableField(value = "weibaorenyuan_id_number")
    private String weibaorenyuanIdNumber;


    /**
     * 维保人员头像
     */

    @TableField(value = "weibaorenyuan_photo")
    private String weibaorenyuanPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 维保人员邮箱
     */

    @TableField(value = "weibaorenyuan_email")
    private String weibaorenyuanEmail;


    /**
     * 账户状态
     */

    @TableField(value = "jinyong_types")
    private Integer jinyongTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：维保公司
	 */
    public Integer getWeibaogongsiId() {
        return weibaogongsiId;
    }


    /**
	 * 获取：维保公司
	 */

    public void setWeibaogongsiId(Integer weibaogongsiId) {
        this.weibaogongsiId = weibaogongsiId;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：维保人员编号
	 */
    public String getWeibaorenyuanUuidNumber() {
        return weibaorenyuanUuidNumber;
    }


    /**
	 * 获取：维保人员编号
	 */

    public void setWeibaorenyuanUuidNumber(String weibaorenyuanUuidNumber) {
        this.weibaorenyuanUuidNumber = weibaorenyuanUuidNumber;
    }
    /**
	 * 设置：维保人员姓名
	 */
    public String getWeibaorenyuanName() {
        return weibaorenyuanName;
    }


    /**
	 * 获取：维保人员姓名
	 */

    public void setWeibaorenyuanName(String weibaorenyuanName) {
        this.weibaorenyuanName = weibaorenyuanName;
    }
    /**
	 * 设置：维保人员手机号
	 */
    public String getWeibaorenyuanPhone() {
        return weibaorenyuanPhone;
    }


    /**
	 * 获取：维保人员手机号
	 */

    public void setWeibaorenyuanPhone(String weibaorenyuanPhone) {
        this.weibaorenyuanPhone = weibaorenyuanPhone;
    }
    /**
	 * 设置：维保人员身份证号
	 */
    public String getWeibaorenyuanIdNumber() {
        return weibaorenyuanIdNumber;
    }


    /**
	 * 获取：维保人员身份证号
	 */

    public void setWeibaorenyuanIdNumber(String weibaorenyuanIdNumber) {
        this.weibaorenyuanIdNumber = weibaorenyuanIdNumber;
    }
    /**
	 * 设置：维保人员头像
	 */
    public String getWeibaorenyuanPhoto() {
        return weibaorenyuanPhoto;
    }


    /**
	 * 获取：维保人员头像
	 */

    public void setWeibaorenyuanPhoto(String weibaorenyuanPhoto) {
        this.weibaorenyuanPhoto = weibaorenyuanPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：维保人员邮箱
	 */
    public String getWeibaorenyuanEmail() {
        return weibaorenyuanEmail;
    }


    /**
	 * 获取：维保人员邮箱
	 */

    public void setWeibaorenyuanEmail(String weibaorenyuanEmail) {
        this.weibaorenyuanEmail = weibaorenyuanEmail;
    }
    /**
	 * 设置：账户状态
	 */
    public Integer getJinyongTypes() {
        return jinyongTypes;
    }


    /**
	 * 获取：账户状态
	 */

    public void setJinyongTypes(Integer jinyongTypes) {
        this.jinyongTypes = jinyongTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
