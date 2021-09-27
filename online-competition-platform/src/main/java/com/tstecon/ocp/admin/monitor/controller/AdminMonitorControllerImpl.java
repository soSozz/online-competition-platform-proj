package com.tstecon.ocp.admin.monitor.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping(value = "/admin/monitor/selectLikegraph.do", method = RequestMethod.POST)
	@ResponseBody
	public List adminLikeList()throws Exception {
	  List<AdminMonitorVO> adminLikeList = AdminMonitorService.adminLikeList();
	  ArrayList response = new ArrayList();
	  for(int i =0; i < adminLikeList.size(); i ++) {
	    HashMap<String , Object> map = new HashMap<String, Object>();
	    map.put("Date", adminLikeList.get(i).getLikesdate());
	    map.put("Likes", adminLikeList.get(i).getCnt());
	    response.add(map);
	    System.out.println(map);
	    System.out.println(response);
	  }
	  System.out.println(response);
	  return response;

	}

}
