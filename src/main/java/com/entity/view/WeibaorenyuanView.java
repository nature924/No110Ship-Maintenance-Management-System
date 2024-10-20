package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.WeibaorenyuanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 维保人员
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("weibaorenyuan")
public class WeibaorenyuanView extends WeibaorenyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 性别的值
	*/
	@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
	private String sexValue;
	/**
	* 账户状态的值
	*/
	@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
	private String jinyongValue;

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


	public WeibaorenyuanView() {

	}

	public WeibaorenyuanView(WeibaorenyuanEntity weibaorenyuanEntity) {
		try {
			BeanUtils.copyProperties(this, weibaorenyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 性别的值
	*/
	public String getSexValue() {
		return sexValue;
	}
	/**
	* 设置： 性别的值
	*/
	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}
	//当前表的
	/**
	* 获取： 账户状态的值
	*/
	public String getJinyongValue() {
		return jinyongValue;
	}
	/**
	* 设置： 账户状态的值
	*/
	public void setJinyongValue(String jinyongValue) {
		this.jinyongValue = jinyongValue;
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

	@Override
	public String toString() {
		return "WeibaorenyuanView{" +
			", sexValue=" + sexValue +
			", jinyongValue=" + jinyongValue +
			", weibaogongsiUuidNumber=" + weibaogongsiUuidNumber +
			", weibaogongsiName=" + weibaogongsiName +
			", weibaogongsiFuzeren=" + weibaogongsiFuzeren +
			", weibaogongsiPhone=" + weibaogongsiPhone +
			", weibaogongsiPhoto=" + weibaogongsiPhoto +
			", weibaogongsiAddress=" + weibaogongsiAddress +
			"} " + super.toString();
	}
}
