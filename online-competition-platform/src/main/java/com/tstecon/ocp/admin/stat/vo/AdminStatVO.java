package com.tstecon.ocp.admin.stat.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("adminStatVO")
public class AdminStatVO {
	private int ctg_name;
	private int cnt;
	private int viw;
	private int like;
	
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public int getCtg_name() {
		return ctg_name;
	}
	public void setCtg_name(int ctg_name) {
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
	
	
	
	
}
