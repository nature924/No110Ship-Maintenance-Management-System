package com.entity.vo;

import com.entity.WeibaojihuaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 维保计划
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("weibaojihua")
public class WeibaojihuaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 船舶
     */

    @TableField(value = "chaunbo_id")
    private Integer chaunboId;


    /**
     * 维保公司
     */

    @TableField(value = "weibaogongsi_id")
    private Integer weibaogongsiId;


    /**
     * 维保人员
     */

    @TableField(value = "weibaorenyuan_id")
    private Integer weibaorenyuanId;


    /**
     * 维保计划编号
     */

    @TableField(value = "weibaojihua_uuid_number")
    private String weibaojihuaUuidNumber;


    /**
     * 维保计划标题
     */

    @TableField(value = "weibaojihua_name")
    private String weibaojihuaName;


    /**
     * 维保计划附件
     */

    @TableField(value = "weibaojihua_file")
    private String weibaojihuaFile;


    /**
     * 维保计划类型
     */

    @TableField(value = "weibaojihua_types")
    private Integer weibaojihuaTypes;


    /**
     * 维保部位
     */

    @TableField(value = "weibaojihua_buwei")
    private String weibaojihuaBuwei;


    /**
     * 维保时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "weibao_time")
    private Date weibaoTime;


    /**
     * 维保地点
     */

    @TableField(value = "weibaojihua_address")
    private String weibaojihuaAddress;


    /**
     * 维保详情
     */

    @TableField(value = "weibaojihua_content")
    private String weibaojihuaContent;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 申请状态
     */

    @TableField(value = "weibaojihua_yesno_types")
    private Integer weibaojihuaYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "weibaojihua_yesno_text")
    private String weibaojihuaYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "weibaojihua_shenhe_time")
    private Date weibaojihuaShenheTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：船舶
	 */
    public Integer getChaunboId() {
        return chaunboId;
    }


    /**
	 * 获取：船舶
	 */

    public void setChaunboId(Integer chaunboId) {
        this.chaunboId = chaunboId;
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
	 * 设置：维保人员
	 */
    public Integer getWeibaorenyuanId() {
        return weibaorenyuanId;
    }


    /**
	 * 获取：维保人员
	 */

    public void setWeibaorenyuanId(Integer weibaorenyuanId) {
        this.weibaorenyuanId = weibaorenyuanId;
    }
    /**
	 * 设置：维保计划编号
	 */
    public String getWeibaojihuaUuidNumber() {
        return weibaojihuaUuidNumber;
    }


    /**
	 * 获取：维保计划编号
	 */

    public void setWeibaojihuaUuidNumber(String weibaojihuaUuidNumber) {
        this.weibaojihuaUuidNumber = weibaojihuaUuidNumber;
    }
    /**
	 * 设置：维保计划标题
	 */
    public String getWeibaojihuaName() {
        return weibaojihuaName;
    }


    /**
	 * 获取：维保计划标题
	 */

    public void setWeibaojihuaName(String weibaojihuaName) {
        this.weibaojihuaName = weibaojihuaName;
    }
    /**
	 * 设置：维保计划附件
	 */
    public String getWeibaojihuaFile() {
        return weibaojihuaFile;
    }


    /**
	 * 获取：维保计划附件
	 */

    public void setWeibaojihuaFile(String weibaojihuaFile) {
        this.weibaojihuaFile = weibaojihuaFile;
    }
    /**
	 * 设置：维保计划类型
	 */
    public Integer getWeibaojihuaTypes() {
        return weibaojihuaTypes;
    }


    /**
	 * 获取：维保计划类型
	 */

    public void setWeibaojihuaTypes(Integer weibaojihuaTypes) {
        this.weibaojihuaTypes = weibaojihuaTypes;
    }
    /**
	 * 设置：维保部位
	 */
    public String getWeibaojihuaBuwei() {
        return weibaojihuaBuwei;
    }


    /**
	 * 获取：维保部位
	 */

    public void setWeibaojihuaBuwei(String weibaojihuaBuwei) {
        this.weibaojihuaBuwei = weibaojihuaBuwei;
    }
    /**
	 * 设置：维保时间
	 */
    public Date getWeibaoTime() {
        return weibaoTime;
    }


    /**
	 * 获取：维保时间
	 */

    public void setWeibaoTime(Date weibaoTime) {
        this.weibaoTime = weibaoTime;
    }
    /**
	 * 设置：维保地点
	 */
    public String getWeibaojihuaAddress() {
        return weibaojihuaAddress;
    }


    /**
	 * 获取：维保地点
	 */

    public void setWeibaojihuaAddress(String weibaojihuaAddress) {
        this.weibaojihuaAddress = weibaojihuaAddress;
    }
    /**
	 * 设置：维保详情
	 */
    public String getWeibaojihuaContent() {
        return weibaojihuaContent;
    }


    /**
	 * 获取：维保详情
	 */

    public void setWeibaojihuaContent(String weibaojihuaContent) {
        this.weibaojihuaContent = weibaojihuaContent;
    }
    /**
	 * 设置：上传时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：上传时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getWeibaojihuaYesnoTypes() {
        return weibaojihuaYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setWeibaojihuaYesnoTypes(Integer weibaojihuaYesnoTypes) {
        this.weibaojihuaYesnoTypes = weibaojihuaYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getWeibaojihuaYesnoText() {
        return weibaojihuaYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setWeibaojihuaYesnoText(String weibaojihuaYesnoText) {
        this.weibaojihuaYesnoText = weibaojihuaYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getWeibaojihuaShenheTime() {
        return weibaojihuaShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setWeibaojihuaShenheTime(Date weibaojihuaShenheTime) {
        this.weibaojihuaShenheTime = weibaojihuaShenheTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
