package com.tstecon.ocp.admin.stat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface AdminStatController {
	public ModelAndView adminStat(HttpServletRequest request, HttpServletResponse response);
}
