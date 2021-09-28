package com.tstecon.ocp.admin.banner.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface AdminBannerController {
	
	public ModelAndView adminBanner(HttpServletRequest request, HttpServletResponse reponse) throws Exception;

}
