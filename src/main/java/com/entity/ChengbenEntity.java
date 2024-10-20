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
 * 维修成本
 *
 * @author 
 * @email
 */
@TableName("chengben")
public class ChengbenEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChengbenEntity() {

	}

	public ChengbenEntity(T t) {
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
     * 故障
     */
    @ColumnInfo(comment="故障",type="int(11)")
    @TableField(value = "guzhang_id")

    private Integer guzhangId;


    /**
     * 维修成本编号
     */
    @ColumnInfo(comment="维修成本编号",type="varchar(200)")
    @TableField(value = "chengben_uuid_number")

    private String chengbenUuidNumber;


    /**
     * 维修成本类型
     */
    @ColumnInfo(comment="维修成本类型",type="int(11)")
    @TableField(value = "chengben_types")

    private Integer chengbenTypes;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "chengben_file")

    private String chengbenFile;


    /**
     * 金额
     */
    @ColumnInfo(comment="金额",type="decimal(10,2)")
    @TableField(value = "chengben_jine")

    private Double chengbenJine;


    /**
     * 花费时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="花费时间",type="timestamp")
    @TableField(value = "chengben_time")

    private Date chengbenTime;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="longtext")
    @TableField(value = "chengben_content")

    private String chengbenContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
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
	 * 获取：故障
	 */
    public Integer getGuzhangId() {
        return guzhangId;
    }
    /**
	 * 设置：故障
	 */

    public void setGuzhangId(Integer guzhangId) {
        this.guzhangId = guzhangId;
    }
    /**
	 * 获取：维修成本编号
	 */
    public String getChengbenUuidNumber() {
        return chengbenUuidNumber;
    }
    /**
	 * 设置：维修成本编号
	 */

    public void setChengbenUuidNumber(String chengbenUuidNumber) {
        this.chengbenUuidNumber = chengbenUuidNumber;
    }
    /**
	 * 获取：维修成本类型
	 */
    public Integer getChengbenTypes() {
        return chengbenTypes;
    }
    /**
	 * 设置：维修成本类型
	 */

    public void setChengbenTypes(Integer chengbenTypes) {
        this.chengbenTypes = chengbenTypes;
    }
    /**
	 * 获取：附件
	 */
    public String getChengbenFile() {
        return chengbenFile;
    }
    /**
	 * 设置：附件
	 */

    public void setChengbenFile(String chengbenFile) {
        this.chengbenFile = chengbenFile;
    }
    /**
	 * 获取：金额
	 */
    public Double getChengbenJine() {
        return chengbenJine;
    }
    /**
	 * 设置：金额
	 */

    public void setChengbenJine(Double chengbenJine) {
        this.chengbenJine = chengbenJine;
    }
    /**
	 * 获取：花费时间
	 */
    public Date getChengbenTime() {
        return chengbenTime;
    }
    /**
	 * 设置：花费时间
	 */

    public void setChengbenTime(Date chengbenTime) {
        this.chengbenTime = chengbenTime;
    }
    /**
	 * 获取：备注
	 */
    public String getChengbenContent() {
        return chengbenContent;
    }
    /**
	 * 设置：备注
	 */

    public void setChengbenContent(String chengbenContent) {
        this.chengbenContent = chengbenContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
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
        return "Chengben{" +
            ", id=" + id +
            ", guzhangId=" + guzhangId +
            ", chengbenUuidNumber=" + chengbenUuidNumber +
            ", chengbenTypes=" + chengbenTypes +
            ", chengbenFile=" + chengbenFile +
            ", chengbenJine=" + chengbenJine +
            ", chengbenTime=" + DateUtil.convertString(chengbenTime,"yyyy-MM-dd") +
            ", chengbenContent=" + chengbenContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
