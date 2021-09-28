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
<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://github.com/ITHwang/online-competition-platform-proj.git
import com.tstecon.ocp.banner.vo.BannerFileVO;

@Controller("adminBannerController")
public class AdminBannerControllerImpl implements AdminBannerController {
	@Autowired
<<<<<<< HEAD

	private BannerService BannerService;


=======
>>>>>>> branch 'master' of https://github.com/ITHwang/online-competition-platform-proj.git
	private BannerService bannerService;
<<<<<<< HEAD
	
=======

>>>>>>> branch 'master' of https://github.com/ITHwang/online-competition-platform-proj.git
	@Override
	@RequestMapping(value = { "/admin/adminBanner.do" }, method = { RequestMethod.GET })
	public ModelAndView adminBanner(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
<<<<<<< HEAD
		List bannerList = new ArrayList();
		bannerList = BannerService.listBannerFiles();
		mav.addObject("bannerList", bannerList);
		
=======
>>>>>>> branch 'master' of https://github.com/ITHwang/online-competition-platform-proj.git
		List<BannerFileVO> bannerFileList = bannerService.listBannerFiles();
<<<<<<< HEAD
		
		mav.addObject("bannerFileList",bannerFileList);
=======

		mav.addObject("bannerFileList", bannerFileList);
>>>>>>> branch 'master' of https://github.com/ITHwang/online-competition-platform-proj.git
		return mav;

	}

}
