package com.sdj.rent.models.data.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseOrderRefundDetail<M extends BaseOrderRefundDetail<M>> extends Model<M> implements IBean {

	public void setRefundDetailId(java.lang.Long refundDetailId) {
		set("refund_detail_id", refundDetailId);
	}

	public java.lang.Long getRefundDetailId() {
		return get("refund_detail_id");
	}

	public void setRefundId(java.lang.Long refundId) {
		set("refund_id", refundId);
	}

	public java.lang.Long getRefundId() {
		return get("refund_id");
	}

	public void setTradeDetailId(java.lang.String tradeDetailId) {
		set("trade_detail_id", tradeDetailId);
	}

	public java.lang.String getTradeDetailId() {
		return get("trade_detail_id");
	}

	public void setChargeItemName(java.lang.String chargeItemName) {
		set("charge_item_name", chargeItemName);
	}

	public java.lang.String getChargeItemName() {
		return get("charge_item_name");
	}

	public void setRefundAmount(java.math.BigDecimal refundAmount) {
		set("refund_amount", refundAmount);
	}

	public java.math.BigDecimal getRefundAmount() {
		return get("refund_amount");
	}

	public void setProId(java.lang.Long proId) {
		set("pro_id", proId);
	}

	public java.lang.Long getProId() {
		return get("pro_id");
	}

	public void setPayRefundAmount(java.math.BigDecimal payRefundAmount) {
		set("pay_refund_amount", payRefundAmount);
	}

	public java.math.BigDecimal getPayRefundAmount() {
		return get("pay_refund_amount");
	}

}
