package com.entity.vo;

import com.entity.ChuanjiaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 船家
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chuanjia")
public class ChuanjiaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


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
     * 船家编号
     */

    @TableField(value = "chuanjia_uuid_number")
    private String chuanjiaUuidNumber;


    /**
     * 船家姓名
     */

    @TableField(value = "chuanjia_name")
    private String chuanjiaName;


    /**
     * 船家手机号
     */

    @TableField(value = "chuanjia_phone")
    private String chuanjiaPhone;


    /**
     * 船家身份证号
     */

    @TableField(value = "chuanjia_id_number")
    private String chuanjiaIdNumber;


    /**
     * 船家头像
     */

    @TableField(value = "chuanjia_photo")
    private String chuanjiaPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 船家邮箱
     */

    @TableField(value = "chuanjia_email")
    private String chuanjiaEmail;


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
	 * 设置：船家编号
	 */
    public String getChuanjiaUuidNumber() {
        return chuanjiaUuidNumber;
    }


    /**
	 * 获取：船家编号
	 */

    public void setChuanjiaUuidNumber(String chuanjiaUuidNumber) {
        this.chuanjiaUuidNumber = chuanjiaUuidNumber;
    }
    /**
	 * 设置：船家姓名
	 */
    public String getChuanjiaName() {
        return chuanjiaName;
    }


    /**
	 * 获取：船家姓名
	 */

    public void setChuanjiaName(String chuanjiaName) {
        this.chuanjiaName = chuanjiaName;
    }
    /**
	 * 设置：船家手机号
	 */
    public String getChuanjiaPhone() {
        return chuanjiaPhone;
    }


    /**
	 * 获取：船家手机号
	 */

    public void setChuanjiaPhone(String chuanjiaPhone) {
        this.chuanjiaPhone = chuanjiaPhone;
    }
    /**
	 * 设置：船家身份证号
	 */
    public String getChuanjiaIdNumber() {
        return chuanjiaIdNumber;
    }


    /**
	 * 获取：船家身份证号
	 */

    public void setChuanjiaIdNumber(String chuanjiaIdNumber) {
        this.chuanjiaIdNumber = chuanjiaIdNumber;
    }
    /**
	 * 设置：船家头像
	 */
    public String getChuanjiaPhoto() {
        return chuanjiaPhoto;
    }


    /**
	 * 获取：船家头像
	 */

    public void setChuanjiaPhoto(String chuanjiaPhoto) {
        this.chuanjiaPhoto = chuanjiaPhoto;
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
	 * 设置：船家邮箱
	 */
    public String getChuanjiaEmail() {
        return chuanjiaEmail;
    }


    /**
	 * 获取：船家邮箱
	 */

    public void setChuanjiaEmail(String chuanjiaEmail) {
        this.chuanjiaEmail = chuanjiaEmail;
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
