package com.tstecon.ocp.admin.stat.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("adminStatVO")
public class AdminStatVO {
	private int contents_id;
	private int mem_id;
	private int compet_id;
	private String contents_state;
	private Date contents_processing_date;
	private String contents_reject_reason;
	private int contents_view;
	
	private int categ_id;
	private String categ_name;
	
	private int compet_limit;
	private int compet_name;
	private Date compet_start;
	private Date compet_end;
	private Date compet_create;
	private String compet_text;
	
	public int getContents_id() {
		return contents_id;
	}
	public void setContents_id(int contents_id) {
		this.contents_id = contents_id;
	}
	public int getMem_id() {
		return mem_id;
	}
	public void setMem_id(int mem_id) {
		this.mem_id = mem_id;
	}
	public int getCompet_id() {
		return compet_id;
	}
	public void setCompet_id(int compet_id) {
		this.compet_id = compet_id;
	}
	public String getContents_state() {
		return contents_state;
	}
	public void setContents_state(String contents_state) {
		this.contents_state = contents_state;
	}
	public Date getContents_processing_date() {
		return contents_processing_date;
	}
	public void setContents_processing_date(Date contents_processing_date) {
		this.contents_processing_date = contents_processing_date;
	}
	public String getContents_reject_reason() {
		return contents_reject_reason;
	}
	public void setContents_reject_reason(String contents_reject_reason) {
		this.contents_reject_reason = contents_reject_reason;
	}
	public int getContents_view() {
		return contents_view;
	}
	public void setContents_view(int contents_view) {
		this.contents_view = contents_view;
	}
	public int getCateg_id() {
		return categ_id;
	}
	public void setCateg_id(int categ_id) {
		this.categ_id = categ_id;
	}
	public String getCateg_name() {
		return categ_name;
	}
	public void setCateg_name(String categ_name) {
		this.categ_name = categ_name;
	}
	public int getCompet_limit() {
		return compet_limit;
	}
	public void setCompet_limit(int compet_limit) {
		this.compet_limit = compet_limit;
	}
	public int getCompet_name() {
		return compet_name;
	}
	public void setCompet_name(int compet_name) {
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
	public int getCmt_id() {
		return cmt_id;
	}
	public void setCmt_id(int cmt_id) {
		this.cmt_id = cmt_id;
	}
	public Date getCmt_date() {
		return cmt_date;
	}
	public void setCmt_date(Date cmt_date) {
		this.cmt_date = cmt_date;
	}
	public int getLikes_id() {
		return likes_id;
	}
	public void setLikes_id(int likes_id) {
		this.likes_id = likes_id;
	}
	public Date getLikes_date() {
		return likes_date;
	}
	public void setLikes_date(Date likes_date) {
		this.likes_date = likes_date;
	}
	private int cmt_id;
	private Date cmt_date;
	
	private int likes_id;
	private Date likes_date;
	
	
	
}
