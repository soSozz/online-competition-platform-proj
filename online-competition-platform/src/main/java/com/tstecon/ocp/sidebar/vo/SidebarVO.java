package com.tstecon.ocp.sidebar.vo;

import org.springframework.stereotype.Component;

@Component("sidebarVO")
public class SidebarVO {
	private String mem_nickname;
	private int cnt;

	public String getMem_nickname() {
		return mem_nickname;
	}

	public void setMem_nickname(String mem_nickname) {
		this.mem_nickname = mem_nickname;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
