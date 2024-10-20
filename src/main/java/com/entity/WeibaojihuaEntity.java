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
 * 维保计划
 *
 * @author 
 * @email
 */
@TableName("weibaojihua")
public class WeibaojihuaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WeibaojihuaEntity() {

	}

	public WeibaojihuaEntity(T t) {
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
     * 维保公司
     */
    @ColumnInfo(comment="维保公司",type="int(11)")
    @TableField(value = "weibaogongsi_id")

    private Integer weibaogongsiId;


    /**
     * 维保人员
     */
    @ColumnInfo(comment="维保人员",type="int(11)")
    @TableField(value = "weibaorenyuan_id")

    private Integer weibaorenyuanId;


    /**
     * 维保计划编号
     */
    @ColumnInfo(comment="维保计划编号",type="varchar(200)")
    @TableField(value = "weibaojihua_uuid_number")

    private String weibaojihuaUuidNumber;


    /**
     * 维保计划标题
     */
    @ColumnInfo(comment="维保计划标题",type="varchar(200)")
    @TableField(value = "weibaojihua_name")

    private String weibaojihuaName;


    /**
     * 维保计划附件
     */
    @ColumnInfo(comment="维保计划附件",type="varchar(200)")
    @TableField(value = "weibaojihua_file")

    private String weibaojihuaFile;


    /**
     * 维保计划类型
     */
    @ColumnInfo(comment="维保计划类型",type="int(11)")
    @TableField(value = "weibaojihua_types")

    private Integer weibaojihuaTypes;


    /**
     * 维保部位
     */
    @ColumnInfo(comment="维保部位",type="varchar(200)")
    @TableField(value = "weibaojihua_buwei")

    private String weibaojihuaBuwei;


    /**
     * 维保时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="维保时间",type="timestamp")
    @TableField(value = "weibao_time")

    private Date weibaoTime;


    /**
     * 维保地点
     */
    @ColumnInfo(comment="维保地点",type="varchar(200)")
    @TableField(value = "weibaojihua_address")

    private String weibaojihuaAddress;


    /**
     * 维保详情
     */
    @ColumnInfo(comment="维保详情",type="longtext")
    @TableField(value = "weibaojihua_content")

    private String weibaojihuaContent;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="上传时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 申请状态
     */
    @ColumnInfo(comment="申请状态",type="int(11)")
    @TableField(value = "weibaojihua_yesno_types")

    private Integer weibaojihuaYesnoTypes;


    /**
     * 审核意见
     */
    @ColumnInfo(comment="审核意见",type="longtext")
    @TableField(value = "weibaojihua_yesno_text")

    private String weibaojihuaYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "weibaojihua_shenhe_time")

    private Date weibaojihuaShenheTime;


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
	 * 获取：维保计划编号
	 */
    public String getWeibaojihuaUuidNumber() {
        return weibaojihuaUuidNumber;
    }
    /**
	 * 设置：维保计划编号
	 */

    public void setWeibaojihuaUuidNumber(String weibaojihuaUuidNumber) {
        this.weibaojihuaUuidNumber = weibaojihuaUuidNumber;
    }
    /**
	 * 获取：维保计划标题
	 */
    public String getWeibaojihuaName() {
        return weibaojihuaName;
    }
    /**
	 * 设置：维保计划标题
	 */

    public void setWeibaojihuaName(String weibaojihuaName) {
        this.weibaojihuaName = weibaojihuaName;
    }
    /**
	 * 获取：维保计划附件
	 */
    public String getWeibaojihuaFile() {
        return weibaojihuaFile;
    }
    /**
	 * 设置：维保计划附件
	 */

    public void setWeibaojihuaFile(String weibaojihuaFile) {
        this.weibaojihuaFile = weibaojihuaFile;
    }
    /**
	 * 获取：维保计划类型
	 */
    public Integer getWeibaojihuaTypes() {
        return weibaojihuaTypes;
    }
    /**
	 * 设置：维保计划类型
	 */

    public void setWeibaojihuaTypes(Integer weibaojihuaTypes) {
        this.weibaojihuaTypes = weibaojihuaTypes;
    }
    /**
	 * 获取：维保部位
	 */
    public String getWeibaojihuaBuwei() {
        return weibaojihuaBuwei;
    }
    /**
	 * 设置：维保部位
	 */

    public void setWeibaojihuaBuwei(String weibaojihuaBuwei) {
        this.weibaojihuaBuwei = weibaojihuaBuwei;
    }
    /**
	 * 获取：维保时间
	 */
    public Date getWeibaoTime() {
        return weibaoTime;
    }
    /**
	 * 设置：维保时间
	 */

    public void setWeibaoTime(Date weibaoTime) {
        this.weibaoTime = weibaoTime;
    }
    /**
	 * 获取：维保地点
	 */
    public String getWeibaojihuaAddress() {
        return weibaojihuaAddress;
    }
    /**
	 * 设置：维保地点
	 */

    public void setWeibaojihuaAddress(String weibaojihuaAddress) {
        this.weibaojihuaAddress = weibaojihuaAddress;
    }
    /**
	 * 获取：维保详情
	 */
    public String getWeibaojihuaContent() {
        return weibaojihuaContent;
    }
    /**
	 * 设置：维保详情
	 */

    public void setWeibaojihuaContent(String weibaojihuaContent) {
        this.weibaojihuaContent = weibaojihuaContent;
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
	 * 获取：申请状态
	 */
    public Integer getWeibaojihuaYesnoTypes() {
        return weibaojihuaYesnoTypes;
    }
    /**
	 * 设置：申请状态
	 */

    public void setWeibaojihuaYesnoTypes(Integer weibaojihuaYesnoTypes) {
        this.weibaojihuaYesnoTypes = weibaojihuaYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getWeibaojihuaYesnoText() {
        return weibaojihuaYesnoText;
    }
    /**
	 * 设置：审核意见
	 */

    public void setWeibaojihuaYesnoText(String weibaojihuaYesnoText) {
        this.weibaojihuaYesnoText = weibaojihuaYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getWeibaojihuaShenheTime() {
        return weibaojihuaShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setWeibaojihuaShenheTime(Date weibaojihuaShenheTime) {
        this.weibaojihuaShenheTime = weibaojihuaShenheTime;
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
        return "Weibaojihua{" +
            ", id=" + id +
            ", chaunboId=" + chaunboId +
            ", weibaogongsiId=" + weibaogongsiId +
            ", weibaorenyuanId=" + weibaorenyuanId +
            ", weibaojihuaUuidNumber=" + weibaojihuaUuidNumber +
            ", weibaojihuaName=" + weibaojihuaName +
            ", weibaojihuaFile=" + weibaojihuaFile +
            ", weibaojihuaTypes=" + weibaojihuaTypes +
            ", weibaojihuaBuwei=" + weibaojihuaBuwei +
            ", weibaoTime=" + DateUtil.convertString(weibaoTime,"yyyy-MM-dd") +
            ", weibaojihuaAddress=" + weibaojihuaAddress +
            ", weibaojihuaContent=" + weibaojihuaContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", weibaojihuaYesnoTypes=" + weibaojihuaYesnoTypes +
            ", weibaojihuaYesnoText=" + weibaojihuaYesnoText +
            ", weibaojihuaShenheTime=" + DateUtil.convertString(weibaojihuaShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
