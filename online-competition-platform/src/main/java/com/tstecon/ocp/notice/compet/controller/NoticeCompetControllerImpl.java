package com.tstecon.ocp.notice.compet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.pro27.member.controller.MemberController;
import com.myspring.pro27.member.controller.MemberControllerImpl;
import com.myspring.pro27.member.service.MemberService;
import com.myspring.pro27.member.vo.MemberVO;

@Controller("NoticeCompetController")
public class NoticeCompetImpl implements NoticeCompetController {
	private static final Logger logger = LoggerFactory.getLogger(NoticeCompetImpl.class);
	@Autowired
	private NoticeCompetService NoticeCompetService;
	@Autowired
	private CompetService CompetService;
	
	@Override
	@RequestMapping(value="/member/listMembers.do", method = RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/* String viewName = getViewName(request); */
		String viewName = (String)request.getAttribute("viewName");
		logger.debug("debug ·¹º§ : viewName: "+ viewName);
		List membersList = NoticeCompetService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;
	}