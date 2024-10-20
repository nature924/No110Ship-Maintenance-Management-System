package com.entity.model;

import com.entity.GuzhangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 故障上报
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GuzhangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 船舶
     */
    private Integer chaunboId;


    /**
     * 维保人员
     */
    private Integer weibaorenyuanId;


    /**
     * 故障编号
     */
    private String guzhangUuidNumber;


    /**
     * 故障标题
     */
    private String guzhangName;


    /**
     * 故障照片
     */
    private String guzhangPhoto;


    /**
     * 故障位置
     */
    private String guzhangAddress;


    /**
     * 故障类型
     */
    private Integer guzhangTypes;


    /**
     * 故障内容
     */
    private String guzhangContent;


    /**
     * 故障状态
     */
    private Integer guzhangZhuangtaiTypes;


    /**
     * 报修时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 维修评价
     */
    private String guzhangText;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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

    }
