package com.tstecon.ocp.qna.controller;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tstecon.ocp.member.vo.AdminVO;
import com.tstecon.ocp.member.vo.MemberVO;
import com.tstecon.ocp.qna.dao.CompetQnaDAO;
import com.tstecon.ocp.qna.service.CompetQnaService;
import com.tstecon.ocp.qna.vo.CompetQnaVO;

@Controller("CompetQnaController")
public class CompetQnaControllerImpl implements CompetQnaController {
	@Autowired
	private CompetQnaService competQnaService;

	@Autowired
	private CompetQnaDAO competQnaDAO;

	@Autowired
	private CompetQnaVO competqnaVO;
	
	@Autowired
	private MemberVO memberVO;
	
	@Autowired
	private AdminVO adminVO;

//문의 페이지	
	@Override
	@RequestMapping(value = "/qna/qna.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView Compet_qna_list(@RequestParam("compet_id") int compet_id,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List qnaList = competQnaService.qnalistArticles(compet_id);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("qnaList", qnaList);
		mav.addObject("compet_id", compet_id);
		return mav;

	}

//문의 페이지 로그인
	@Override
	@RequestMapping(value = "/qna/login.do", method = RequestMethod.POST)
	public ModelAndView Compet_qna_login(@ModelAttribute("member") CompetQnaVO member, RedirectAttributes rAttr,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		competqnaVO = competQnaService.login(member);
		if (competqnaVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", competqnaVO);
			session.setAttribute("isLogOn", true);
			System.out.println("isLogOn : " + true);
			String action = (String) session.getAttribute("action");
			session.removeAttribute("action");

			if (action != null) {
				mav.setViewName("redirect:" + action); // 뷰 이름
			} else {
				mav.setViewName("redirect:/qna/qna.do");
			}

		} else {
			rAttr.addAttribute("result", "loginFailed");
			mav.setViewName("redirect:/login.do"); 
		}

		return mav; 
	}

//문의 페이지 로그아웃	
	@Override
	@RequestMapping(value = "/qna/logout.do", method = RequestMethod.GET)
	public ModelAndView Compet_qna_logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		System.out.println("isLogOn2 : " + true);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/main/main.do"); 
		return mav;
	}

//문의 페이지 폼 이동
	@RequestMapping(value = "/qna/*Form.do", method = RequestMethod.GET)
	private ModelAndView form(@RequestParam(value = "result", required = false) String result,
			@RequestParam(value = "parentNO", required = false) int parentNO, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		System.out.println("parentNO 111 :" + parentNO);
		HttpSession session = request.getSession();
		session.setAttribute("parentNO", parentNO);
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		mav.setViewName(viewName);
		
		
		String compet_id = (String) request.getParameter("compet_id");
		System.out.println("compet_id 111: " + compet_id );
		mav.addObject("compet_id", compet_id);
		
		return mav;
	}

//문의 글쓰기 창
	@Override
	@RequestMapping(value = "/qna/addNewArticle.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addNewArticle(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> articleMap = new HashMap<String, Object>();
		Enumeration enu = multipartRequest.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = multipartRequest.getParameter(name);
			articleMap.put(name, value);
		}

	     HttpSession session = multipartRequest.getSession();
	 	  String action = (String) session.getAttribute("loginStatus");
	     if(action == "member" ) {
	      memberVO =(MemberVO) session.getAttribute("loginInfo");
	     }else {
	    	 adminVO =(AdminVO) session.getAttribute("loginInfo");	
	     }
	     
	      
		 String mem_id =  memberVO.getMem_id();
		 String admin_id = adminVO.getAdmin_id();
         articleMap.put("parent_id", 0);
	     articleMap.put("mem_id", mem_id);
	     articleMap.put("admin_id", admin_id);
	     
	     String compet_id = multipartRequest.getParameter("compet_id");
	     	
	     

		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			int articleNO = competQnaService.addNewArticle(articleMap);
			message = "<script>";
			message += " alert('새글을 추가했습니다.');";
			message += " location.href=' " + multipartRequest.getContextPath() + "/qna/qna.do?compet_id="+ compet_id + " '; ";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			message = "<script>";
			message += " alert('오류가 발생했습니다. 다시 시도해 주세요');');";
			message += " location.href='" + multipartRequest.getContextPath() + "/qna/*Form.do';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}

		return resEnt;

	}
	
	//문의 답변 글 쓰기 추가	 
	@Override
	@RequestMapping(value = "/qna/replyAddNewArticle.do", method = RequestMethod.POST)
	  public ResponseEntity replyAddNewArticle(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
				throws Exception{
		Map<String, Object> articleMap = new HashMap<String, Object>(); 
		Enumeration enu = multipartRequest.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = multipartRequest.getParameter(name);
			articleMap.put(name, value);
		}

	     HttpSession session = multipartRequest.getSession();			
	               adminVO = (AdminVO) session.getAttribute("loginInfo");					
		 String admin_id =  adminVO.getAdmin_id();
		 int parentNO =  (Integer) session.getAttribute("parentNO");
		 System.out.println("parentNO 22 :" + parentNO );
		 articleMap.put("parentNO", parentNO);
         articleMap.put("parent_id", parentNO);
	     articleMap.put("admin_id", admin_id);
	     
	     String compet_id = multipartRequest.getParameter("compet_id");
	     	
	     

		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			int articleNO = competQnaService.replyAddNewArticle(articleMap);
			message = "<script>";
			message += " alert('답변을 추가했습니다.');";
			message += " location.href=' " + multipartRequest.getContextPath() + "/qna/qna.do?compet_id="+ compet_id + " '; ";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			message = "<script>";
			message += " alert('오류가 발생했습니다. 다시 시도해 주세요');');";
			message += " location.href='" + multipartRequest.getContextPath() + "/qna/*Form.do';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}

		return resEnt;
		  
				}			
