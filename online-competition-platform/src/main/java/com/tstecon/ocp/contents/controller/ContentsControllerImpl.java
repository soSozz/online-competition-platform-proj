package com.tstecon.ocp.contents.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tstecon.ocp.contents.service.ContentsService;
import com.tstecon.ocp.contents.vo.ContentsVO;
import com.tstecon.ocp.contents.vo.ListContentsVO;

@Controller("contentsController")
public class ContentsControllerImpl implements ContentsController {
	
	@Autowired
	private ContentsService contentsService;
	
	@Override
	@RequestMapping(value = { "/contents/contentsForm.do" }, method = { RequestMethod.GET })
	public ModelAndView contentsForm(@RequestParam("compet_id") int compet_id, HttpServletRequest request,
			HttpServletResponse reponse) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("compet_id", compet_id);
		return mav;
	}

	@Override
	@RequestMapping(value = { "/contents/listContents.do" }, method = { RequestMethod.GET })
	public ModelAndView listContents(@RequestParam("compet_id")int compet_id, HttpServletRequest request, HttpServletResponse reponse)
			throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		List<ListContentsVO> contentsList = contentsService.listContents(compet_id);
		mav.addObject("listContents", contentsList);
		return mav;
	}

}
