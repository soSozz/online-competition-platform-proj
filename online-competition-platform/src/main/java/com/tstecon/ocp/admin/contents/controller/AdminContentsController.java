package com.tstecon.ocp.admin.contents.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface AdminContentsController {
	public ModelAndView adminContents(HttpServletRequest request, HttpServletResponse reponse) throws Exception;
	
	public ModelAndView adminContentsView(@RequestParam("contents_id") int contents_id,  HttpServletRequest request, HttpServletResponse reponse) throws Exception;
	
	public ModelAndView adminContentsAppr(@RequestParam("contents_id") int contents_id, HttpServletRequest request, HttpServletResponse reponse) throws Exception;
	
	public ModelAndView adminContentsRefusal(@RequestParam("contents_id") int contents_id, @RequestParam("contents_reject_reason") String contents_reject_reason, 
			HttpServletRequest request, HttpServletResponse reponse) throws Exception;
}
