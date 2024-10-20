package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ChaunboEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 船舶
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("chaunbo")
public class ChaunboView extends ChaunboEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 船舶类型的值
	*/
	@ColumnInfo(comment="船舶类型的字典表值",type="varchar(200)")
	private String chaunboValue;
	/**
	* 船舶状态的值
	*/
	@ColumnInfo(comment="船舶状态的字典表值",type="varchar(200)")
	private String chaunboZhuangtaiValue;

	//级联表 船家
		/**
		* 船家编号
		*/

		@ColumnInfo(comment="船家编号",type="varchar(200)")
		private String chuanjiaUuidNumber;
		/**
		* 船家姓名
		*/

		@ColumnInfo(comment="船家姓名",type="varchar(200)")
		private String chuanjiaName;
		/**
		* 船家手机号
		*/

		@ColumnInfo(comment="船家手机号",type="varchar(200)")
		private String chuanjiaPhone;
		/**
		* 船家身份证号
		*/

		@ColumnInfo(comment="船家身份证号",type="varchar(200)")
		private String chuanjiaIdNumber;
		/**
		* 船家头像
		*/

		@ColumnInfo(comment="船家头像",type="varchar(200)")
		private String chuanjiaPhoto;
		/**
		* 船家邮箱
		*/

		@ColumnInfo(comment="船家邮箱",type="varchar(200)")
		private String chuanjiaEmail;
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

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer jinyongTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String jinyongValue;


	public ChaunboView() {

	}

	public ChaunboView(ChaunboEntity chaunboEntity) {
		try {
			BeanUtils.copyProperties(this, chaunboEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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
	//当前表的
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


	//级联表的get和set 船家

		/**
		* 获取： 船家编号
		*/
		public String getChuanjiaUuidNumber() {
			return chuanjiaUuidNumber;
		}
		/**
		* 设置： 船家编号
		*/
		public void setChuanjiaUuidNumber(String chuanjiaUuidNumber) {
			this.chuanjiaUuidNumber = chuanjiaUuidNumber;
		}

		/**
		* 获取： 船家姓名
		*/
		public String getChuanjiaName() {
			return chuanjiaName;
		}
		/**
		* 设置： 船家姓名
		*/
		public void setChuanjiaName(String chuanjiaName) {
			this.chuanjiaName = chuanjiaName;
		}

		/**
		* 获取： 船家手机号
		*/
		public String getChuanjiaPhone() {
			return chuanjiaPhone;
		}
		/**
		* 设置： 船家手机号
		*/
		public void setChuanjiaPhone(String chuanjiaPhone) {
			this.chuanjiaPhone = chuanjiaPhone;
		}

		/**
		* 获取： 船家身份证号
		*/
		public String getChuanjiaIdNumber() {
			return chuanjiaIdNumber;
		}
		/**
		* 设置： 船家身份证号
		*/
		public void setChuanjiaIdNumber(String chuanjiaIdNumber) {
			this.chuanjiaIdNumber = chuanjiaIdNumber;
		}

		/**
		* 获取： 船家头像
		*/
		public String getChuanjiaPhoto() {
			return chuanjiaPhoto;
		}
		/**
		* 设置： 船家头像
		*/
		public void setChuanjiaPhoto(String chuanjiaPhoto) {
			this.chuanjiaPhoto = chuanjiaPhoto;
		}

		/**
		* 获取： 船家邮箱
		*/
		public String getChuanjiaEmail() {
			return chuanjiaEmail;
		}
		/**
		* 设置： 船家邮箱
		*/
		public void setChuanjiaEmail(String chuanjiaEmail) {
			this.chuanjiaEmail = chuanjiaEmail;
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
		return "ChaunboView{" +
			", chaunboValue=" + chaunboValue +
			", chaunboZhuangtaiValue=" + chaunboZhuangtaiValue +
			", chuanjiaUuidNumber=" + chuanjiaUuidNumber +
			", chuanjiaName=" + chuanjiaName +
			", chuanjiaPhone=" + chuanjiaPhone +
			", chuanjiaIdNumber=" + chuanjiaIdNumber +
			", chuanjiaPhoto=" + chuanjiaPhoto +
			", chuanjiaEmail=" + chuanjiaEmail +
			", weibaogongsiUuidNumber=" + weibaogongsiUuidNumber +
			", weibaogongsiName=" + weibaogongsiName +
			", weibaogongsiFuzeren=" + weibaogongsiFuzeren +
			", weibaogongsiPhone=" + weibaogongsiPhone +
			", weibaogongsiPhoto=" + weibaogongsiPhoto +
			", weibaogongsiAddress=" + weibaogongsiAddress +
			"} " + super.toString();
	}
}
