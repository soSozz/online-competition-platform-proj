package com.tstecon.ocp.admin.stat.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("adminStatVO")
public class AdminStatVO {
	private int ctg_name;
	private int cut;
	private int viw;
	public int getCtg_name() {
		return ctg_name;
	}
	public void setCtg_name(int ctg_name) {
		this.ctg_name = ctg_name;
	}
	public int getCut() {
		return cut;
	}
	public void setCut(int cut) {
		this.cut = cut;
	}
	public int getViw() {
		return viw;
	}
	public void setViw(int viw) {
		this.viw = viw;
	}
	
	
	
}
