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
 * 故障上报
 *
 * @author 
 * @email
 */
@TableName("guzhang")
public class GuzhangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GuzhangEntity() {

	}

	public GuzhangEntity(T t) {
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
     * 船舶
     */
    @ColumnInfo(comment="船舶",type="int(11)")
    @TableField(value = "chaunbo_id")

    private Integer chaunboId;


    /**
     * 维保人员
     */
    @ColumnInfo(comment="维保人员",type="int(11)")
    @TableField(value = "weibaorenyuan_id")

    private Integer weibaorenyuanId;


    /**
     * 故障编号
     */
    @ColumnInfo(comment="故障编号",type="varchar(200)")
    @TableField(value = "guzhang_uuid_number")

    private String guzhangUuidNumber;


    /**
     * 故障标题
     */
    @ColumnInfo(comment="故障标题",type="varchar(200)")
    @TableField(value = "guzhang_name")

    private String guzhangName;


    /**
     * 故障照片
     */
    @ColumnInfo(comment="故障照片",type="varchar(200)")
    @TableField(value = "guzhang_photo")

    private String guzhangPhoto;


    /**
     * 故障位置
     */
    @ColumnInfo(comment="故障位置",type="varchar(200)")
    @TableField(value = "guzhang_address")

    private String guzhangAddress;


    /**
     * 故障类型
     */
    @ColumnInfo(comment="故障类型",type="int(11)")
    @TableField(value = "guzhang_types")

    private Integer guzhangTypes;


    /**
     * 故障内容
     */
    @ColumnInfo(comment="故障内容",type="longtext")
    @TableField(value = "guzhang_content")

    private String guzhangContent;


    /**
     * 故障状态
     */
    @ColumnInfo(comment="故障状态",type="int(11)")
    @TableField(value = "guzhang_zhuangtai_types")

    private Integer guzhangZhuangtaiTypes;


    /**
     * 报修时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="报修时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 维修评价
     */
    @ColumnInfo(comment="维修评价",type="longtext")
    @TableField(value = "guzhang_text")

    private String guzhangText;


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
	 * 获取：船舶
	 */
    public Integer getChaunboId() {
        return chaunboId;
    }
    /**
	 * 设置：船舶
	 */

    public void setChaunboId(Integer chaunboId) {
        this.chaunboId = chaunboId;
    }
    /**
	 * 获取：维保人员
	 */
    public Integer getWeibaorenyuanId() {
        return weibaorenyuanId;
    }
    /**
	 * 设置：维保人员
	 */

    public void setWeibaorenyuanId(Integer weibaorenyuanId) {
        this.weibaorenyuanId = weibaorenyuanId;
    }
    /**
	 * 获取：故障编号
	 */
    public String getGuzhangUuidNumber() {
        return guzhangUuidNumber;
    }
    /**
	 * 设置：故障编号
	 */

    public void setGuzhangUuidNumber(String guzhangUuidNumber) {
        this.guzhangUuidNumber = guzhangUuidNumber;
    }
    /**
	 * 获取：故障标题
	 */
    public String getGuzhangName() {
        return guzhangName;
    }
    /**
	 * 设置：故障标题
	 */

    public void setGuzhangName(String guzhangName) {
        this.guzhangName = guzhangName;
    }
    /**
	 * 获取：故障照片
	 */
    public String getGuzhangPhoto() {
        return guzhangPhoto;
    }
    /**
	 * 设置：故障照片
	 */

    public void setGuzhangPhoto(String guzhangPhoto) {
        this.guzhangPhoto = guzhangPhoto;
    }
    /**
	 * 获取：故障位置
	 */
    public String getGuzhangAddress() {
        return guzhangAddress;
    }
    /**
	 * 设置：故障位置
	 */

    public void setGuzhangAddress(String guzhangAddress) {
        this.guzhangAddress = guzhangAddress;
    }
    /**
	 * 获取：故障类型
	 */
    public Integer getGuzhangTypes() {
        return guzhangTypes;
    }
    /**
	 * 设置：故障类型
	 */

    public void setGuzhangTypes(Integer guzhangTypes) {
        this.guzhangTypes = guzhangTypes;
    }
    /**
	 * 获取：故障内容
	 */
    public String getGuzhangContent() {
        return guzhangContent;
    }
    /**
	 * 设置：故障内容
	 */

    public void setGuzhangContent(String guzhangContent) {
        this.guzhangContent = guzhangContent;
    }
    /**
	 * 获取：故障状态
	 */
    public Integer getGuzhangZhuangtaiTypes() {
        return guzhangZhuangtaiTypes;
    }
    /**
	 * 设置：故障状态
	 */

    public void setGuzhangZhuangtaiTypes(Integer guzhangZhuangtaiTypes) {
        this.guzhangZhuangtaiTypes = guzhangZhuangtaiTypes;
    }
    /**
	 * 获取：报修时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：报修时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：维修评价
	 */
    public String getGuzhangText() {
        return guzhangText;
    }
    /**
	 * 设置：维修评价
	 */

    public void setGuzhangText(String guzhangText) {
        this.guzhangText = guzhangText;
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
        return "Guzhang{" +
            ", id=" + id +
            ", chaunboId=" + chaunboId +
            ", weibaorenyuanId=" + weibaorenyuanId +
            ", guzhangUuidNumber=" + guzhangUuidNumber +
            ", guzhangName=" + guzhangName +
            ", guzhangPhoto=" + guzhangPhoto +
            ", guzhangAddress=" + guzhangAddress +
            ", guzhangTypes=" + guzhangTypes +
            ", guzhangContent=" + guzhangContent +
            ", guzhangZhuangtaiTypes=" + guzhangZhuangtaiTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", guzhangText=" + guzhangText +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
