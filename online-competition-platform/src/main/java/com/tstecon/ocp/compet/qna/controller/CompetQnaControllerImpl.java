package com.tstecon.ocp.compet.qna.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tstecon.ocp.compet.qna.dao.CompetQnaDAO;
import com.tstecon.ocp.compet.qna.service.CompetQnaService;
import com.tstecon.ocp.compet.qna.vo.CompetQnaVO;



@Controller("CompetQnaController")
public  class CompetQnaControllerImpl implements CompetQnaController {
	@Autowired
	private CompetQnaService competQnaService;

	@Autowired
	private CompetQnaDAO competQnaDAO;
	
	@Autowired
    private CompetQnaVO competqnaVO;
	

//문의 페이지	
	@Override
	@RequestMapping(value = "/compet/qna.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView Compet_qna_list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List qnaList = competQnaService.qnalistArticles();
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
			  competqnaVO = competQnaService.login(member);
			  if(competqnaVO != null ) {
				  
			  }
		
		return null;
	}
	
	

}
