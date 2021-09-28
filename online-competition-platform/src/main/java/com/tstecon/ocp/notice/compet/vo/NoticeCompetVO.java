package com.tstecon.ocp.notice.compet.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("noticeCompetVO")
public class NoticeCompetVO {
	private int compet_notice_id;
	private int compet_id;
	private int admin_id;
	private String compet_notice_title;
	private Date compet_notice_date;
	private int compet_notice_view;
	private String compet_notice_text;
	
	public int getCompet_notice_id() {
		return compet_notice_id;
	}
	public void setCompet_notice_id(int compet_notice_id) {
		this.compet_notice_id = compet_notice_id;
	}
	public int getCompet_id() {
		return compet_id;
	}
	public void setCompet_id(int compet_id) {
		this.compet_id = compet_id;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getCompet_notice_title() {
		return compet_notice_title;
	}
	public void setCompet_notice_title(String compet_notice_title) {
		this.compet_notice_title = compet_notice_title;
	}
	public Date getCompet_notice_date() {
		return compet_notice_date;
	}
	public void setCompet_notice_date(Date compet_notice_date) {
		this.compet_notice_date = compet_notice_date;
	}
	public int getCompet_notice_view() {
		return compet_notice_view;
	}
	public void setCompet_notice_view(int compet_notice_view) {
		this.compet_notice_view = compet_notice_view;
	}
	public String getCompet_notice_text() {
		return compet_notice_text;
	}
	public void setCompet_notice_text(String compet_notice_text) {
		this.compet_notice_text = compet_notice_text;
	}
	
	
}
