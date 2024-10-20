package com.entity.vo;

import com.entity.GuzhangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 故障上报
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("guzhang")
public class GuzhangVO implements Serializable {
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
     * 维保人员
     */

    @TableField(value = "weibaorenyuan_id")
    private Integer weibaorenyuanId;


    /**
     * 故障编号
     */

    @TableField(value = "guzhang_uuid_number")
    private String guzhangUuidNumber;


    /**
     * 故障标题
     */

    @TableField(value = "guzhang_name")
    private String guzhangName;


    /**
     * 故障照片
     */

    @TableField(value = "guzhang_photo")
    private String guzhangPhoto;


    /**
     * 故障位置
     */

    @TableField(value = "guzhang_address")
    private String guzhangAddress;


    /**
     * 故障类型
     */

    @TableField(value = "guzhang_types")
    private Integer guzhangTypes;


    /**
     * 故障内容
     */

    @TableField(value = "guzhang_content")
    private String guzhangContent;


    /**
     * 故障状态
     */

    @TableField(value = "guzhang_zhuangtai_types")
    private Integer guzhangZhuangtaiTypes;


    /**
     * 报修时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 维修评价
     */

    @TableField(value = "guzhang_text")
    private String guzhangText;


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
	 * 设置：故障编号
	 */
    public String getGuzhangUuidNumber() {
        return guzhangUuidNumber;
    }


    /**
	 * 获取：故障编号
	 */

    public void setGuzhangUuidNumber(String guzhangUuidNumber) {
        this.guzhangUuidNumber = guzhangUuidNumber;
    }
    /**
	 * 设置：故障标题
	 */
    public String getGuzhangName() {
        return guzhangName;
    }


    /**
	 * 获取：故障标题
	 */

    public void setGuzhangName(String guzhangName) {
        this.guzhangName = guzhangName;
    }
    /**
	 * 设置：故障照片
	 */
    public String getGuzhangPhoto() {
        return guzhangPhoto;
    }


    /**
	 * 获取：故障照片
	 */

    public void setGuzhangPhoto(String guzhangPhoto) {
        this.guzhangPhoto = guzhangPhoto;
    }
    /**
	 * 设置：故障位置
	 */
    public String getGuzhangAddress() {
        return guzhangAddress;
    }


    /**
	 * 获取：故障位置
	 */

    public void setGuzhangAddress(String guzhangAddress) {
        this.guzhangAddress = guzhangAddress;
    }
    /**
	 * 设置：故障类型
	 */
    public Integer getGuzhangTypes() {
        return guzhangTypes;
    }


    /**
	 * 获取：故障类型
	 */

    public void setGuzhangTypes(Integer guzhangTypes) {
        this.guzhangTypes = guzhangTypes;
    }
    /**
	 * 设置：故障内容
	 */
    public String getGuzhangContent() {
        return guzhangContent;
    }


    /**
	 * 获取：故障内容
	 */

    public void setGuzhangContent(String guzhangContent) {
        this.guzhangContent = guzhangContent;
    }
    /**
	 * 设置：故障状态
	 */
    public Integer getGuzhangZhuangtaiTypes() {
        return guzhangZhuangtaiTypes;
    }


    /**
	 * 获取：故障状态
	 */

    public void setGuzhangZhuangtaiTypes(Integer guzhangZhuangtaiTypes) {
        this.guzhangZhuangtaiTypes = guzhangZhuangtaiTypes;
    }
    /**
	 * 设置：报修时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：报修时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：维修评价
	 */
    public String getGuzhangText() {
        return guzhangText;
    }


    /**
	 * 获取：维修评价
	 */

    public void setGuzhangText(String guzhangText) {
        this.guzhangText = guzhangText;
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
