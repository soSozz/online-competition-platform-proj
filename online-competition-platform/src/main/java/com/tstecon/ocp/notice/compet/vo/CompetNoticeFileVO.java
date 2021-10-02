package com.tstecon.ocp.notice.compet.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("competNoticeFileVO")
public class CompetNoticeFileVO {
	private int compet_notice_id;
	private int compet_notice_file_id;
	private String compet_notice_file_name;
	private String compet_notice_file_type;
	public int getCompet_notice_id() {
		return compet_notice_id;
	}
	public void setCompet_notice_id(int compet_notice_id) {
		this.compet_notice_id = compet_notice_id;
	}
	public int getCompet_notice_file_id() {
		return compet_notice_file_id;
	}
	public void setCompet_notice_file_id(int compet_notice_file_id) {
		this.compet_notice_file_id = compet_notice_file_id;
	}
	public String getCompet_notice_file_name() {
		return compet_notice_file_name;
	}
	public void setCompet_notice_file_name(String compet_notice_file_name) {
		this.compet_notice_file_name = compet_notice_file_name;
	}
	public String getCompet_notice_file_type() {
		return compet_notice_file_type;
	}
	public void setCompet_notice_file_type(String compet_notice_file_type) {
		this.compet_notice_file_type = compet_notice_file_type;
	}


}
