package com.tstecon.ocp.compet.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tstecon.ocp.compet.dao.CompetDAO;
import com.tstecon.ocp.compet.service.CompetService;
import com.tstecon.ocp.compet.vo.CompetVO;
import com.tstecon.ocp.qna.vo.CompetQnaVO;

@Controller("CompetController")
public class CompetControllerImpl implements CompetController {
	@Autowired
	private CompetService competService;
	
	@Autowired
	private CompetDAO competDAO;
	
	@Autowired
    private CompetQnaVO competqnaVO;
	
//	대회안내페이지
	@Override
	@RequestMapping(value={"/compet/competInfo.do"}, method = {RequestMethod.GET})
	public ModelAndView CompetInfo(@RequestParam("compet_id") int compet_id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		Map competInfo = competService.CompetInfo(compet_id);
		mav.addObject("competInfo", competInfo);
		return mav;
	}
//문의 페이지	
	@Override
	@RequestMapping(value= "/compet/qna.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Compet_qna_list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		List qnaList = competService.qnalistArticles();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("qnaList", qnaList);
		return mav;
		
	}
//문의 페이지 로그인
	@Override
	@RequestMapping(value = "/compet/login.do", method = RequestMethod.POST )
	public ModelAndView Compet_qna_login(@ModelAttribute("member")CompetQnaVO member, RedirectAttributes rAttr,
			  HttpServletRequest request, HttpServletResponse response) throws Exception{
			  ModelAndView mav = new ModelAndView();
			  competqnaVO = competService.login(member);
			  if(competqnaVO != null ) {
				  
			  }
		
		return null;
	}
	
	
	

}
