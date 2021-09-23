package com.tstecon.ocp.compet.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("CompetVO")
public class CompetVO {
	private int compet_id;
	private int categ_id;
	private int compet_limit;
	private String compet_name;
	private Date compet_start;
	private Date compet_end;
	private Date compet_create;
	private String compet_text;
	private String compet_terminated;
	
	public int getCompet_id() {
		return compet_id;
	}
	public void setCompet_id(int compet_id) {
		this.compet_id = compet_id;
	}
	public int getCateg_id() {
		return categ_id;
	}
	public void setCateg_id(int categ_id) {
		this.categ_id = categ_id;
	}
	public int getCompet_limit() {
		return compet_limit;
	}
	public void setCompet_limit(int compet_limit) {
		this.compet_limit = compet_limit;
	}
	public String getCompet_name() {
		return compet_name;
	}
	public void setCompet_name(String compet_name) {
		this.compet_name = compet_name;
	}
	public Date getCompet_start() {
		return compet_start;
	}
	public void setCompet_start(Date compet_start) {
		this.compet_start = compet_start;
	}
	public Date getCompet_end() {
		return compet_end;
	}
	public void setCompet_end(Date compet_end) {
		this.compet_end = compet_end;
	}
	public Date getCompet_create() {
		return compet_create;
	}
	public void setCompet_create(Date compet_create) {
		this.compet_create = compet_create;
	}
	public String getCompet_text() {
		return compet_text;
	}
	public void setCompet_text(String compet_text) {
		this.compet_text = compet_text;
	}
	public String getCompet_terminated() {
		return compet_terminated;
	}
	public void setCompet_terminated(String compet_terminated) {
		this.compet_terminated = compet_terminated;
	}
	
	
	
}
