package com.sdj.rent.models.data.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseFinRechargeRecord<M extends BaseFinRechargeRecord<M>> extends Model<M> implements IBean {

	public void setRechargeRecordId(java.lang.Long rechargeRecordId) {
		set("recharge_record_id", rechargeRecordId);
	}

	public java.lang.Long getRechargeRecordId() {
		return get("recharge_record_id");
	}

	public void setPrepaidId(java.lang.String prepaidId) {
		set("prepaid_id", prepaidId);
	}

	public java.lang.String getPrepaidId() {
		return get("prepaid_id");
	}

	public void setRoomId(java.lang.Long roomId) {
		set("room_id", roomId);
	}

	public java.lang.Long getRoomId() {
		return get("room_id");
	}

	public void setGuestId(java.lang.Long guestId) {
		set("guest_id", guestId);
	}

	public java.lang.Long getGuestId() {
		return get("guest_id");
	}

	public void setProId(java.lang.Long proId) {
		set("pro_id", proId);
	}

	public java.lang.Long getProId() {
		return get("pro_id");
	}

	public void setRechargeAmount(java.math.BigDecimal rechargeAmount) {
		set("recharge_amount", rechargeAmount);
	}

	public java.math.BigDecimal getRechargeAmount() {
		return get("recharge_amount");
	}

	public void setChargeType(java.lang.Long chargeType) {
		set("charge_type", chargeType);
	}

	public java.lang.Long getChargeType() {
		return get("charge_type");
	}

	public void setPoundage(java.math.BigDecimal poundage) {
		set("poundage", poundage);
	}

	public java.math.BigDecimal getPoundage() {
		return get("poundage");
	}

	public void setRechargeDate(java.util.Date rechargeDate) {
		set("recharge_date", rechargeDate);
	}

	public java.util.Date getRechargeDate() {
		return get("recharge_date");
	}

	public void setRechargeOperPer(java.lang.String rechargeOperPer) {
		set("recharge_oper_per", rechargeOperPer);
	}

	public java.lang.String getRechargeOperPer() {
		return get("recharge_oper_per");
	}

	public void setRemark(java.lang.String remark) {
		set("remark", remark);
	}

	public java.lang.String getRemark() {
		return get("remark");
	}

	public void setExtType(java.lang.Integer extType) {
		set("ext_type", extType);
	}

	public java.lang.Integer getExtType() {
		return get("ext_type");
	}

	public void setUserId(java.lang.Long userId) {
		set("user_id", userId);
	}

	public java.lang.Long getUserId() {
		return get("user_id");
	}

	public void setNum(java.lang.String num) {
		set("num", num);
	}

	public java.lang.String getNum() {
		return get("num");
	}

	public void setType(java.lang.Integer type) {
		set("type", type);
	}

	public java.lang.Integer getType() {
		return get("type");
	}

	public void setReceivablesTime(java.util.Date receivablesTime) {
		set("receivables_time", receivablesTime);
	}

	public java.util.Date getReceivablesTime() {
		return get("receivables_time");
	}

	public void setCostStartDate(java.util.Date costStartDate) {
		set("cost_start_date", costStartDate);
	}

	public java.util.Date getCostStartDate() {
		return get("cost_start_date");
	}

	public void setCostEndDate(java.util.Date costEndDate) {
		set("cost_end_date", costEndDate);
	}

	public java.util.Date getCostEndDate() {
		return get("cost_end_date");
	}

	public void setTariffMoney(java.math.BigDecimal tariffMoney) {
		set("tariff_money", tariffMoney);
	}

	public java.math.BigDecimal getTariffMoney() {
		return get("tariff_money");
	}

	public void setTax(java.math.BigDecimal tax) {
		set("tax", tax);
	}

	public java.math.BigDecimal getTax() {
		return get("tax");
	}

	public void setIsCharge(java.lang.Integer isCharge) {
		set("is_charge", isCharge);
	}

	public java.lang.Integer getIsCharge() {
		return get("is_charge");
	}

}
