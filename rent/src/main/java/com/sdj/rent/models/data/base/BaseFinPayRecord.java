package com.sdj.rent.models.data.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseFinPayRecord<M extends BaseFinPayRecord<M>> extends Model<M> implements IBean {

	public void setRecordId(java.lang.Long recordId) {
		set("record_id", recordId);
	}

	public java.lang.Long getRecordId() {
		return get("record_id");
	}

	public void setProId(java.lang.Long proId) {
		set("pro_id", proId);
	}

	public java.lang.Long getProId() {
		return get("pro_id");
	}

	public void setAmount(java.math.BigDecimal amount) {
		set("amount", amount);
	}

	public java.math.BigDecimal getAmount() {
		return get("amount");
	}

	public void setType(java.lang.Integer type) {
		set("type", type);
	}

	public java.lang.Integer getType() {
		return get("type");
	}

	public void setStatus(java.lang.String status) {
		set("status", status);
	}

	public java.lang.String getStatus() {
		return get("status");
	}

	public void setDate(java.util.Date date) {
		set("date", date);
	}

	public java.util.Date getDate() {
		return get("date");
	}

	public void setOperPer(java.lang.String operPer) {
		set("oper_per", operPer);
	}

	public java.lang.String getOperPer() {
		return get("oper_per");
	}

}
