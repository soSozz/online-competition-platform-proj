package com.tstecon.ocp.admin.banner.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tstecon.ocp.admin.banner.service.AdminBannerService;
@Controller("adminBannerController")
public class AdminBannerControllerImpl implements AdminBannerController{
	@Autowired
	private AdminBannerService adminBannerService;
	
	@Override
	@RequestMapping(value = { "/admin/adminBanner.do" }, method = { RequestMethod.GET })
	public ModelAndView adminBanner(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		List bannerList = new ArrayList();
		bannerList = adminBannerService.selectBannerName();
		mav.addObject("bannerList",bannerList);
		return mav;
		
	}

}
