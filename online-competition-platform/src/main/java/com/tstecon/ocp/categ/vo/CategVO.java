package com.tstecon.ocp.categ.vo;

import org.springframework.stereotype.Component;

@Component("CategVO")
public class CategVO {
	private int categ_id;
	private String categ_name;
	
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
}
