package com.tstecon.ocp.admin.categ.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tstecon.ocp.admin.categ.dao.AdminCategDAO;
import com.tstecon.ocp.admin.categ.service.AdminCategService;

@Controller("AdminCategController")
public class AdminCategControllerImpl implements AdminCategController{
	@Autowired
	private AdminCategService adminCategService;
	
	@Autowired
	private AdminCategDAO adminCategDAO;
	
	@Override
	@RequestMapping(value = { "/admin/admincateg.do" }, method = { RequestMethod.GET })
	public ModelAndView adminCateg(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		Map categList = adminCategService.Categlist();
		mav.addObject("categList", categList);
		
		categList = adminCategService.Competlist();
		mav.addObject("competList", categList);
		return mav;
	}

}
