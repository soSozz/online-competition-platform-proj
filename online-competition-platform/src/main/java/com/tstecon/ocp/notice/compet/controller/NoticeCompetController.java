package com.tstecon.ocp.notice.compet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public interface NoticeCompetController {
	public ModelAndView listCompetNotices(@RequestParam("compet_id") int compet_id, HttpServletRequest request, HttpServletResponse response);
	public ModelAndView noticeCompetDetail(@RequestParam("compet_notice_id") int compet_notice_id, HttpServletRequest request, HttpServletResponse response);
	public ResponseEntity addNewNoticeCompet(HttpServletRequest request, HttpServletResponse response)
			throws Exception; 
	
}

