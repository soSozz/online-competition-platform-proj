package com.tstecon.ocp.compet.qna.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("competQnaVO")
public class CompetQnaVO {
	private int level;
	private int compet_qna_id;
	private String mem_id;
	private int compet_id;
	private String admin_id;
	private String compet_qna_title;
	private Date compet_qna_date;
	private int compet_qna_view;
	private int parent_id;
	private String compet_qna_text;
	
	
	public int getCompet_qna_id() {
		return compet_qna_id;
	}
	public void setCompet_qna_id(int compet_qna_id) {
		this.compet_qna_id = compet_qna_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getCompet_id() {
		return compet_id;
	}
	public void setCompet_id(int compet_id) {
		this.compet_id = compet_id;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getCompet_qna_title() {
		return compet_qna_title;
	}
	public void setCompet_qna_title(String compet_qna_title) {
		this.compet_qna_title = compet_qna_title;
	}
	public Date getCompet_qna_date() {
		return compet_qna_date;
	}
	public void setCompet_qna_date(Date compet_qna_date) {
		this.compet_qna_date = compet_qna_date;
	}
	public int getCompet_qna_view() {
		return compet_qna_view;
	}
	public void setCompet_qna_view(int compet_qna_view) {
		this.compet_qna_view = compet_qna_view;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getCompet_qna_text() {
		return compet_qna_text;
	}
	public void setCompet_qna_text(String compet_qna_text) {
		this.compet_qna_text = compet_qna_text;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
