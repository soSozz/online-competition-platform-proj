package com.tstecon.ocp.compet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface CompetController {
//	대회안내 페이지
	public ModelAndView CompetInfo(@RequestParam("compet_id") int compet_id, HttpServletRequest request,
			HttpServletResponse reponse) throws Exception;

// 대회목록 페이지
	public ModelAndView competList(@RequestParam("categ_name") String categ_name, HttpServletRequest request,
			HttpServletResponse response) throws Exception;
}
