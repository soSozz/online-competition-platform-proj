package com.tstecon.ocp.notice.compet.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.tstecon.ocp.compet.service.CompetService;
import com.tstecon.ocp.compet.vo.CompetFileVO;
import com.tstecon.ocp.member.vo.AdminVO;
import com.tstecon.ocp.notice.compet.service.NoticeCompetService;
import com.tstecon.ocp.notice.compet.vo.NoticeCompetVO;


@Controller("NoticeCompetController")
public class NoticeCompetControllerImpl implements NoticeCompetController {

	@Autowired
	private NoticeCompetService NoticeCompetService;
	@Autowired
	private CompetService CompetService;
	
	@Autowired
	private NoticeCompetVO NoticeCompetVO;
	
	@Autowired
	private AdminVO adminVO;

	@Override
	@RequestMapping(value = "/notice/compet/listCompetNotices.do", method = RequestMethod.GET)
	public ModelAndView listCompetNotices(@RequestParam("compet_id") int compet_id, HttpServletRequest request,
			HttpServletResponse response) {

		String viewName = (String) request.getAttribute("viewName");

		// NoticeCompetService: 공지사항 리스트 가져오기
		// CompetService: 작은포스터 가져오기

		List<NoticeCompetVO> noticeCompetList = NoticeCompetService.listCompetNotices(compet_id);
		
		CompetFileVO smallPoster = NoticeCompetService.CompetSmallPoster(compet_id);
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("compet_id", compet_id);
		mav.addObject("noticeCompetList", noticeCompetList);
		mav.addObject("smallPoster", smallPoster);
		return mav;
	}
	
	@RequestMapping(value = "/notice/compet/noticeCompetDetail.do", method = RequestMethod.GET)
	public ModelAndView noticeCompetDetail(@RequestParam("compet_notice_id") int compet_notice_id, HttpServletRequest request,
			HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");
		NoticeCompetService.updateCompetNoticesView(compet_notice_id);
		List<NoticeCompetVO> noticeCompetDetail = NoticeCompetService.noticeCompetDetail(compet_notice_id);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("noticeCompetDetail", noticeCompetDetail);
		return mav;
	}
	
	
	@RequestMapping(value = "/notice/compet/modNoticeCompet.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity modNoticeCompet(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> competNoticeMap = new HashMap<String, Object>();
		Enumeration enu = multipartRequest.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = multipartRequest.getParameter(name);
			competNoticeMap.put(name, value);
		}

		String compet_notice_id = (String)competNoticeMap.get("compet_notice_id");
		System.out.println("compet_notice_id-------------------" + compet_notice_id);
		
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			NoticeCompetService.modNoticeCompet(competNoticeMap);
			message = "<script>";
			message += " alert('글을 수정했습니다.');";
			message += " location.href='" + multipartRequest.getContextPath() + "/notice/compet/noticeCompetDetail.do?compet_notice_id="
					+ compet_notice_id + "';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			message = "<script>";
			message += " alert('오류가 발생했습니다.다시 수정해주세요');";
			message += " location.href='" + multipartRequest.getContextPath() + "/notice/compet/noticeCompetDetail.do?compet_notice_id="
					+ compet_notice_id + "';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}
		return resEnt;
	}
	
	
	  @RequestMapping(value="/notice/compet/removeNoticeCompet.do" ,method = RequestMethod.POST)
	  @ResponseBody
		public ResponseEntity  removeNoticeCompet(@RequestParam("compet_notice_id") int compet_notice_id, @RequestParam("compet_id") int compet_id,  HttpServletRequest request, HttpServletResponse response) throws Exception{
		  response.setContentType("text/html; charset=UTF-8");
		  ModelAndView mav = new ModelAndView();
		  String message;
		  ResponseEntity resEnt=null;
		  HttpHeaders responseHeaders = new HttpHeaders();
		  responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		  
		  mav.addObject("compet_id", compet_id);
	
		  
		  
		  
		  try {
			  NoticeCompetService.removeNoticeCompet(compet_notice_id);
			  message = "<script>";
			  message += " alert('글을 삭제했습니다.');";
			  message += " location.href='"+request.getContextPath()+"/notice/compet/listCompetNotices.do?compet_id="+ compet_id + " '; ";
			  message +=" </script>";
			  resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		  }catch(Exception e) {
			  message = "<script>";
			  message += " alert('작업중 오류가 발생했습니다.다시 시도해 주세요.');";

//			  message += " location.href='"+request.getContextPath()+"/notice/compet/listCompetNotices.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}
	  
	  @RequestMapping(value = "/notice/compet/noticeCompetForm.do", method = RequestMethod.GET)
		private ModelAndView form(
				HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			String viewName = (String) request.getAttribute("viewName");
			ModelAndView mav = new ModelAndView();

			mav.setViewName(viewName);
			
			
			String compet_id = request.getParameter("compet_id");
			
			mav.addObject("compet_id", compet_id);
			
			return mav;
		}
	  
	  @RequestMapping(value = "/notice/compet/addNoticeCompet.do", method = RequestMethod.POST)
		@ResponseBody
		public ResponseEntity addNewNoticeCompet(HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			request.setCharacterEncoding("utf-8");
			Map<String, Object> addNoticeCompetMap = new HashMap<String, Object>();
			Enumeration enu = request.getParameterNames();
			while (enu.hasMoreElements()) {
				String name = (String) enu.nextElement();
				String value = request.getParameter(name);
				addNoticeCompetMap.put(name, value);
			}


		     HttpSession session = request.getSession();
		 	  String action = (String) session.getAttribute("loginStatus");
		     if(action == "admin" ) {
		    	 adminVO =(AdminVO) session.getAttribute("loginInfo");
		     }
		     
		      
			 
			 String admin_id = adminVO.getAdmin_id();
			
			 
			 addNoticeCompetMap.put("admin_id", admin_id);
		     
		     String compet_id = request.getParameter("compet_id");
		     	
		     


			String message;
			ResponseEntity resEnt = null;
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "text/html; charset=utf-8");
			try {
				int noticeCompetDetail = NoticeCompetService.addNewNoticeCompet(addNoticeCompetMap);
				message = "<script>";
				message += " alert('새글을 추가했습니다.');";
				message += " location.href=' " + request.getContextPath() + "/notice/compet/listCompetNotices.do?compet_id="+ compet_id + " '; ";
				message += "</script>";
				resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			} catch (Exception e) {
				message = "<script>";
				message += " alert('오류가 발생했습니다. 다시 시도해 주세요');');";
				message += " location.href='" + request.getContextPath() + "/notice/compet/*Form.do';";
				message += "</script>";
				resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
				e.printStackTrace();
			}

			return resEnt;

		}
	
}

