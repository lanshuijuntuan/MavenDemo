package com.sdj.rent.models.data.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseChargeTradeDetail<M extends BaseChargeTradeDetail<M>> extends Model<M> implements IBean {

	public void setTradeNo(java.lang.String tradeNo) {
		set("trade_no", tradeNo);
	}

	public java.lang.String getTradeNo() {
		return get("trade_no");
	}

	public void setTradeBatchNo(java.lang.String tradeBatchNo) {
		set("trade_batch_no", tradeBatchNo);
	}

	public java.lang.String getTradeBatchNo() {
		return get("trade_batch_no");
	}

	public void setCount(java.lang.Double count) {
		set("count", count);
	}

	public java.lang.Double getCount() {
		return get("count");
	}

	public void setPrice(java.math.BigDecimal price) {
		set("price", price);
	}

	public java.math.BigDecimal getPrice() {
		return get("price");
	}

	public void setReceiveAmount(java.math.BigDecimal receiveAmount) {
		set("receive_amount", receiveAmount);
	}

	public java.math.BigDecimal getReceiveAmount() {
		return get("receive_amount");
	}

	public void setPreferentialAmount(java.math.BigDecimal preferentialAmount) {
		set("preferential_amount", preferentialAmount);
	}

	public java.math.BigDecimal getPreferentialAmount() {
		return get("preferential_amount");
	}

	public void setPayAmount(java.math.BigDecimal payAmount) {
		set("pay_amount", payAmount);
	}

	public java.math.BigDecimal getPayAmount() {
		return get("pay_amount");
	}

	public void setChargeDetailId(java.lang.Long chargeDetailId) {
		set("charge_detail_id", chargeDetailId);
	}

	public java.lang.Long getChargeDetailId() {
		return get("charge_detail_id");
	}

	public void setChargeStartDate(java.util.Date chargeStartDate) {
		set("charge_start_date", chargeStartDate);
	}

	public java.util.Date getChargeStartDate() {
		return get("charge_start_date");
	}

	public void setChargeEndDate(java.util.Date chargeEndDate) {
		set("charge_end_date", chargeEndDate);
	}

	public java.util.Date getChargeEndDate() {
		return get("charge_end_date");
	}

	public void setOperDate(java.util.Date operDate) {
		set("oper_date", operDate);
	}

	public java.util.Date getOperDate() {
		return get("oper_date");
	}

	public void setOperPer(java.lang.String operPer) {
		set("oper_per", operPer);
	}

	public java.lang.String getOperPer() {
		return get("oper_per");
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

	public void setRemark(java.lang.String remark) {
		set("remark", remark);
	}

	public java.lang.String getRemark() {
		return get("remark");
	}

	public void setIsDelete(java.lang.Integer isDelete) {
		set("is_delete", isDelete);
	}

	public java.lang.Integer getIsDelete() {
		return get("is_delete");
	}

}
