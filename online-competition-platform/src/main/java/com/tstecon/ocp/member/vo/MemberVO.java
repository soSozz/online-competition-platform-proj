package com.tstecon.ocp.member.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("memberVO")
public class MemberVO {
	private String mem_id;
	private String mem_pwd;
	private String mem_name;
	private String mem_nickname;
	private String mem_stu_id;
	private String mem_dept;
	private String mem_major;
	private int mem_grade;
	private int mem_tel1;
	private int mem_tel2;
	private int mem_tel3;
	private int mem_phone1;
	private int mem_phone2;
	private int mem_phone3;
	private String mem_email1;
	private String mem_email2;
	private String mem_new_addr;
	private String mem_ole_addr;
	private String mem_detail_addr;
	private int mem_zipcode;
	private String mem_contents_alert;
	private String mem_push_alert;
	
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pwd() {
		return mem_pwd;
	}
	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_nickname() {
		return mem_nickname;
	}
	public void setMem_nickname(String mem_nickname) {
		this.mem_nickname = mem_nickname;
	}
	public String getMem_stu_id() {
		return mem_stu_id;
	}
	public void setMem_stu_id(String mem_stu_id) {
		this.mem_stu_id = mem_stu_id;
	}
	public String getMem_dept() {
		return mem_dept;
	}
	public void setMem_dept(String mem_dept) {
		this.mem_dept = mem_dept;
	}
	public String getMem_major() {
		return mem_major;
	}
	public void setMem_major(String mem_major) {
		this.mem_major = mem_major;
	}
	public int getMem_grade() {
		return mem_grade;
	}
	public void setMem_grade(int mem_grade) {
		this.mem_grade = mem_grade;
	}
	public int getMem_tel1() {
		return mem_tel1;
	}
	public void setMem_tel1(int mem_tel1) {
		this.mem_tel1 = mem_tel1;
	}
	public int getMem_tel2() {
		return mem_tel2;
	}
	public void setMem_tel2(int mem_tel2) {
		this.mem_tel2 = mem_tel2;
	}
	public int getMem_tel3() {
		return mem_tel3;
	}
	public void setMem_tel3(int mem_tel3) {
		this.mem_tel3 = mem_tel3;
	}
	public int getMem_phone1() {
		return mem_phone1;
	}
	public void setMem_phone1(int mem_phone1) {
		this.mem_phone1 = mem_phone1;
	}
	public int getMem_phone2() {
		return mem_phone2;
	}
	public void setMem_phone2(int mem_phone2) {
		this.mem_phone2 = mem_phone2;
	}
	public int getMem_phone3() {
		return mem_phone3;
	}
	public void setMem_phone3(int mem_phone3) {
		this.mem_phone3 = mem_phone3;
	}
	public String getMem_email1() {
		return mem_email1;
	}
	public void setMem_email1(String mem_email1) {
		this.mem_email1 = mem_email1;
	}
	public String getMem_email2() {
		return mem_email2;
	}
	public void setMem_email2(String mem_email2) {
		this.mem_email2 = mem_email2;
	}
	public String getMem_new_addr() {
		return mem_new_addr;
	}
	public void setMem_new_addr(String mem_new_addr) {
		this.mem_new_addr = mem_new_addr;
	}
	public String getMem_ole_addr() {
		return mem_ole_addr;
	}
	public void setMem_ole_addr(String mem_ole_addr) {
		this.mem_ole_addr = mem_ole_addr;
	}
	public String getMem_detail_addr() {
		return mem_detail_addr;
	}
	public void setMem_detail_addr(String mem_detail_addr) {
		this.mem_detail_addr = mem_detail_addr;
	}
	public int getMem_zipcode() {
		return mem_zipcode;
	}
	public void setMem_zipcode(int mem_zipcode) {
		this.mem_zipcode = mem_zipcode;
	}
	public String getMem_contents_alert() {
		return mem_contents_alert;
	}
	public void setMem_contents_alert(String mem_contents_alert) {
		this.mem_contents_alert = mem_contents_alert;
	}
	public String getMem_push_alert() {
		return mem_push_alert;
	}
	public void setMem_push_alert(String mem_push_alert) {
		this.mem_push_alert = mem_push_alert;
	}
}