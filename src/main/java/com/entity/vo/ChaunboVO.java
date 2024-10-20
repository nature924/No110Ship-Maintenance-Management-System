package com.entity.vo;

import com.entity.ChaunboEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 船舶
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chaunbo")
public class ChaunboVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 船家
     */

    @TableField(value = "chuanjia_id")
    private Integer chuanjiaId;


    /**
     * 维保公司
     */

    @TableField(value = "weibaogongsi_id")
    private Integer weibaogongsiId;


    /**
     * 船舶编号
     */

    @TableField(value = "chaunbo_uuid_number")
    private String chaunboUuidNumber;


    /**
     * 船舶名字
     */

    @TableField(value = "chaunbo_name")
    private String chaunboName;


    /**
     * 船舶照片
     */

    @TableField(value = "chaunbo_photo")
    private String chaunboPhoto;


    /**
     * 附件
     */

    @TableField(value = "chaunbo_file")
    private String chaunboFile;


    /**
     * 船舶类型
     */

    @TableField(value = "chaunbo_types")
    private Integer chaunboTypes;


    /**
     * 船舶状态
     */

    @TableField(value = "chaunbo_zhuangtai_types")
    private Integer chaunboZhuangtaiTypes;


    /**
     * 船舶介绍
     */

    @TableField(value = "chaunbo_content")
    private String chaunboContent;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：船家
	 */
    public Integer getChuanjiaId() {
        return chuanjiaId;
    }


    /**
	 * 获取：船家
	 */

    public void setChuanjiaId(Integer chuanjiaId) {
        this.chuanjiaId = chuanjiaId;
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
	 * 设置：船舶编号
	 */
    public String getChaunboUuidNumber() {
        return chaunboUuidNumber;
    }


    /**
	 * 获取：船舶编号
	 */

    public void setChaunboUuidNumber(String chaunboUuidNumber) {
        this.chaunboUuidNumber = chaunboUuidNumber;
    }
    /**
	 * 设置：船舶名字
	 */
    public String getChaunboName() {
        return chaunboName;
    }


    /**
	 * 获取：船舶名字
	 */

    public void setChaunboName(String chaunboName) {
        this.chaunboName = chaunboName;
    }
    /**
	 * 设置：船舶照片
	 */
    public String getChaunboPhoto() {
        return chaunboPhoto;
    }


    /**
	 * 获取：船舶照片
	 */

    public void setChaunboPhoto(String chaunboPhoto) {
        this.chaunboPhoto = chaunboPhoto;
    }
    /**
	 * 设置：附件
	 */
    public String getChaunboFile() {
        return chaunboFile;
    }


    /**
	 * 获取：附件
	 */

    public void setChaunboFile(String chaunboFile) {
        this.chaunboFile = chaunboFile;
    }
    /**
	 * 设置：船舶类型
	 */
    public Integer getChaunboTypes() {
        return chaunboTypes;
    }


    /**
	 * 获取：船舶类型
	 */

    public void setChaunboTypes(Integer chaunboTypes) {
        this.chaunboTypes = chaunboTypes;
    }
    /**
	 * 设置：船舶状态
	 */
    public Integer getChaunboZhuangtaiTypes() {
        return chaunboZhuangtaiTypes;
    }


    /**
	 * 获取：船舶状态
	 */

    public void setChaunboZhuangtaiTypes(Integer chaunboZhuangtaiTypes) {
        this.chaunboZhuangtaiTypes = chaunboZhuangtaiTypes;
    }
    /**
	 * 设置：船舶介绍
	 */
    public String getChaunboContent() {
        return chaunboContent;
    }


    /**
	 * 获取：船舶介绍
	 */

    public void setChaunboContent(String chaunboContent) {
        this.chaunboContent = chaunboContent;
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
