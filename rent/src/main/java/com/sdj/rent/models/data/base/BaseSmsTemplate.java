package com.sdj.rent.models.data.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseSmsTemplate<M extends BaseSmsTemplate<M>> extends Model<M> implements IBean {

	public void setSmsId(java.lang.Long smsId) {
		set("sms_id", smsId);
	}

	public java.lang.Long getSmsId() {
		return get("sms_id");
	}

	public void setSmsName(java.lang.String smsName) {
		set("sms_name", smsName);
	}

	public java.lang.String getSmsName() {
		return get("sms_name");
	}

	public void setSmsContent(java.lang.String smsContent) {
		set("sms_content", smsContent);
	}

	public java.lang.String getSmsContent() {
		return get("sms_content");
	}

	public void setSmsRemark(java.lang.String smsRemark) {
		set("sms_remark", smsRemark);
	}

	public java.lang.String getSmsRemark() {
		return get("sms_remark");
	}

	public void setOperPer(java.lang.String operPer) {
		set("oper_per", operPer);
	}

	public java.lang.String getOperPer() {
		return get("oper_per");
	}

	public void setOperDate(java.util.Date operDate) {
		set("oper_date", operDate);
	}

	public java.util.Date getOperDate() {
		return get("oper_date");
	}

	public void setIsDelete(java.lang.Integer isDelete) {
		set("is_delete", isDelete);
	}

	public java.lang.Integer getIsDelete() {
		return get("is_delete");
	}

	public void setProId(java.lang.Long proId) {
		set("pro_id", proId);
	}

	public java.lang.Long getProId() {
		return get("pro_id");
	}

	public void setSmsType(java.lang.Integer smsType) {
		set("sms_type", smsType);
	}

	public java.lang.Integer getSmsType() {
		return get("sms_type");
	}

}
