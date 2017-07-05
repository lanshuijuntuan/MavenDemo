package com.sdj.rent.models.data.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseSysRecMenu<M extends BaseSysRecMenu<M>> extends Model<M> implements IBean {

	public void setRecId(java.lang.Long recId) {
		set("rec_id", recId);
	}

	public java.lang.Long getRecId() {
		return get("rec_id");
	}

	public void setRecName(java.lang.String recName) {
		set("rec_name", recName);
	}

	public java.lang.String getRecName() {
		return get("rec_name");
	}

	public void setRecActionUrl(java.lang.String recActionUrl) {
		set("rec_action_url", recActionUrl);
	}

	public java.lang.String getRecActionUrl() {
		return get("rec_action_url");
	}

	public void setOperateTime(java.util.Date operateTime) {
		set("operate_time", operateTime);
	}

	public java.util.Date getOperateTime() {
		return get("operate_time");
	}

	public void setLevels(java.lang.Long levels) {
		set("levels", levels);
	}

	public java.lang.Long getLevels() {
		return get("levels");
	}

	public void setPid(java.lang.Long pid) {
		set("pid", pid);
	}

	public java.lang.Long getPid() {
		return get("pid");
	}

	public void setStatus(java.lang.String status) {
		set("status", status);
	}

	public java.lang.String getStatus() {
		return get("status");
	}

	public void setPicUrl(java.lang.String picUrl) {
		set("pic_url", picUrl);
	}

	public java.lang.String getPicUrl() {
		return get("pic_url");
	}

	public void setOrgOrder(java.lang.Long orgOrder) {
		set("org_order", orgOrder);
	}

	public java.lang.Long getOrgOrder() {
		return get("org_order");
	}

	public void setSysOne(java.lang.String sysOne) {
		set("sys_one", sysOne);
	}

	public java.lang.String getSysOne() {
		return get("sys_one");
	}

	public void setProId(java.lang.Long proId) {
		set("pro_id", proId);
	}

	public java.lang.Long getProId() {
		return get("pro_id");
	}

}
