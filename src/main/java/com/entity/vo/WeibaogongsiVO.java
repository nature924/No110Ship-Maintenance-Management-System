package com.entity.vo;

import com.entity.WeibaogongsiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 维保公司
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("weibaogongsi")
public class WeibaogongsiVO implements Serializable {
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
     * 维保公司编号
     */

    @TableField(value = "weibaogongsi_uuid_number")
    private String weibaogongsiUuidNumber;


    /**
     * 维保公司名称
     */

    @TableField(value = "weibaogongsi_name")
    private String weibaogongsiName;


    /**
     * 负责人
     */

    @TableField(value = "weibaogongsi_fuzeren")
    private String weibaogongsiFuzeren;


    /**
     * 维保公司手机号
     */

    @TableField(value = "weibaogongsi_phone")
    private String weibaogongsiPhone;


    /**
     * 公司logo
     */

    @TableField(value = "weibaogongsi_photo")
    private String weibaogongsiPhoto;


    /**
     * 公司位置
     */

    @TableField(value = "weibaogongsi_address")
    private String weibaogongsiAddress;


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
	 * 设置：维保公司编号
	 */
    public String getWeibaogongsiUuidNumber() {
        return weibaogongsiUuidNumber;
    }


    /**
	 * 获取：维保公司编号
	 */

    public void setWeibaogongsiUuidNumber(String weibaogongsiUuidNumber) {
        this.weibaogongsiUuidNumber = weibaogongsiUuidNumber;
    }
    /**
	 * 设置：维保公司名称
	 */
    public String getWeibaogongsiName() {
        return weibaogongsiName;
    }


    /**
	 * 获取：维保公司名称
	 */

    public void setWeibaogongsiName(String weibaogongsiName) {
        this.weibaogongsiName = weibaogongsiName;
    }
    /**
	 * 设置：负责人
	 */
    public String getWeibaogongsiFuzeren() {
        return weibaogongsiFuzeren;
    }


    /**
	 * 获取：负责人
	 */

    public void setWeibaogongsiFuzeren(String weibaogongsiFuzeren) {
        this.weibaogongsiFuzeren = weibaogongsiFuzeren;
    }
    /**
	 * 设置：维保公司手机号
	 */
    public String getWeibaogongsiPhone() {
        return weibaogongsiPhone;
    }


    /**
	 * 获取：维保公司手机号
	 */

    public void setWeibaogongsiPhone(String weibaogongsiPhone) {
        this.weibaogongsiPhone = weibaogongsiPhone;
    }
    /**
	 * 设置：公司logo
	 */
    public String getWeibaogongsiPhoto() {
        return weibaogongsiPhoto;
    }


    /**
	 * 获取：公司logo
	 */

    public void setWeibaogongsiPhoto(String weibaogongsiPhoto) {
        this.weibaogongsiPhoto = weibaogongsiPhoto;
    }
    /**
	 * 设置：公司位置
	 */
    public String getWeibaogongsiAddress() {
        return weibaogongsiAddress;
    }


    /**
	 * 获取：公司位置
	 */

    public void setWeibaogongsiAddress(String weibaogongsiAddress) {
        this.weibaogongsiAddress = weibaogongsiAddress;
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
