package com.tstecon.ocp.admin.categ.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tstecon.ocp.compet.vo.CompetVO;

public interface AdminCategController {
	
	public ModelAndView adminCateg(HttpServletRequest request, HttpServletResponse reponse) throws Exception;
	
	public ModelAndView addCategForm(HttpServletRequest request, HttpServletResponse reponse) throws Exception;
	
	public ModelAndView addCompet(@RequestParam Map<String,Object> addCompetMap,HttpServletRequest request, HttpServletResponse reponse) throws Exception;
	
	public ModelAndView competFinish(HttpServletRequest request, HttpServletResponse reponse) throws Exception;
	
	public ModelAndView competDelete(HttpServletRequest request, HttpServletResponse reponse) throws Exception;
}
