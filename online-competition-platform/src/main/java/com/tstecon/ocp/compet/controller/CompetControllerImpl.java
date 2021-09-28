package com.tstecon.ocp.compet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tstecon.ocp.categ.service.CategService;
import com.tstecon.ocp.categ.vo.CategVO;
import com.tstecon.ocp.compet.dao.CompetDAO;
import com.tstecon.ocp.compet.service.CompetService;
import com.tstecon.ocp.compet.vo.CompetVO;

@Controller("CompetController")
public class CompetControllerImpl implements CompetController {
	@Autowired
	private CompetService competService;

	@Autowired
	private CompetDAO competDAO;

	@Autowired
	private CategService categService;

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

		mav.addObject("compet_id", compet_id);
		return mav;
	}

	@Override
	@RequestMapping(value = "/compet/competList.do", method = RequestMethod.GET)
	public ModelAndView competList(@RequestParam("categ_name") String categ_name, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("dropdown", categ_name);

		List<CompetVO> competList = new ArrayList<CompetVO>();
		if (categ_name.equals("전체보기")) {
			competList = competService.competAllList();
		} else {
			competList = competService.competListByCategName(categ_name);
		}
		List<CategVO> categList = categService.listCategs();

		mav.addObject("competList", competList);
		mav.addObject("categList", categList);
		return mav;
	}

}
