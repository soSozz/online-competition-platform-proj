package com.tstecon.ocp.admin.monitor.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tstecon.ocp.admin.monitor.service.AdminMonitorService;
import com.tstecon.ocp.admin.monitor.vo.AdminCmtVO;
import com.tstecon.ocp.admin.monitor.vo.AdminMonitorVO;

@Controller("AdminMonitorController")
public class AdminMonitorControllerImpl implements AdminMonitorController {

	@Autowired
	private AdminMonitorService AdminMonitorService;

	@Override
	@RequestMapping(value="/admin/monitor/adminMonitor.do", method=RequestMethod.GET)
	public ModelAndView adminMonitor(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String)request.getAttribute("viewName");
		
//		AdminMonitorVO adminMonitorLikes = AdminMonitorService.Likes(HashMap LikesMap);
//		AdminMonitorVO adminMonitorCmt = AdminMonitorService.Cmt(HashMap CmtMap);
		List<AdminCmtVO> adminCmtList = AdminMonitorService.adminCmtList();
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("adminCmtList", adminCmtList);
		
		
		return mav;
    }

}
