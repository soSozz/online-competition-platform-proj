//package com.tstecon.ocp.member.controller;
//
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.tstecon.ocp.common.base.BaseController;
//import com.tstecon.ocp.member.service.MemberService;
//import com.tstecon.ocp.member.vo.MemberVO;
//
//@Controller("memberController")
//@RequestMapping(value = "/member")
//public class MemberControllerImpl extends BaseController implements MemberController {
//	@Autowired
//	private MemberService memberService;
//	@Autowired
//	private MemberVO memberVO;
//
//	@Override
//	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
//	public ModelAndView login(@RequestParam Map<String, String> loginMap, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		ModelAndView mav = new ModelAndView();
//		memberVO = memberService.login(loginMap);
//
//		if (memberVO != null && memberVO.getMem_id() != null) {
//			HttpSession session = request.getSession();
//			session = request.getSession();
//			session.setAttribute("isLogOn", true);
//			session.setAttribute("memberInfo", memberVO);
//
//		} else {
//			String message = "";
//			mav.addObject("message", message);
//			mav.setViewName("/member/loginForm");
//		}
//		return mav;
//	}
//
//	@Override
//	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
//	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		ModelAndView mav = new ModelAndView();
//		HttpSession session = request.getSession();
//		session.setAttribute("isLogOn", false);
//		session.removeAttribute("memberInfo");
//		mav.setViewName("redirect:/main/main.do");
//		return mav;
//	}
//}