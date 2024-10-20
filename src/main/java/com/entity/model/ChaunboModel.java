package com.entity.model;

import com.entity.ChaunboEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 船舶
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChaunboModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 船家
     */
    private Integer chuanjiaId;


    /**
     * 维保公司
     */
    private Integer weibaogongsiId;


    /**
     * 船舶编号
     */
    private String chaunboUuidNumber;


    /**
     * 船舶名字
     */
    private String chaunboName;


    /**
     * 船舶照片
     */
    private String chaunboPhoto;


    /**
     * 附件
     */
    private String chaunboFile;


    /**
     * 船舶类型
     */
    private Integer chaunboTypes;


    /**
     * 船舶状态
     */
    private Integer chaunboZhuangtaiTypes;


    /**
     * 船舶介绍
     */
    private String chaunboContent;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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

    }
