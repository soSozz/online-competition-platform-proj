package com.tstecon.ocp.compet.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("CompetVO")
public class CompetVO {
	private int compet_id;
	private int categ_id;
	private String compet_name;
	private Date compet_start;
	private Date compet_end;
	private Date compet_create;
	private String compet_text;
	private String compet_terminated;

//	파일 정보 추가
	private int compet_file_id;
	private String compet_file_type;
	private String compet_file_name;

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

	public int getCompet_file_id() {
		return compet_file_id;
	}

	public void setCompet_file_id(int compet_file_id) {
		this.compet_file_id = compet_file_id;
	}

	public String getCompet_file_type() {
		return compet_file_type;
	}

	public void setCompet_file_type(String compet_file_type) {
		this.compet_file_type = compet_file_type;
	}

	public String getCompet_file_name() {
		return compet_file_name;
	}

	public void setCompet_file_name(String compet_file_name) {
		this.compet_file_name = compet_file_name;
	}

}
