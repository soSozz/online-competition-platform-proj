package com.tstecon.ocp.admin.stat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tstecon.ocp.admin.stat.service.AdminStatService;
import com.tstecon.ocp.admin.stat.vo.AdminStatVO;
import com.tstecon.ocp.notice.compet.vo.NoticeCompetVO;



@Controller("AdminStatController")
public class AdminStatControllerImpl implements AdminStatController {
  
    @Autowired
	private AdminStatService AdminStatService;
    
    @Override
	@RequestMapping(value="/admin/stat/adminStat.do", method=RequestMethod.GET)
	public ModelAndView adminStat(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String)request.getAttribute("viewName");
		
		List<AdminStatVO> adminContentsList = AdminStatService.adminContentsList();
		List<AdminStatVO> adminLikesList = AdminStatService.adminLikesList();
		List<AdminStatVO> adminCmtList = AdminStatService.adminCmtList();
		List<AdminStatVO> adminViewList = AdminStatService.adminViewList();
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("adminContentsList", adminContentsList);
		mav.addObject("adminLikesList", adminLikesList);
		mav.addObject("adminViewList", adminViewList);
		mav.addObject("adminCmtList", adminCmtList);
		return mav;
    }
   
}
