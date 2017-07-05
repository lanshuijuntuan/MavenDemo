package com.sdj.rent.models.data.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseWaterElecRecord<M extends BaseWaterElecRecord<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setBatchNo(java.lang.String batchNo) {
		set("batch_no", batchNo);
	}

	public java.lang.String getBatchNo() {
		return get("batch_no");
	}

	public void setWaterNum(java.math.BigDecimal waterNum) {
		set("water_num", waterNum);
	}

	public java.math.BigDecimal getWaterNum() {
		return get("water_num");
	}

	public void setWaterAmount(java.math.BigDecimal waterAmount) {
		set("water_amount", waterAmount);
	}

	public java.math.BigDecimal getWaterAmount() {
		return get("water_amount");
	}

	public void setElecNum(java.math.BigDecimal elecNum) {
		set("elec_num", elecNum);
	}

	public java.math.BigDecimal getElecNum() {
		return get("elec_num");
	}

	public void setElecAmount(java.math.BigDecimal elecAmount) {
		set("elec_amount", elecAmount);
	}

	public java.math.BigDecimal getElecAmount() {
		return get("elec_amount");
	}

	public void setOperId(java.lang.Integer operId) {
		set("oper_id", operId);
	}

	public java.lang.Integer getOperId() {
		return get("oper_id");
	}

	public void setOperDate(java.util.Date operDate) {
		set("oper_date", operDate);
	}

	public java.util.Date getOperDate() {
		return get("oper_date");
	}

	public void setProId(java.lang.Long proId) {
		set("pro_id", proId);
	}

	public java.lang.Long getProId() {
		return get("pro_id");
	}

}
