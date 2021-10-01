package com.tstecon.ocp.admin.contents.controller;

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

import com.tstecon.ocp.admin.categ.service.AdminCategService;
import com.tstecon.ocp.admin.contents.service.AdminContentsService;
import com.tstecon.ocp.admin.monitor.vo.AdminMonitorVO;
import com.tstecon.ocp.categ.vo.CategVO;
import com.tstecon.ocp.compet.service.CompetService;
import com.tstecon.ocp.compet.vo.CompetVO;
import com.tstecon.ocp.contents.vo.ContentsFileVO;
import com.tstecon.ocp.contents.vo.ContentsVO;

import net.sf.json.JSONObject;

@Controller("adminContents")
public class AdminContentsControllerImpl implements AdminContentsController{
	@Autowired
	private AdminContentsService adminContentsService;
	
	@Autowired
	private AdminCategService adminCategService;
	
	@Autowired
	private CompetService competService;
	
	@Override
	@RequestMapping(value = { "/admin/adminContents.do" }, method = { RequestMethod.GET })
	public ModelAndView adminContents(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		Map<String, List<CompetVO>> dropdown = new HashMap<String, List<CompetVO>>();
		List<CategVO> categList = adminCategService.CategAllList();
		
		for (CategVO i : categList) {
			List<CompetVO> competList = competService.competListByName(i.getCateg_id());
			// ... = competService.competListByCategId(i.categ_id);
			dropdown.put(i.getCateg_name(), competList);
			//aa.put(i.categ_name, competList);
		}
		
		

		
		
		mav.addObject("dropdown", dropdown);
		
		return mav;
	}
	
	@RequestMapping(value = "/admin/selectCompetList.do", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String selectAdminContents(HttpServletRequest request, HttpServletResponse response)throws Exception {
	  response.setContentType("text/html;charset=utf-8");
	  response.setCharacterEncoding("utf-8");
	  
	  int categ_id = adminCategService.CategIdByName(request.getParameter("categ_name"));
	  System.out.println(request.getParameter("categ_name"));
	  List<CompetVO> competList = competService.competListById(categ_id);
	  
	  ArrayList responses = new ArrayList();
	  for(int i =0; i < competList.size(); i++) {
	    HashMap<String , Object> map = new HashMap<String, Object>();
	    map.put("compet_name", competList.get(i).getCompet_name());
	    responses.add(map);
	  } 
	  JSONObject jsonObject = new JSONObject();
	  jsonObject.put("responses", responses);
	  String jsonInfo = jsonObject.toString();
	  System.out.println("json:" + jsonInfo);
	  
	  return jsonInfo;
	}
	
	@RequestMapping(value = "/admin/selectContentsList.do", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String selectContentsList(HttpServletRequest request, HttpServletResponse response)throws Exception {
	  response.setContentType("text/html;charset=utf-8");
	  response.setCharacterEncoding("utf-8");
	  
	  int compet_id = competService.competIdByCompetName(request.getParameter("compet_name"));

	  System.out.println(request.getParameter("compet_name"));
	  List<ContentsVO> contentsList = adminContentsService.contentsList(compet_id);
	  System.out.println("contentsList:" + contentsList.get(0).getContents_id());
	  List<ContentsVO> apprContentsList = adminContentsService.apprContentsList(compet_id);
	  System.out.println("apprContentsList:" + apprContentsList.get(0).getContents_id());
	 //ø©±‚±Ó¡ˆ~
	  
	  ArrayList arrayContentsList = new ArrayList();
	  for(int i =0; i < contentsList.size(); i++) {
	    HashMap<String , Object> map = new HashMap<String, Object>();
	    map.put("contents_id", contentsList.get(i).getContents_id());
	    map.put("contents_name", contentsList.get(i).getContents_name());
	    map.put("mem_id", contentsList.get(i).getMem_id());
	    map.put("contents_processing_date", contentsList.get(i).getContents_processing_date());
	    arrayContentsList.add(map);
	  } 
	  
	  ArrayList arrayApprContentsList = new ArrayList();
	  for(int i =0; i < apprContentsList.size(); i++) {
	    HashMap<String , Object> map = new HashMap<String, Object>();
	    map.put("contents_name", apprContentsList.get(i).getContents_name());
	    map.put("mem_id", apprContentsList.get(i).getMem_id());
	    map.put("contents_processing_date", apprContentsList.get(i).getContents_processing_date());
	    arrayApprContentsList.add(map);
	  } 
	  
	  JSONObject jsonObject = new JSONObject();
	  jsonObject.put("contentsList", arrayContentsList);
	  jsonObject.put("apprContentsList", arrayApprContentsList);
	  String jsonInfo = jsonObject.toString();
	  System.out.println("json:" + jsonInfo);
	  
	  return jsonInfo;
	}
	
	// ¡¶√‚«— ƒ¡≈Ÿ√˜ ¿⁄ºº»˜ ∫∏±‚
	@Override
	@RequestMapping(value = { "/admin/adminContentsView.do" }, method = { RequestMethod.GET })
	public ModelAndView adminContentsView(@RequestParam("contents_id") int contents_id, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		List<ContentsVO> contentsView = adminContentsService.selectContentsView(contents_id);
		List<ContentsFileVO> contentsFileView = adminContentsService.selectContentsFileView(contents_id);
		
		mav.addObject("contentsView",contentsView);
		mav.addObject("contentsFileView",contentsFileView);
		return mav;
	}
	
	// ¡¶√‚«— ƒ¡≈Ÿ√˜ Ω¬¿Œ
	@Override
	@RequestMapping(value = { "/admin/adminContentsAppr.do" }, method = { RequestMethod.GET })
	public ModelAndView adminContentsAppr(@RequestParam("contents_id") int contents_id, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		adminContentsService.updateApprContents(contents_id);
		
		mav.setViewName("redirect:/admin/adminContents.do");
		return mav;
	}

	// ¡¶√‚«— ƒ¡≈Ÿ√˜ ∞≈¿˝
	@Override
	@RequestMapping(value = { "/admin/adminContentsRefusal.do" }, method = { RequestMethod.GET })
	public ModelAndView adminContentsRefusal(@RequestParam("contents_id") int contents_id, @RequestParam("contents_reject_reason") String contents_reject_reason, 
			HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		Map map = new HashMap();
		map.put("contents_id", contents_id);
		map.put("contents_reject_reason", contents_reject_reason);
		adminContentsService.updateRefusalContents(map);
		
		mav.setViewName("redirect:/admin/adminContents.do");
		return mav;
	}

}
