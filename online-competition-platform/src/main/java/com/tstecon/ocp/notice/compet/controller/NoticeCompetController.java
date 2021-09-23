package com.tstecon.ocp.notice.compet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface NoticeCompetController {
	public ModelAndView listCompetNotices(@RequestParam("compet_id") int compet_id, HttpServletRequest request, HttpServletResponse response);
    
}
