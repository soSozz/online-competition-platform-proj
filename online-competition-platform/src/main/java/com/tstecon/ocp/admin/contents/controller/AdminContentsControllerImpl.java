package com.tstecon.ocp.admin.contents.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	private CompetService adminCompetService;
	
	@Override
	public ModelAndView adminContents(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		Map<String, List<ContentsVO>> contentsList = new HashMap<String, List<ContentsVO>>();
		List<CategVO> categName = adminCategService.CategName();
		List<CompetVO> competName = adminCompetService.CompetName();
		
		
		return mav;
	}

}
