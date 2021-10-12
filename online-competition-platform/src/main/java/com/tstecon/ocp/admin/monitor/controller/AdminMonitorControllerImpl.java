package com.tstecon.ocp.admin.monitor.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

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
	@RequestMapping(value = "/admin/monitor/adminMonitor.do", method = RequestMethod.GET)
	public ModelAndView adminMonitor(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");

//		AdminMonitorVO adminMonitorLikes = AdminMonitorService.Likes(HashMap LikesMap);
//		AdminMonitorVO adminMonitorCmt = AdminMonitorService.Cmt(HashMap CmtMap);
		List<AdminCmtVO> adminCmtList = AdminMonitorService.adminCmtList();

		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("adminCmtList", adminCmtList);

		return mav;
	}

	@RequestMapping(value = "/admin/monitor/selectLikegraph.do", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String adminLikeList(@RequestParam("date") String date, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		StringTokenizer dates = new StringTokenizer(date, "-");
		String start_date;
		String end_date;

		String date1 = dates.nextToken().trim();
		String date2 = dates.nextToken().trim();

//		end_date = date2.trim();

		StringTokenizer st1 = new StringTokenizer(date1, "/");
		String month = st1.nextToken();
		String day = st1.nextToken();
		String year = st1.nextToken();

		start_date = year + "-" + month + "-" + day;

		StringTokenizer st2 = new StringTokenizer(date2, "/");

		String month1 = st2.nextToken();
		String day1 = st2.nextToken();
		String year1 = st2.nextToken();

		end_date = year1 + "-" + month1 + "-" + day1;
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("start_dateMap", start_date);
		dateMap.put("end_dateMap", end_date);

		List<AdminMonitorVO> adminLikeList = AdminMonitorService.adminLikeList(dateMap);
		ArrayList responses = new ArrayList();
		for (int i = 0; i < adminLikeList.size(); i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("Date", adminLikeList.get(i).getLikesdate());
			map.put("Likes", adminLikeList.get(i).getCnt());
			responses.add(map);

		}
		System.out.println(responses);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("responses", responses);
		String jsonInfo = jsonObject.toString();
		System.out.println("json:" + jsonInfo);
		return jsonInfo;
	}

	@RequestMapping(value = "/admin/monitor/selectCmtgraph.do", method = { RequestMethod.GET })
	@ResponseBody
	public String adminCmtsList(@RequestParam("date") String date, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");

		StringTokenizer dates = new StringTokenizer(date, "-");
		String start_date;
		String end_date;

		String date1 = dates.nextToken().trim();
		String date2 = dates.nextToken().trim();

//		end_date = date2.trim();

		StringTokenizer st1 = new StringTokenizer(date1, "/");
		String month = st1.nextToken();
		String day = st1.nextToken();
		String year = st1.nextToken();

		start_date = year + "-" + month + "-" + day;

		StringTokenizer st2 = new StringTokenizer(date2, "/");

		String month1 = st2.nextToken();
		String day1 = st2.nextToken();
		String year1 = st2.nextToken();

		end_date = year1 + "-" + month1 + "-" + day1;
		Map<String, String> dateMaps = new HashMap<String, String>();
		dateMaps.put("start_dateMaps", start_date);
		dateMaps.put("end_dateMaps", end_date);

		List<AdminMonitorVO> adminCmtsList = AdminMonitorService.adminCmtsList(dateMaps);
		ArrayList responses = new ArrayList();
		for (int i = 0; i < adminCmtsList.size(); i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
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
