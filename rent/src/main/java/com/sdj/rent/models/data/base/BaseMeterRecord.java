package com.sdj.rent.models.data.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseMeterRecord<M extends BaseMeterRecord<M>> extends Model<M> implements IBean {

	public void setRecordId(java.lang.Long recordId) {
		set("record_id", recordId);
	}

	public java.lang.Long getRecordId() {
		return get("record_id");
	}

	public void setManageId(java.lang.Long manageId) {
		set("manage_id", manageId);
	}

	public java.lang.Long getManageId() {
		return get("manage_id");
	}

	public void setHouseId(java.lang.Long houseId) {
		set("house_id", houseId);
	}

	public java.lang.Long getHouseId() {
		return get("house_id");
	}

	public void setRoomId(java.lang.Long roomId) {
		set("room_id", roomId);
	}

	public java.lang.Long getRoomId() {
		return get("room_id");
	}

	public void setMeterId(java.lang.Long meterId) {
		set("meter_id", meterId);
	}

	public java.lang.Long getMeterId() {
		return get("meter_id");
	}

	public void setRecordStatus(java.lang.Integer recordStatus) {
		set("record_status", recordStatus);
	}

	public java.lang.Integer getRecordStatus() {
		return get("record_status");
	}

	public void setRecordType(java.lang.Integer recordType) {
		set("record_type", recordType);
	}

	public java.lang.Integer getRecordType() {
		return get("record_type");
	}

	public void setBeforeReading(java.lang.Double beforeReading) {
		set("before_reading", beforeReading);
	}

	public java.lang.Double getBeforeReading() {
		return get("before_reading");
	}

	public void setNowReading(java.lang.Double nowReading) {
		set("now_reading", nowReading);
	}

	public java.lang.Double getNowReading() {
		return get("now_reading");
	}

	public void setAccount(java.lang.Double account) {
		set("account", account);
	}

	public java.lang.Double getAccount() {
		return get("account");
	}

	public void setBeforeReadDate(java.util.Date beforeReadDate) {
		set("before_read_date", beforeReadDate);
	}

	public java.util.Date getBeforeReadDate() {
		return get("before_read_date");
	}

	public void setNowReadDate(java.util.Date nowReadDate) {
		set("now_read_date", nowReadDate);
	}

	public java.util.Date getNowReadDate() {
		return get("now_read_date");
	}

	public void setStatus(java.lang.Integer status) {
		set("status", status);
	}

	public java.lang.Integer getStatus() {
		return get("status");
	}

	public void setAuditUser(java.lang.String auditUser) {
		set("audit_user", auditUser);
	}

	public java.lang.String getAuditUser() {
		return get("audit_user");
	}

	public void setAuditTime(java.lang.String auditTime) {
		set("audit_time", auditTime);
	}

	public java.lang.String getAuditTime() {
		return get("audit_time");
	}

	public void setReadPer(java.lang.String readPer) {
		set("read_per", readPer);
	}

	public java.lang.String getReadPer() {
		return get("read_per");
	}

	public void setReadPhone(java.lang.String readPhone) {
		set("read_phone", readPhone);
	}

	public java.lang.String getReadPhone() {
		return get("read_phone");
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

	public void setUserId(java.lang.Long userId) {
		set("user_id", userId);
	}

	public java.lang.Long getUserId() {
		return get("user_id");
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

	public void setMeterNum(java.lang.String meterNum) {
		set("meter_num", meterNum);
	}

	public java.lang.String getMeterNum() {
		return get("meter_num");
	}

	public void setMeterName(java.lang.String meterName) {
		set("meter_name", meterName);
	}

	public java.lang.String getMeterName() {
		return get("meter_name");
	}

	public void setMeterSpec(java.lang.Integer meterSpec) {
		set("meter_spec", meterSpec);
	}

	public java.lang.Integer getMeterSpec() {
		return get("meter_spec");
	}

}
