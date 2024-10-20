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
 * 船舶
 *
 * @author 
 * @email
 */
@TableName("chaunbo")
public class ChaunboEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChaunboEntity() {

	}

	public ChaunboEntity(T t) {
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
     * 船家
     */
    @ColumnInfo(comment="船家",type="int(11)")
    @TableField(value = "chuanjia_id")

    private Integer chuanjiaId;


    /**
     * 维保公司
     */
    @ColumnInfo(comment="维保公司",type="int(11)")
    @TableField(value = "weibaogongsi_id")

    private Integer weibaogongsiId;


    /**
     * 船舶编号
     */
    @ColumnInfo(comment="船舶编号",type="varchar(200)")
    @TableField(value = "chaunbo_uuid_number")

    private String chaunboUuidNumber;


    /**
     * 船舶名字
     */
    @ColumnInfo(comment="船舶名字",type="varchar(200)")
    @TableField(value = "chaunbo_name")

    private String chaunboName;


    /**
     * 船舶照片
     */
    @ColumnInfo(comment="船舶照片",type="varchar(200)")
    @TableField(value = "chaunbo_photo")

    private String chaunboPhoto;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "chaunbo_file")

    private String chaunboFile;


    /**
     * 船舶类型
     */
    @ColumnInfo(comment="船舶类型",type="int(11)")
    @TableField(value = "chaunbo_types")

    private Integer chaunboTypes;


    /**
     * 船舶状态
     */
    @ColumnInfo(comment="船舶状态",type="int(11)")
    @TableField(value = "chaunbo_zhuangtai_types")

    private Integer chaunboZhuangtaiTypes;


    /**
     * 船舶介绍
     */
    @ColumnInfo(comment="船舶介绍",type="longtext")
    @TableField(value = "chaunbo_content")

    private String chaunboContent;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="上传时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：船家
	 */
    public Integer getChuanjiaId() {
        return chuanjiaId;
    }
    /**
	 * 设置：船家
	 */

    public void setChuanjiaId(Integer chuanjiaId) {
        this.chuanjiaId = chuanjiaId;
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
	 * 获取：船舶编号
	 */
    public String getChaunboUuidNumber() {
        return chaunboUuidNumber;
    }
    /**
	 * 设置：船舶编号
	 */

    public void setChaunboUuidNumber(String chaunboUuidNumber) {
        this.chaunboUuidNumber = chaunboUuidNumber;
    }
    /**
	 * 获取：船舶名字
	 */
    public String getChaunboName() {
        return chaunboName;
    }
    /**
	 * 设置：船舶名字
	 */

    public void setChaunboName(String chaunboName) {
        this.chaunboName = chaunboName;
    }
    /**
	 * 获取：船舶照片
	 */
    public String getChaunboPhoto() {
        return chaunboPhoto;
    }
    /**
	 * 设置：船舶照片
	 */

    public void setChaunboPhoto(String chaunboPhoto) {
        this.chaunboPhoto = chaunboPhoto;
    }
    /**
	 * 获取：附件
	 */
    public String getChaunboFile() {
        return chaunboFile;
    }
    /**
	 * 设置：附件
	 */

    public void setChaunboFile(String chaunboFile) {
        this.chaunboFile = chaunboFile;
    }
    /**
	 * 获取：船舶类型
	 */
    public Integer getChaunboTypes() {
        return chaunboTypes;
    }
    /**
	 * 设置：船舶类型
	 */

    public void setChaunboTypes(Integer chaunboTypes) {
        this.chaunboTypes = chaunboTypes;
    }
    /**
	 * 获取：船舶状态
	 */
    public Integer getChaunboZhuangtaiTypes() {
        return chaunboZhuangtaiTypes;
    }
    /**
	 * 设置：船舶状态
	 */

    public void setChaunboZhuangtaiTypes(Integer chaunboZhuangtaiTypes) {
        this.chaunboZhuangtaiTypes = chaunboZhuangtaiTypes;
    }
    /**
	 * 获取：船舶介绍
	 */
    public String getChaunboContent() {
        return chaunboContent;
    }
    /**
	 * 设置：船舶介绍
	 */

    public void setChaunboContent(String chaunboContent) {
        this.chaunboContent = chaunboContent;
    }
    /**
	 * 获取：上传时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：上传时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Chaunbo{" +
            ", id=" + id +
            ", chuanjiaId=" + chuanjiaId +
            ", weibaogongsiId=" + weibaogongsiId +
            ", chaunboUuidNumber=" + chaunboUuidNumber +
            ", chaunboName=" + chaunboName +
            ", chaunboPhoto=" + chaunboPhoto +
            ", chaunboFile=" + chaunboFile +
            ", chaunboTypes=" + chaunboTypes +
            ", chaunboZhuangtaiTypes=" + chaunboZhuangtaiTypes +
            ", chaunboContent=" + chaunboContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
