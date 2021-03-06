package com.sdj.rent.models.data.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseFinTradeRecord<M extends BaseFinTradeRecord<M>> extends Model<M> implements IBean {

	public void setTradeRecordId(java.lang.String tradeRecordId) {
		set("trade_record_id", tradeRecordId);
	}

	public java.lang.String getTradeRecordId() {
		return get("trade_record_id");
	}

	public void setChargeId(java.lang.Long chargeId) {
		set("charge_id", chargeId);
	}

	public java.lang.Long getChargeId() {
		return get("charge_id");
	}

	public void setAccountingDate(java.util.Date accountingDate) {
		set("accounting_date", accountingDate);
	}

	public java.util.Date getAccountingDate() {
		return get("accounting_date");
	}

	public void setBusinessType(java.lang.String businessType) {
		set("business_type", businessType);
	}

	public java.lang.String getBusinessType() {
		return get("business_type");
	}

	public void setBatchNo(java.lang.String batchNo) {
		set("batch_no", batchNo);
	}

	public java.lang.String getBatchNo() {
		return get("batch_no");
	}

	public void setOtherName(java.lang.String otherName) {
		set("other_name", otherName);
	}

	public java.lang.String getOtherName() {
		return get("other_name");
	}

	public void setOtherNum(java.lang.String otherNum) {
		set("other_num", otherNum);
	}

	public java.lang.String getOtherNum() {
		return get("other_num");
	}

	public void setAmt(java.math.BigDecimal amt) {
		set("amt", amt);
	}

	public java.math.BigDecimal getAmt() {
		return get("amt");
	}

	public void setTradeDire(java.lang.String tradeDire) {
		set("trade_dire", tradeDire);
	}

	public java.lang.String getTradeDire() {
		return get("trade_dire");
	}

	public void setProId(java.lang.Long proId) {
		set("pro_id", proId);
	}

	public java.lang.Long getProId() {
		return get("pro_id");
	}

	public void setRoomId(java.lang.Long roomId) {
		set("room_id", roomId);
	}

	public java.lang.Long getRoomId() {
		return get("room_id");
	}

	public void setOwnerId(java.lang.Long ownerId) {
		set("owner_id", ownerId);
	}

	public java.lang.Long getOwnerId() {
		return get("owner_id");
	}

	public void setOperPer(java.lang.String operPer) {
		set("oper_per", operPer);
	}

	public java.lang.String getOperPer() {
		return get("oper_per");
	}

	public void setRemark(java.lang.String remark) {
		set("remark", remark);
	}

	public java.lang.String getRemark() {
		return get("remark");
	}

}
