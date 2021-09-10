package com.tstecon.ocp.compet.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tstecon.ocp.compet.dao.CompetDAO;
import com.tstecon.ocp.compet.service.CompetService;
import com.tstecon.ocp.compet.vo.CompetVO;

@Controller("competController")
public class CompetControllerImpl implements CompetController {
	@Autowired
	private CompetService competService;
	
	@Autowired
	private CompetDAO competDAO;
	
	@Override
	@RequestMapping(value="/compet/competInfo", method = RequestMethod.GET)
	public ModelAndView CompetInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		Map<String,List<CompetVO>> competInfo = competService.CompetInfo();
		mav.addObject("competInfo", competInfo);
		return mav;
	}

}
