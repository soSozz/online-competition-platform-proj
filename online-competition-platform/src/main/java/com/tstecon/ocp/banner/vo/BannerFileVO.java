package com.tstecon.ocp.banner.vo;

import org.springframework.stereotype.Repository;

@Repository("bannerFileVO")
public class BannerFileVO {
	private int banner_file_id;
	private int banner_id;
	private String banner_file_name;
	private String banner_file_type;
	
	private String banner_name;

	public int getBanner_file_id() {
		return banner_file_id;
	}

	public void setBanner_file_id(int banner_file_id) {
		this.banner_file_id = banner_file_id;
	}

	public int getBanner_id() {
		return banner_id;
	}

	public void setBanner_id(int banner_id) {
		this.banner_id = banner_id;
	}

	public String getBanner_file_name() {
		return banner_file_name;
	}

	public void setBanner_file_name(String banner_file_name) {
		this.banner_file_name = banner_file_name;
	}

	public String getBanner_file_type() {
		return banner_file_type;
	}

	public void setBanner_file_type(String banner_file_type) {
		this.banner_file_type = banner_file_type;
	}

	public String getBanner_name() {
		return banner_name;
	}

	public void setBanner_name(String banner_name) {
		this.banner_name = banner_name;
	}
}
