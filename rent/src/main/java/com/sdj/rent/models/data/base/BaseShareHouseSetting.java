package com.sdj.rent.models.data.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseShareHouseSetting<M extends BaseShareHouseSetting<M>> extends Model<M> implements IBean {

	public void setManagementId(java.lang.Long managementId) {
		set("management_id", managementId);
	}

	public java.lang.Long getManagementId() {
		return get("management_id");
	}

	public void setHouseId(java.lang.Long houseId) {
		set("house_id", houseId);
	}

	public java.lang.Long getHouseId() {
		return get("house_id");
	}

	public void setShareRate(java.lang.Double shareRate) {
		set("share_rate", shareRate);
	}

	public java.lang.Double getShareRate() {
		return get("share_rate");
	}

	public void setProId(java.lang.Long proId) {
		set("pro_id", proId);
	}

	public java.lang.Long getProId() {
		return get("pro_id");
	}

	public void setIsDelete(java.lang.Integer isDelete) {
		set("is_delete", isDelete);
	}

	public java.lang.Integer getIsDelete() {
		return get("is_delete");
	}

}
