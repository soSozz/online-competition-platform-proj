package com.tstecon.ocp.admin.categ.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface AdminCategController {
	
	public ModelAndView adminCateg(HttpServletRequest request, HttpServletResponse reponse) throws Exception;
	
	public ModelAndView addCategForm(HttpServletRequest request, HttpServletResponse reponse) throws Exception;
	
	public ModelAndView addCompet(HttpServletRequest request, HttpServletResponse reponse) throws Exception;
	
	public ModelAndView competFinish(HttpServletRequest request, HttpServletResponse reponse) throws Exception;
	
	public ModelAndView competDelete(HttpServletRequest request, HttpServletResponse reponse) throws Exception;
}
