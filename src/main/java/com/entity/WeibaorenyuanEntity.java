package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 维保人员
 *
 * @author 
 * @email
 */
@TableName("weibaorenyuan")
public class WeibaorenyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WeibaorenyuanEntity() {

	}

	public WeibaorenyuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 维保公司
     */
    @ColumnInfo(comment="维保公司",type="int(11)")
    @TableField(value = "weibaogongsi_id")

    private Integer weibaogongsiId;


    /**
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 维保人员编号
     */
    @ColumnInfo(comment="维保人员编号",type="varchar(200)")
    @TableField(value = "weibaorenyuan_uuid_number")

    private String weibaorenyuanUuidNumber;


    /**
     * 维保人员姓名
     */
    @ColumnInfo(comment="维保人员姓名",type="varchar(200)")
    @TableField(value = "weibaorenyuan_name")

    private String weibaorenyuanName;


    /**
     * 维保人员手机号
     */
    @ColumnInfo(comment="维保人员手机号",type="varchar(200)")
    @TableField(value = "weibaorenyuan_phone")

    private String weibaorenyuanPhone;


    /**
     * 维保人员身份证号
     */
    @ColumnInfo(comment="维保人员身份证号",type="varchar(200)")
    @TableField(value = "weibaorenyuan_id_number")

    private String weibaorenyuanIdNumber;


    /**
     * 维保人员头像
     */
    @ColumnInfo(comment="维保人员头像",type="varchar(200)")
    @TableField(value = "weibaorenyuan_photo")

    private String weibaorenyuanPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 维保人员邮箱
     */
    @ColumnInfo(comment="维保人员邮箱",type="varchar(200)")
    @TableField(value = "weibaorenyuan_email")

    private String weibaorenyuanEmail;


    /**
     * 账户状态
     */
    @ColumnInfo(comment="账户状态",type="int(11)")
    @TableField(value = "jinyong_types")

    private Integer jinyongTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Weibaorenyuan{" +
            ", id=" + id +
            ", weibaogongsiId=" + weibaogongsiId +
            ", username=" + username +
            ", password=" + password +
            ", weibaorenyuanUuidNumber=" + weibaorenyuanUuidNumber +
            ", weibaorenyuanName=" + weibaorenyuanName +
            ", weibaorenyuanPhone=" + weibaorenyuanPhone +
            ", weibaorenyuanIdNumber=" + weibaorenyuanIdNumber +
            ", weibaorenyuanPhoto=" + weibaorenyuanPhoto +
            ", sexTypes=" + sexTypes +
            ", weibaorenyuanEmail=" + weibaorenyuanEmail +
            ", jinyongTypes=" + jinyongTypes +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
