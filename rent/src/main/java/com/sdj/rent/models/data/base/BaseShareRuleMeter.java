package com.sdj.rent.models.data.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseShareRuleMeter<M extends BaseShareRuleMeter<M>> extends Model<M> implements IBean {

	public void setShareRuleId(java.lang.Long shareRuleId) {
		set("share_rule_id", shareRuleId);
	}

	public java.lang.Long getShareRuleId() {
		return get("share_rule_id");
	}

	public void setMeterId(java.lang.Long meterId) {
		set("meter_id", meterId);
	}

	public java.lang.Long getMeterId() {
		return get("meter_id");
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

}
