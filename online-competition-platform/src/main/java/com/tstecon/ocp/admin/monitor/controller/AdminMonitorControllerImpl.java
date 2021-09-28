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

import net.sf.json.JSONObject;

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
	
	@RequestMapping(value = "/admin/monitor/selectLikegraph.do", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String adminLikeList(HttpServletRequest request, HttpServletResponse response)throws Exception {
	  response.setContentType("text/html;charset=utf-8");
	  response.setCharacterEncoding("utf-8");
	  List<AdminMonitorVO> adminLikeList = AdminMonitorService.adminLikeList();
	  ArrayList responses = new ArrayList();
	  for(int i =0; i < adminLikeList.size(); i ++) {
	    HashMap<String , Object> map = new HashMap<String, Object>();
	    map.put("Date", adminLikeList.get(i).getLikesdate());
	    map.put("Likes", adminLikeList.get(i).getCnt());
	    responses.add(map);
	  } 
	  JSONObject jsonObject = new JSONObject();
	  jsonObject.put("responses", responses);
	  String jsonInfo = jsonObject.toString();
	  System.out.println("json:" + jsonInfo);
	  return jsonInfo;
	}
	
	@RequestMapping(value = "/admin/monitor/selectCmtgraph.do", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String adminCmtsList(HttpServletRequest request, HttpServletResponse response)throws Exception {
	  response.setContentType("text/html;charset=utf-8");
	  response.setCharacterEncoding("utf-8");
	  List<AdminMonitorVO> adminCmtsList = AdminMonitorService.adminCmtsList();
	  ArrayList responses = new ArrayList();
	  for(int i =0; i < adminCmtsList.size(); i ++) {
	    HashMap<String , Object> map = new HashMap<String, Object>();
	    map.put("Date", adminCmtsList.get(i).getCmtsdate());
	    map.put("Cmts", adminCmtsList.get(i).getCmtcnt());
	    responses.add(map);
	  } 
	  JSONObject jsonObject = new JSONObject();
	  jsonObject.put("responses", responses);
	  String jsonInfo = jsonObject.toString();
	  System.out.println("json:" + jsonInfo);
	  return jsonInfo;
	}


}
