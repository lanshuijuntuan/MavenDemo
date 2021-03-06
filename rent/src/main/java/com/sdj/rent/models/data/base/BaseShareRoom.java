package com.sdj.rent.models.data.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseShareRoom<M extends BaseShareRoom<M>> extends Model<M> implements IBean {

	public void setShareRoomId(java.lang.Long shareRoomId) {
		set("share_room_id", shareRoomId);
	}

	public java.lang.Long getShareRoomId() {
		return get("share_room_id");
	}

	public void setMeterId(java.lang.Long meterId) {
		set("meter_id", meterId);
	}

	public java.lang.Long getMeterId() {
		return get("meter_id");
	}

	public void setRoomIds(java.lang.String roomIds) {
		set("room_ids", roomIds);
	}

	public java.lang.String getRoomIds() {
		return get("room_ids");
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
