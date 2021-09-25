
package com.tstecon.ocp.admin.stat.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("adminStatVO")
public class AdminStatVO {
	private String ctg_name;
	private int cnt;
	private int viw;
	private int like;
	private int cmt;
	private String compet_name;
	private String contents_name;
	private String mem_nickname;
	private Date contents_processing_date;
	private int contents_view;
	private int cmt1;
	private int likes1;
	
	
	public String getCtg_name() {
		return ctg_name;
	}
	public void setCtg_name(String ctg_name) {
		this.ctg_name = ctg_name;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getViw() {
		return viw;
	}
	public void setViw(int viw) {
		this.viw = viw;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public int getCmt() {
		return cmt;
	}
	public void setCmt(int cmt) {
		this.cmt = cmt;
	}
	public String getCompet_name() {
		return compet_name;
	}
	public void setCompet_name(String compet_name) {
		this.compet_name = compet_name;
	}
	public String getContents_name() {
		return contents_name;
	}
	public void setContents_name(String contents_name) {
		this.contents_name = contents_name;
	}
	public String getMem_nickname() {
		return mem_nickname;
	}
	public void setMem_nickname(String mem_nickname) {
		this.mem_nickname = mem_nickname;
	}
	public Date getContents_processing_date() {
		return contents_processing_date;
	}
	public void setContents_processing_date(Date contents_processing_date) {
		this.contents_processing_date = contents_processing_date;
	}
	public int getContents_view() {
		return contents_view;
	}
	public void setContents_view(int contents_view) {
		this.contents_view = contents_view;
	}
	public int getCmt1() {
		return cmt1;
	}
	public void setCmt1(int cmt1) {
		this.cmt1 = cmt1;
	}
	public int getLikes1() {
		return likes1;
	}
	public void setLikes1(int likes1) {
		this.likes1 = likes1;
	}
	
	
	
}


