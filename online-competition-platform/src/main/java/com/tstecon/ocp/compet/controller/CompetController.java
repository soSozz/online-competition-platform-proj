package com.tstecon.ocp.compet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface CompetController {
	public ModelAndView CompetInfo(HttpServletRequest request, HttpServletResponse reponse) throws Exception;
}
