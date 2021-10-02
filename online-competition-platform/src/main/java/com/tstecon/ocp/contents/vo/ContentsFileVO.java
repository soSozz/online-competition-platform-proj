package com.tstecon.ocp.contents.vo;

import org.springframework.stereotype.Component;

@Component("contentsFileVO")
public class ContentsFileVO {
	private int contents_file_id;
	private int contents_id;
	private String contents_file_type;
	private String contents_file_name;

	public int getContents_file_id() {
		return contents_file_id;
	}

	public void setContents_file_id(int contents_file_id) {
		this.contents_file_id = contents_file_id;
	}

	public int getContents_id() {
		return contents_id;
	}

	public void setContents_id(int contents_id) {
		this.contents_id = contents_id;
	}

	public String getContents_file_type() {
		return contents_file_type;
	}

	public void setContents_file_type(String contents_file_type) {
		this.contents_file_type = contents_file_type;
	}

	public String getContents_file_name() {
		return contents_file_name;
	}

	public void setContents_file_name(String contents_file_name) {
		this.contents_file_name = contents_file_name;
	}

}
