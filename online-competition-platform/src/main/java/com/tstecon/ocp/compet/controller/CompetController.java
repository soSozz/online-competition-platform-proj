package com.tstecon.ocp.compet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface CompetController {
//	대회안내 페이지
<<<<<<< HEAD
	public ModelAndView CompetInfo(@RequestParam("compet_id") int compet_id,HttpServletRequest request, HttpServletResponse reponse) throws Exception;
=======
	public ModelAndView CompetInfo(@RequestParam("compet_id") String compet_id,HttpServletRequest request, HttpServletResponse reponse) throws Exception;
//문의 페이지
public ModelAndView Compet_qna_list(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
>>>>>>> branch 'master' of https://github.com/ITHwang/online-competition-platform-proj.git
}


