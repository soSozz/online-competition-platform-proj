package com.tstecon.ocp.admin.contents.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tstecon.ocp.admin.categ.service.AdminCategService;
import com.tstecon.ocp.admin.contents.service.AdminContentsService;
import com.tstecon.ocp.categ.vo.CategVO;
import com.tstecon.ocp.compet.service.CompetService;
import com.tstecon.ocp.compet.vo.CompetVO;
import com.tstecon.ocp.contents.vo.ContentsVO;

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
		Map<String, List<ContentsVO>> map = new HashMap<String, List<ContentsVO>>();
		Map<String, List<CompetVO>> competNames = new HashMap<String, List<CompetVO>>();
		List<CategVO> categNames = adminCategService.categName();
		List<ContentsVO> contentsList = adminContentsService.contentsList();
		List<ContentsVO> apprContentsList = adminContentsService.apprContentsList();
		
		for (CategVO i : categNames) {
			List<CompetVO> competList =  competService.competListByName(i.getCateg_name());
			// ... = competService.competListByCategId(i.categ_id);
			competNames.put(i.getCateg_name(), competList);
			//aa.put(i.categ_name, competList);
		}
		map.put("contentsList", contentsList);
		map.put("apprContentsList", apprContentsList);
		
		mav.addObject("dropdown", competNames);
		mav.addObject("map",map);
		return mav;
	}

	
	@Override
	@RequestMapping(value = { "/admin/adminContentsView.do" }, method = { RequestMethod.GET })
	public ModelAndView adminContentsView(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		List<ContentsVO> apprContentsList = adminContentsService.apprContentsList();
		mav.addObject("apprContentsList", apprContentsList);
		return mav;
	}
	
	@Override
	@RequestMapping(value = { "/admin/adminApprContents.do" }, method = { RequestMethod.GET })
	public ModelAndView adminContentsAppr(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		List<ContentsVO> apprContentsList = adminContentsService.apprContentsList();
		mav.addObject("apprContentsList", apprContentsList);
		return mav;
	}


	@Override
	public ModelAndView adminContentsRefusal(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);

		return mav;
	}

}
