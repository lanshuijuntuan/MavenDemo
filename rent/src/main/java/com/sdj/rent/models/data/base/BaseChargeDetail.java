package com.sdj.rent.models.data.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseChargeDetail<M extends BaseChargeDetail<M>> extends Model<M> implements IBean {

	public void setDetailId(java.lang.Long detailId) {
		set("detail_id", detailId);
	}

	public java.lang.Long getDetailId() {
		return get("detail_id");
	}

	public void setDetailName(java.lang.String detailName) {
		set("detail_name", detailName);
	}

	public java.lang.String getDetailName() {
		return get("detail_name");
	}

	public void setChargeId(java.lang.Long chargeId) {
		set("charge_id", chargeId);
	}

	public java.lang.Long getChargeId() {
		return get("charge_id");
	}

	public void setAccountingPrecision(java.lang.String accountingPrecision) {
		set("accounting_precision", accountingPrecision);
	}

	public java.lang.String getAccountingPrecision() {
		return get("accounting_precision");
	}

	public void setChargePrice(java.math.BigDecimal chargePrice) {
		set("charge_price", chargePrice);
	}

	public java.math.BigDecimal getChargePrice() {
		return get("charge_price");
	}

	public void setScheduleStart(java.util.Date scheduleStart) {
		set("schedule_start", scheduleStart);
	}

	public java.util.Date getScheduleStart() {
		return get("schedule_start");
	}

	public void setScheduleEnd(java.util.Date scheduleEnd) {
		set("schedule_end", scheduleEnd);
	}

	public java.util.Date getScheduleEnd() {
		return get("schedule_end");
	}

	public void setBatchrunDate(java.lang.Integer batchrunDate) {
		set("batchrun_date", batchrunDate);
	}

	public java.lang.Integer getBatchrunDate() {
		return get("batchrun_date");
	}

	public void setAccountingMode(java.lang.Integer accountingMode) {
		set("accounting_mode", accountingMode);
	}

	public java.lang.Integer getAccountingMode() {
		return get("accounting_mode");
	}

	public void setAccountingNum(java.lang.Integer accountingNum) {
		set("accounting_num", accountingNum);
	}

	public java.lang.Integer getAccountingNum() {
		return get("accounting_num");
	}

	public void setAccountingUnit(java.lang.Integer accountingUnit) {
		set("accounting_unit", accountingUnit);
	}

	public java.lang.Integer getAccountingUnit() {
		return get("accounting_unit");
	}

	public void setStartDate(java.util.Date startDate) {
		set("start_date", startDate);
	}

	public java.util.Date getStartDate() {
		return get("start_date");
	}

	public void setEndDate(java.util.Date endDate) {
		set("end_date", endDate);
	}

	public java.util.Date getEndDate() {
		return get("end_date");
	}

	public void setRemark(java.lang.String remark) {
		set("remark", remark);
	}

	public java.lang.String getRemark() {
		return get("remark");
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

	public void setFeeType(java.lang.Integer feeType) {
		set("fee_type", feeType);
	}

	public java.lang.Integer getFeeType() {
		return get("fee_type");
	}

	public void setLateFee(java.math.BigDecimal lateFee) {
		set("late_fee", lateFee);
	}

	public java.math.BigDecimal getLateFee() {
		return get("late_fee");
	}

	public void setDiscount(java.math.BigDecimal discount) {
		set("discount", discount);
	}

	public java.math.BigDecimal getDiscount() {
		return get("discount");
	}

	public void setIncreaseMonth(java.lang.Integer increaseMonth) {
		set("increase_month", increaseMonth);
	}

	public java.lang.Integer getIncreaseMonth() {
		return get("increase_month");
	}

	public void setIncreaseRate(java.math.BigDecimal increaseRate) {
		set("increase_rate", increaseRate);
	}

	public java.math.BigDecimal getIncreaseRate() {
		return get("increase_rate");
	}

	public void setLateFeeStart(java.lang.Integer lateFeeStart) {
		set("late_fee_start", lateFeeStart);
	}

	public java.lang.Integer getLateFeeStart() {
		return get("late_fee_start");
	}

	public void setLastUpdatePriceDate(java.util.Date lastUpdatePriceDate) {
		set("last_update_price_date", lastUpdatePriceDate);
	}

	public java.util.Date getLastUpdatePriceDate() {
		return get("last_update_price_date");
	}

	public void setNotLateFeeStartDate(java.util.Date notLateFeeStartDate) {
		set("not_late_fee_start_date", notLateFeeStartDate);
	}

	public java.util.Date getNotLateFeeStartDate() {
		return get("not_late_fee_start_date");
	}

	public void setNotLateFeeEndDate(java.util.Date notLateFeeEndDate) {
		set("not_late_fee_end_date", notLateFeeEndDate);
	}

	public java.util.Date getNotLateFeeEndDate() {
		return get("not_late_fee_end_date");
	}

	public void setTariff(java.lang.Integer tariff) {
		set("tariff", tariff);
	}

	public java.lang.Integer getTariff() {
		return get("tariff");
	}

}
