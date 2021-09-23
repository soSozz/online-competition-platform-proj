package com.tstecon.ocp.banner.vo;

import org.springframework.stereotype.Repository;

@Repository("bannerVO")
public class BannerVO {
	private int banner_id;
	private String banner_name;

	public int getBanner_id() {
		return banner_id;
	}

	public void setBanner_id(int banner_id) {
		this.banner_id = banner_id;
	}

	public String getBanner_name() {
		return banner_name;
	}

	public void setBanner_name(String banner_name) {
		this.banner_name = banner_name;
	}
}
