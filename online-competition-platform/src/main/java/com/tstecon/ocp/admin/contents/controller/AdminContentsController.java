package com.tstecon.ocp.admin.contents.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface AdminContentsController {
	public ModelAndView adminContents(HttpServletRequest request, HttpServletResponse reponse) throws Exception;
	
	public ModelAndView adminApprContents(HttpServletRequest request, HttpServletResponse reponse) throws Exception;
	
	public ModelAndView adminContentsView(HttpServletRequest request, HttpServletResponse reponse) throws Exception;
	
	public ModelAndView adminContentsAppr(HttpServletRequest request, HttpServletResponse reponse) throws Exception;
	
	public ModelAndView adminContentsReject(HttpServletRequest request, HttpServletResponse reponse) throws Exception;
}