//문의 상세창 보기
	@RequestMapping(value = "/qna/qnaDetail.do", method = RequestMethod.GET)
	public ModelAndView viewArticle(@RequestParam("articleNO") int articleNO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		competqnaVO = competQnaService.viewArticle(articleNO);
		System.out.println("articleNO : "+  articleNO );
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("article", competqnaVO);
		return mav;
	}

//문의 글 수정
	@RequestMapping(value="/qna/modArticle.do" ,method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity modArticle(MultipartHttpServletRequest multipartRequest,  HttpServletResponse response) throws Exception{
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String,Object> articleMap = new HashMap<String, Object>();
		Enumeration enu=multipartRequest.getParameterNames();
		while(enu.hasMoreElements()){
			String name=(String)enu.nextElement();
			String value=multipartRequest.getParameter(name);
			articleMap.put(name,value);
		}
		
		String articleNO=(String)articleMap.get("articleNO");
		System.out.println( "articleNO 데이터1 :" + articleNO );
		String message;
		ResponseEntity resEnt=null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			   competQnaService.modArticle(articleMap);
			   message = "<script>";
			   message += " alert('글을 수정했습니다.');";
			   message += " location.href='"+multipartRequest.getContextPath()+"/qna/qnaDetail.do?articleNO="+articleNO+"';";
			   message +=" </script>";
		       resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e){
			  message = "<script>";
			  message += " alert('오류가 발생했습니다.다시 수정해주세요');";
			  message += " location.href='"+multipartRequest.getContextPath()+"/qna/qnaDetail.do?articleNO="+articleNO+"';";
			  message +=" </script>";
		      resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);		
		}
		return  resEnt;
	}

//문의  글 삭제	
	  @Override
	  @RequestMapping(value="/qna/removeArticle.do" ,method = RequestMethod.POST)
	  @ResponseBody
		public ResponseEntity  removeArticle(@RequestParam("articleNO") int articleNO, @RequestParam("compet_id") int compet_id,  HttpServletRequest request, HttpServletResponse response) throws Exception{
		  response.setContentType("text/html; charset=UTF-8");
		  ModelAndView mav = new ModelAndView();
		  String message;
		  ResponseEntity resEnt=null;
		  HttpHeaders responseHeaders = new HttpHeaders();
		  responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		  
		  mav.addObject("compet_id", compet_id);
	
		  
		  
		  
		  try {
			  competQnaService.removeArticle(articleNO);
			  message = "<script>";
			  message += " alert('글을 삭제했습니다.');";
			  message += " location.href='"+request.getContextPath()+"/qna/qna.do?compet_id="+ compet_id + " '; ";
			  message +=" </script>";
			  resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		  }catch(Exception e) {
			  message = "<script>";
			  message += " alert('작업중 오류가 발생했습니다.다시 시도해 주세요.');";
//			  message += " location.href='"+request.getContextPath()+"/qna/qna.do';";
			  message +=" </script>";
			  resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			  e.printStackTrace();
		  }
		  return resEnt;
		}



}
