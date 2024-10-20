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
 * 维保公司
 *
 * @author 
 * @email
 */
@TableName("weibaogongsi")
public class WeibaogongsiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WeibaogongsiEntity() {

	}

	public WeibaogongsiEntity(T t) {
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
     * 维保公司编号
     */
    @ColumnInfo(comment="维保公司编号",type="varchar(200)")
    @TableField(value = "weibaogongsi_uuid_number")

    private String weibaogongsiUuidNumber;


    /**
     * 维保公司名称
     */
    @ColumnInfo(comment="维保公司名称",type="varchar(200)")
    @TableField(value = "weibaogongsi_name")

    private String weibaogongsiName;


    /**
     * 负责人
     */
    @ColumnInfo(comment="负责人",type="varchar(200)")
    @TableField(value = "weibaogongsi_fuzeren")

    private String weibaogongsiFuzeren;


    /**
     * 维保公司手机号
     */
    @ColumnInfo(comment="维保公司手机号",type="varchar(200)")
    @TableField(value = "weibaogongsi_phone")

    private String weibaogongsiPhone;


    /**
     * 公司logo
     */
    @ColumnInfo(comment="公司logo",type="varchar(200)")
    @TableField(value = "weibaogongsi_photo")

    private String weibaogongsiPhoto;


    /**
     * 公司位置
     */
    @ColumnInfo(comment="公司位置",type="varchar(200)")
    @TableField(value = "weibaogongsi_address")

    private String weibaogongsiAddress;


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

    @Override
    public String toString() {
        return "Weibaogongsi{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", weibaogongsiUuidNumber=" + weibaogongsiUuidNumber +
            ", weibaogongsiName=" + weibaogongsiName +
            ", weibaogongsiFuzeren=" + weibaogongsiFuzeren +
            ", weibaogongsiPhone=" + weibaogongsiPhone +
            ", weibaogongsiPhoto=" + weibaogongsiPhoto +
            ", weibaogongsiAddress=" + weibaogongsiAddress +
            ", jinyongTypes=" + jinyongTypes +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
