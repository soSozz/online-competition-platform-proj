
package com.tstecon.ocp.admin.monitor.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("adminMonitorVO")
public class AdminMonitorVO {
	private Date likes_date;
	private int likes_id;
	private Date cmt_date;
	private int cmt_id;
	private String likesdate;
	private int cnt;
	private String cmtsdate;
	private int cmtcnt;
	private String start_date;
	private String end_date;
	public Date getLikes_date() {
		return likes_date;
	}
	public void setLikes_date(Date likes_date) {
		this.likes_date = likes_date;
	}
	public int getLikes_id() {
		return likes_id;
	}
	public void setLikes_id(int likes_id) {
		this.likes_id = likes_id;
	}
	public Date getCmt_date() {
		return cmt_date;
	}
	public void setCmt_date(Date cmt_date) {
		this.cmt_date = cmt_date;
	}
	public int getCmt_id() {
		return cmt_id;
	}
	public void setCmt_id(int cmt_id) {
		this.cmt_id = cmt_id;
	}

	public String getLikesdate() {
		return likesdate;
	}
	public void setLikesdate(String likesdate) {
		this.likesdate = likesdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getCmtsdate() {
		return cmtsdate;
	}
	public void setCmtsdate(String cmtsdate) {
		this.cmtsdate = cmtsdate;
	}
	public int getCmtcnt() {
		return cmtcnt;
	}
	public void setCmtcnt(int cmtcnt) {
		this.cmtcnt = cmtcnt;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	

	
	


	
	
}


