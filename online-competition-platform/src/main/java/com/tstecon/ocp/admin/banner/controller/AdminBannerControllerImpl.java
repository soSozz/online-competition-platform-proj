package com.tstecon.ocp.admin.banner.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tstecon.ocp.banner.service.BannerService;
import com.tstecon.ocp.banner.vo.BannerFileVO;

@Controller("adminBannerController")
public class AdminBannerControllerImpl implements AdminBannerController {
	@Autowired
	private BannerService bannerService;

	@Override
	@RequestMapping(value = { "/admin/adminBanner.do" }, method = { RequestMethod.GET })
	public ModelAndView adminBanner(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		List<BannerFileVO> bannerFileList = bannerService.listBannerFiles();

		mav.addObject("bannerFileList", bannerFileList);
		return mav;

	}

}
