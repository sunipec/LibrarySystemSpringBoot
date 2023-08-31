package com.digit.LMSApp.Payload;

import lombok.Data;

@Data
public class ReviewDto {
	int rid;
	String comment;
	int uid;
	int bid;
	/**
	 * @param rid
	 * @param comment
	 * @param uid
	 * @param bid
	 */
	public ReviewDto(int rid, String comment, int uid, int bid) {
		super();
		this.rid = rid;
		this.comment = comment;
		this.uid = uid;
		this.bid = bid;
	}
	/**
	 * 
	 */
	public ReviewDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	
	
	

	

}
