package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.WeibaojihuaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 维保计划
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("weibaojihua")
public class WeibaojihuaView extends WeibaojihuaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 维保计划类型的值
	*/
	@ColumnInfo(comment="维保计划类型的字典表值",type="varchar(200)")
	private String weibaojihuaValue;
	/**
	* 申请状态的值
	*/
	@ColumnInfo(comment="申请状态的字典表值",type="varchar(200)")
	private String weibaojihuaYesnoValue;

	//级联表 船舶
					 
		/**
		* 船舶 的 船家
		*/
		@ColumnInfo(comment="船家",type="int(11)")
		private Integer chaunboChuanjiaId;
					 
		/**
		* 船舶 的 维保公司
		*/
		@ColumnInfo(comment="维保公司",type="int(11)")
		private Integer chaunboWeibaogongsiId;
		/**
		* 船舶编号
		*/

		@ColumnInfo(comment="船舶编号",type="varchar(200)")
		private String chaunboUuidNumber;
		/**
		* 船舶名字
		*/

		@ColumnInfo(comment="船舶名字",type="varchar(200)")
		private String chaunboName;
		/**
		* 船舶照片
		*/

		@ColumnInfo(comment="船舶照片",type="varchar(200)")
		private String chaunboPhoto;
		/**
		* 附件
		*/

		@ColumnInfo(comment="附件",type="varchar(200)")
		private String chaunboFile;
		/**
		* 船舶类型
		*/
		@ColumnInfo(comment="船舶类型",type="int(11)")
		private Integer chaunboTypes;
			/**
			* 船舶类型的值
			*/
			@ColumnInfo(comment="船舶类型的字典表值",type="varchar(200)")
			private String chaunboValue;
		/**
		* 船舶状态
		*/
		@ColumnInfo(comment="船舶状态",type="int(11)")
		private Integer chaunboZhuangtaiTypes;
			/**
			* 船舶状态的值
			*/
			@ColumnInfo(comment="船舶状态的字典表值",type="varchar(200)")
			private String chaunboZhuangtaiValue;
		/**
		* 船舶介绍
		*/

		@ColumnInfo(comment="船舶介绍",type="longtext")
		private String chaunboContent;
	//级联表 维保公司
		/**
		* 维保公司编号
		*/

		@ColumnInfo(comment="维保公司编号",type="varchar(200)")
		private String weibaogongsiUuidNumber;
		/**
		* 维保公司名称
		*/

		@ColumnInfo(comment="维保公司名称",type="varchar(200)")
		private String weibaogongsiName;
		/**
		* 负责人
		*/

		@ColumnInfo(comment="负责人",type="varchar(200)")
		private String weibaogongsiFuzeren;
		/**
		* 维保公司手机号
		*/

		@ColumnInfo(comment="维保公司手机号",type="varchar(200)")
		private String weibaogongsiPhone;
		/**
		* 公司logo
		*/

		@ColumnInfo(comment="公司logo",type="varchar(200)")
		private String weibaogongsiPhoto;
		/**
		* 公司位置
		*/

		@ColumnInfo(comment="公司位置",type="varchar(200)")
		private String weibaogongsiAddress;
	//级联表 维保人员
					 
		/**
		* 维保人员 的 维保公司
		*/
		@ColumnInfo(comment="维保公司",type="int(11)")
		private Integer weibaorenyuanWeibaogongsiId;
		/**
		* 维保人员编号
		*/

		@ColumnInfo(comment="维保人员编号",type="varchar(200)")
		private String weibaorenyuanUuidNumber;
		/**
		* 维保人员姓名
		*/

		@ColumnInfo(comment="维保人员姓名",type="varchar(200)")
		private String weibaorenyuanName;
		/**
		* 维保人员手机号
		*/

		@ColumnInfo(comment="维保人员手机号",type="varchar(200)")
		private String weibaorenyuanPhone;
		/**
		* 维保人员身份证号
		*/

		@ColumnInfo(comment="维保人员身份证号",type="varchar(200)")
		private String weibaorenyuanIdNumber;
		/**
		* 维保人员头像
		*/

		@ColumnInfo(comment="维保人员头像",type="varchar(200)")
		private String weibaorenyuanPhoto;
		/**
		* 维保人员邮箱
		*/

		@ColumnInfo(comment="维保人员邮箱",type="varchar(200)")
		private String weibaorenyuanEmail;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer jinyongTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String jinyongValue;


	public WeibaojihuaView() {

	}

	public WeibaojihuaView(WeibaojihuaEntity weibaojihuaEntity) {
		try {
			BeanUtils.copyProperties(this, weibaojihuaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 维保计划类型的值
	*/
	public String getWeibaojihuaValue() {
		return weibaojihuaValue;
	}
	/**
	* 设置： 维保计划类型的值
	*/
	public void setWeibaojihuaValue(String weibaojihuaValue) {
		this.weibaojihuaValue = weibaojihuaValue;
	}
	//当前表的
	/**
	* 获取： 申请状态的值
	*/
	public String getWeibaojihuaYesnoValue() {
		return weibaojihuaYesnoValue;
	}
	/**
	* 设置： 申请状态的值
	*/
	public void setWeibaojihuaYesnoValue(String weibaojihuaYesnoValue) {
		this.weibaojihuaYesnoValue = weibaojihuaYesnoValue;
	}


	//级联表的get和set 船舶
		/**
		* 获取：船舶 的 船家
		*/
		public Integer getChaunboChuanjiaId() {
			return chaunboChuanjiaId;
		}
		/**
		* 设置：船舶 的 船家
		*/
		public void setChaunboChuanjiaId(Integer chaunboChuanjiaId) {
			this.chaunboChuanjiaId = chaunboChuanjiaId;
		}
		/**
		* 获取：船舶 的 维保公司
		*/
		public Integer getChaunboWeibaogongsiId() {
			return chaunboWeibaogongsiId;
		}
		/**
		* 设置：船舶 的 维保公司
		*/
		public void setChaunboWeibaogongsiId(Integer chaunboWeibaogongsiId) {
			this.chaunboWeibaogongsiId = chaunboWeibaogongsiId;
		}

		/**
		* 获取： 船舶编号
		*/
		public String getChaunboUuidNumber() {
			return chaunboUuidNumber;
		}
		/**
		* 设置： 船舶编号
		*/
		public void setChaunboUuidNumber(String chaunboUuidNumber) {
			this.chaunboUuidNumber = chaunboUuidNumber;
		}

		/**
		* 获取： 船舶名字
		*/
		public String getChaunboName() {
			return chaunboName;
		}
		/**
		* 设置： 船舶名字
		*/
		public void setChaunboName(String chaunboName) {
			this.chaunboName = chaunboName;
		}

		/**
		* 获取： 船舶照片
		*/
		public String getChaunboPhoto() {
			return chaunboPhoto;
		}
		/**
		* 设置： 船舶照片
		*/
		public void setChaunboPhoto(String chaunboPhoto) {
			this.chaunboPhoto = chaunboPhoto;
		}

		/**
		* 获取： 附件
		*/
		public String getChaunboFile() {
			return chaunboFile;
		}
		/**
		* 设置： 附件
		*/
		public void setChaunboFile(String chaunboFile) {
			this.chaunboFile = chaunboFile;
		}
		/**
		* 获取： 船舶类型
		*/
		public Integer getChaunboTypes() {
			return chaunboTypes;
		}
		/**
		* 设置： 船舶类型
		*/
		public void setChaunboTypes(Integer chaunboTypes) {
			this.chaunboTypes = chaunboTypes;
		}


			/**
			* 获取： 船舶类型的值
			*/
			public String getChaunboValue() {
				return chaunboValue;
			}
			/**
			* 设置： 船舶类型的值
			*/
			public void setChaunboValue(String chaunboValue) {
				this.chaunboValue = chaunboValue;
			}
		/**
		* 获取： 船舶状态
		*/
		public Integer getChaunboZhuangtaiTypes() {
			return chaunboZhuangtaiTypes;
		}
		/**
		* 设置： 船舶状态
		*/
		public void setChaunboZhuangtaiTypes(Integer chaunboZhuangtaiTypes) {
			this.chaunboZhuangtaiTypes = chaunboZhuangtaiTypes;
		}


			/**
			* 获取： 船舶状态的值
			*/
			public String getChaunboZhuangtaiValue() {
				return chaunboZhuangtaiValue;
			}
			/**
			* 设置： 船舶状态的值
			*/
			public void setChaunboZhuangtaiValue(String chaunboZhuangtaiValue) {
				this.chaunboZhuangtaiValue = chaunboZhuangtaiValue;
			}

		/**
		* 获取： 船舶介绍
		*/
		public String getChaunboContent() {
			return chaunboContent;
		}
		/**
		* 设置： 船舶介绍
		*/
		public void setChaunboContent(String chaunboContent) {
			this.chaunboContent = chaunboContent;
		}
	//级联表的get和set 维保公司

		/**
		* 获取： 维保公司编号
		*/
		public String getWeibaogongsiUuidNumber() {
			return weibaogongsiUuidNumber;
		}
		/**
		* 设置： 维保公司编号
		*/
		public void setWeibaogongsiUuidNumber(String weibaogongsiUuidNumber) {
			this.weibaogongsiUuidNumber = weibaogongsiUuidNumber;
		}

		/**
		* 获取： 维保公司名称
		*/
		public String getWeibaogongsiName() {
			return weibaogongsiName;
		}
		/**
		* 设置： 维保公司名称
		*/
		public void setWeibaogongsiName(String weibaogongsiName) {
			this.weibaogongsiName = weibaogongsiName;
		}

		/**
		* 获取： 负责人
		*/
		public String getWeibaogongsiFuzeren() {
			return weibaogongsiFuzeren;
		}
		/**
		* 设置： 负责人
		*/
		public void setWeibaogongsiFuzeren(String weibaogongsiFuzeren) {
			this.weibaogongsiFuzeren = weibaogongsiFuzeren;
		}

		/**
		* 获取： 维保公司手机号
		*/
		public String getWeibaogongsiPhone() {
			return weibaogongsiPhone;
		}
		/**
		* 设置： 维保公司手机号
		*/
		public void setWeibaogongsiPhone(String weibaogongsiPhone) {
			this.weibaogongsiPhone = weibaogongsiPhone;
		}

		/**
		* 获取： 公司logo
		*/
		public String getWeibaogongsiPhoto() {
			return weibaogongsiPhoto;
		}
		/**
		* 设置： 公司logo
		*/
		public void setWeibaogongsiPhoto(String weibaogongsiPhoto) {
			this.weibaogongsiPhoto = weibaogongsiPhoto;
		}

		/**
		* 获取： 公司位置
		*/
		public String getWeibaogongsiAddress() {
			return weibaogongsiAddress;
		}
		/**
		* 设置： 公司位置
		*/
		public void setWeibaogongsiAddress(String weibaogongsiAddress) {
			this.weibaogongsiAddress = weibaogongsiAddress;
		}
	//级联表的get和set 维保人员
		/**
		* 获取：维保人员 的 维保公司
		*/
		public Integer getWeibaorenyuanWeibaogongsiId() {
			return weibaorenyuanWeibaogongsiId;
		}
		/**
		* 设置：维保人员 的 维保公司
		*/
		public void setWeibaorenyuanWeibaogongsiId(Integer weibaorenyuanWeibaogongsiId) {
			this.weibaorenyuanWeibaogongsiId = weibaorenyuanWeibaogongsiId;
		}

		/**
		* 获取： 维保人员编号
		*/
		public String getWeibaorenyuanUuidNumber() {
			return weibaorenyuanUuidNumber;
		}
		/**
		* 设置： 维保人员编号
		*/
		public void setWeibaorenyuanUuidNumber(String weibaorenyuanUuidNumber) {
			this.weibaorenyuanUuidNumber = weibaorenyuanUuidNumber;
		}

		/**
		* 获取： 维保人员姓名
		*/
		public String getWeibaorenyuanName() {
			return weibaorenyuanName;
		}
		/**
		* 设置： 维保人员姓名
		*/
		public void setWeibaorenyuanName(String weibaorenyuanName) {
			this.weibaorenyuanName = weibaorenyuanName;
		}

		/**
		* 获取： 维保人员手机号
		*/
		public String getWeibaorenyuanPhone() {
			return weibaorenyuanPhone;
		}
		/**
		* 设置： 维保人员手机号
		*/
		public void setWeibaorenyuanPhone(String weibaorenyuanPhone) {
			this.weibaorenyuanPhone = weibaorenyuanPhone;
		}

		/**
		* 获取： 维保人员身份证号
		*/
		public String getWeibaorenyuanIdNumber() {
			return weibaorenyuanIdNumber;
		}
		/**
		* 设置： 维保人员身份证号
		*/
		public void setWeibaorenyuanIdNumber(String weibaorenyuanIdNumber) {
			this.weibaorenyuanIdNumber = weibaorenyuanIdNumber;
		}

		/**
		* 获取： 维保人员头像
		*/
		public String getWeibaorenyuanPhoto() {
			return weibaorenyuanPhoto;
		}
		/**
		* 设置： 维保人员头像
		*/
		public void setWeibaorenyuanPhoto(String weibaorenyuanPhoto) {
			this.weibaorenyuanPhoto = weibaorenyuanPhoto;
		}

		/**
		* 获取： 维保人员邮箱
		*/
		public String getWeibaorenyuanEmail() {
			return weibaorenyuanEmail;
		}
		/**
		* 设置： 维保人员邮箱
		*/
		public void setWeibaorenyuanEmail(String weibaorenyuanEmail) {
			this.weibaorenyuanEmail = weibaorenyuanEmail;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getJinyongTypes() {
			return jinyongTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
			}
				public String getJinyongValue() {
				return jinyongValue;
				}
				public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
				}

	@Override
	public String toString() {
		return "WeibaojihuaView{" +
			", weibaojihuaValue=" + weibaojihuaValue +
			", weibaojihuaYesnoValue=" + weibaojihuaYesnoValue +
			", chaunboUuidNumber=" + chaunboUuidNumber +
			", chaunboName=" + chaunboName +
			", chaunboPhoto=" + chaunboPhoto +
			", chaunboFile=" + chaunboFile +
			", chaunboContent=" + chaunboContent +
			", weibaogongsiUuidNumber=" + weibaogongsiUuidNumber +
			", weibaogongsiName=" + weibaogongsiName +
			", weibaogongsiFuzeren=" + weibaogongsiFuzeren +
			", weibaogongsiPhone=" + weibaogongsiPhone +
			", weibaogongsiPhoto=" + weibaogongsiPhoto +
			", weibaogongsiAddress=" + weibaogongsiAddress +
			", weibaorenyuanUuidNumber=" + weibaorenyuanUuidNumber +
			", weibaorenyuanName=" + weibaorenyuanName +
			", weibaorenyuanPhone=" + weibaorenyuanPhone +
			", weibaorenyuanIdNumber=" + weibaorenyuanIdNumber +
			", weibaorenyuanPhoto=" + weibaorenyuanPhoto +
			", weibaorenyuanEmail=" + weibaorenyuanEmail +
			"} " + super.toString();
	}
}
