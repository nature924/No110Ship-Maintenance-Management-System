package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ChengbenEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 维修成本
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("chengben")
public class ChengbenView extends ChengbenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 维修成本类型的值
	*/
	@ColumnInfo(comment="维修成本类型的字典表值",type="varchar(200)")
	private String chengbenValue;

	//级联表 故障上报
										 
		/**
		* 故障上报 的 维保人员
		*/
		@ColumnInfo(comment="维保人员",type="int(11)")
		private Integer guzhangWeibaorenyuanId;
		/**
		* 故障编号
		*/

		@ColumnInfo(comment="故障编号",type="varchar(200)")
		private String guzhangUuidNumber;
		/**
		* 故障标题
		*/

		@ColumnInfo(comment="故障标题",type="varchar(200)")
		private String guzhangName;
		/**
		* 故障照片
		*/

		@ColumnInfo(comment="故障照片",type="varchar(200)")
		private String guzhangPhoto;
		/**
		* 故障位置
		*/

		@ColumnInfo(comment="故障位置",type="varchar(200)")
		private String guzhangAddress;
		/**
		* 故障类型
		*/
		@ColumnInfo(comment="故障类型",type="int(11)")
		private Integer guzhangTypes;
			/**
			* 故障类型的值
			*/
			@ColumnInfo(comment="故障类型的字典表值",type="varchar(200)")
			private String guzhangValue;
		/**
		* 故障内容
		*/

		@ColumnInfo(comment="故障内容",type="longtext")
		private String guzhangContent;
		/**
		* 故障状态
		*/
		@ColumnInfo(comment="故障状态",type="int(11)")
		private Integer guzhangZhuangtaiTypes;
			/**
			* 故障状态的值
			*/
			@ColumnInfo(comment="故障状态的字典表值",type="varchar(200)")
			private String guzhangZhuangtaiValue;
		/**
		* 维修评价
		*/

		@ColumnInfo(comment="维修评价",type="longtext")
		private String guzhangText;



	public ChengbenView() {

	}

	public ChengbenView(ChengbenEntity chengbenEntity) {
		try {
			BeanUtils.copyProperties(this, chengbenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 维修成本类型的值
	*/
	public String getChengbenValue() {
		return chengbenValue;
	}
	/**
	* 设置： 维修成本类型的值
	*/
	public void setChengbenValue(String chengbenValue) {
		this.chengbenValue = chengbenValue;
	}


	//级联表的get和set 故障上报
		/**
		* 获取：故障上报 的 维保人员
		*/
		public Integer getGuzhangWeibaorenyuanId() {
			return guzhangWeibaorenyuanId;
		}
		/**
		* 设置：故障上报 的 维保人员
		*/
		public void setGuzhangWeibaorenyuanId(Integer guzhangWeibaorenyuanId) {
			this.guzhangWeibaorenyuanId = guzhangWeibaorenyuanId;
		}

		/**
		* 获取： 故障编号
		*/
		public String getGuzhangUuidNumber() {
			return guzhangUuidNumber;
		}
		/**
		* 设置： 故障编号
		*/
		public void setGuzhangUuidNumber(String guzhangUuidNumber) {
			this.guzhangUuidNumber = guzhangUuidNumber;
		}

		/**
		* 获取： 故障标题
		*/
		public String getGuzhangName() {
			return guzhangName;
		}
		/**
		* 设置： 故障标题
		*/
		public void setGuzhangName(String guzhangName) {
			this.guzhangName = guzhangName;
		}

		/**
		* 获取： 故障照片
		*/
		public String getGuzhangPhoto() {
			return guzhangPhoto;
		}
		/**
		* 设置： 故障照片
		*/
		public void setGuzhangPhoto(String guzhangPhoto) {
			this.guzhangPhoto = guzhangPhoto;
		}

		/**
		* 获取： 故障位置
		*/
		public String getGuzhangAddress() {
			return guzhangAddress;
		}
		/**
		* 设置： 故障位置
		*/
		public void setGuzhangAddress(String guzhangAddress) {
			this.guzhangAddress = guzhangAddress;
		}
		/**
		* 获取： 故障类型
		*/
		public Integer getGuzhangTypes() {
			return guzhangTypes;
		}
		/**
		* 设置： 故障类型
		*/
		public void setGuzhangTypes(Integer guzhangTypes) {
			this.guzhangTypes = guzhangTypes;
		}


			/**
			* 获取： 故障类型的值
			*/
			public String getGuzhangValue() {
				return guzhangValue;
			}
			/**
			* 设置： 故障类型的值
			*/
			public void setGuzhangValue(String guzhangValue) {
				this.guzhangValue = guzhangValue;
			}

		/**
		* 获取： 故障内容
		*/
		public String getGuzhangContent() {
			return guzhangContent;
		}
		/**
		* 设置： 故障内容
		*/
		public void setGuzhangContent(String guzhangContent) {
			this.guzhangContent = guzhangContent;
		}
		/**
		* 获取： 故障状态
		*/
		public Integer getGuzhangZhuangtaiTypes() {
			return guzhangZhuangtaiTypes;
		}
		/**
		* 设置： 故障状态
		*/
		public void setGuzhangZhuangtaiTypes(Integer guzhangZhuangtaiTypes) {
			this.guzhangZhuangtaiTypes = guzhangZhuangtaiTypes;
		}


			/**
			* 获取： 故障状态的值
			*/
			public String getGuzhangZhuangtaiValue() {
				return guzhangZhuangtaiValue;
			}
			/**
			* 设置： 故障状态的值
			*/
			public void setGuzhangZhuangtaiValue(String guzhangZhuangtaiValue) {
				this.guzhangZhuangtaiValue = guzhangZhuangtaiValue;
			}

		/**
		* 获取： 维修评价
		*/
		public String getGuzhangText() {
			return guzhangText;
		}
		/**
		* 设置： 维修评价
		*/
		public void setGuzhangText(String guzhangText) {
			this.guzhangText = guzhangText;
		}


	@Override
	public String toString() {
		return "ChengbenView{" +
			", chengbenValue=" + chengbenValue +
			", guzhangUuidNumber=" + guzhangUuidNumber +
			", guzhangName=" + guzhangName +
			", guzhangPhoto=" + guzhangPhoto +
			", guzhangAddress=" + guzhangAddress +
			", guzhangContent=" + guzhangContent +
			", guzhangText=" + guzhangText +
			"} " + super.toString();
	}
}
