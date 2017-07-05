package com.sdj.rent.models.data.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseCarPayRecord<M extends BaseCarPayRecord<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setCardId(java.lang.Long cardId) {
		set("card_id", cardId);
	}

	public java.lang.Long getCardId() {
		return get("card_id");
	}

	public void setPayMoney(java.math.BigDecimal payMoney) {
		set("pay_money", payMoney);
	}

	public java.math.BigDecimal getPayMoney() {
		return get("pay_money");
	}

	public void setBeginTime(java.util.Date beginTime) {
		set("begin_time", beginTime);
	}

	public java.util.Date getBeginTime() {
		return get("begin_time");
	}

	public void setEndTime(java.util.Date endTime) {
		set("end_time", endTime);
	}

	public java.util.Date getEndTime() {
		return get("end_time");
	}

	public void setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
	}

	public java.util.Date getCreateTime() {
		return get("create_time");
	}

	public void setIsDelete(java.lang.Integer isDelete) {
		set("is_delete", isDelete);
	}

	public java.lang.Integer getIsDelete() {
		return get("is_delete");
	}

	public void setUserId(java.lang.Long userId) {
		set("user_id", userId);
	}

	public java.lang.Long getUserId() {
		return get("user_id");
	}

	public void setTradeNo(java.lang.String tradeNo) {
		set("trade_no", tradeNo);
	}

	public java.lang.String getTradeNo() {
		return get("trade_no");
	}

}
