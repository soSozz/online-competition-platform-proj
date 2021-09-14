package com.tstecon.ocp.notice.compet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tstecon.ocp.compet.service.CompetService;
import com.tstecon.ocp.compet.vo.CompetFileVO;
import com.tstecon.ocp.notice.compet.service.NoticeCompetService;
import com.tstecon.ocp.notice.compet.vo.NoticeCompetVO;


@Controller("NoticeCompetController")
public class NoticeCompetControllerImpl implements NoticeCompetController {
	
	@Autowired
	private NoticeCompetService NoticeCompetService;
	@Autowired
	private CompetService CompetService;
	
	@Override
	@RequestMapping(value="/notice/compet/listCompetNotices.do", method=RequestMethod.GET)
	public ModelAndView listCompetNotices(@RequestParam("compet_id") int compet_id, HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String)request.getAttribute("viewName");
		
		//NoticeCompetService: 공지사항 리스트 가져오기
		//CompetService: 작은포스터 가져오기
		
		List<NoticeCompetVO> noticeCompetList = NoticeCompetService.listCompetNotices(compet_id);
		CompetFileVO smallPoster = CompetService.CompetSmallPoster(compet_id);
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("noticeCompetList", noticeCompetList);
		mav.addObject("smallPoster", smallPoster);
		return mav;
	}
}
	
//	@Override
//	@RequestMapping(value="/member/listMembers.do", method = RequestMethod.GET)
//	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		/* String viewName = getViewName(request); */
//		String viewName = (String)request.getAttribute("viewName");
//		logger.debug("debug 레벨 : viewName: "+ viewName);
//		List membersList = NoticeCompetService.listMembers();
//		ModelAndView mav = new ModelAndView(viewName);
//		mav.addObject("membersList", membersList);
//		return mav;
//	}