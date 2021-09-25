
package com.tstecon.ocp.admin.monitor.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("adminCmtVO")
public class AdminCmtVO {
	private Date cmt_date;
	private int mem_id;
	private String contents_name;
	private String cmt_text;
	public Date getCmt_date() {
		return cmt_date;
	}
	public void setCmt_date(Date cmt_date) {
		this.cmt_date = cmt_date;
	}
	public int getMem_id() {
		return mem_id;
	}
	public void setMem_id(int mem_id) {
		this.mem_id = mem_id;
	}
	public String getContents_name() {
		return contents_name;
	}
	public void setContents_name(String contents_name) {
		this.contents_name = contents_name;
	}
	public String getCmt_text() {
		return cmt_text;
	}
	public void setCmt_text(String cmt_text) {
		this.cmt_text = cmt_text;
	}
	

	
	
	
	
}


