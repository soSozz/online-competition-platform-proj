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
import com.tstecon.ocp.compet.qna.vo.CompetQnaVO;
import com.tstecon.ocp.compet.service.CompetService;
import com.tstecon.ocp.compet.vo.CompetVO;

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
	@RequestMapping(value = { "/compet/competInfo.do" }, method = { RequestMethod.GET })
	public ModelAndView CompetInfo(@RequestParam("compet_id") int compet_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");

		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		// 대회 안내 키 밸류 추가
		Map competInfo = competService.CompetInfo(compet_id);
		mav.addObject("competInfo", competInfo);
		// 대회 포스터 키 밸류 추가
		competInfo = competService.CompetPoster(compet_id);
		mav.addObject("competPoster", competInfo);
		return mav;
	}


	

	

}
