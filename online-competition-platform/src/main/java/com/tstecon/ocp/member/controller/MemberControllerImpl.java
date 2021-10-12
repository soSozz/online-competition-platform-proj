package com.tstecon.ocp.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tstecon.ocp.common.base.BaseController;
import com.tstecon.ocp.member.service.MemberService;
import com.tstecon.ocp.member.vo.AdminVO;
import com.tstecon.ocp.member.vo.MemberVO;

@Controller("memberController")
@RequestMapping(value = "/member")
public class MemberControllerImpl extends BaseController implements MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;
	@Autowired
	private AdminVO adminVO;

	@Override
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public @ResponseBody String login(@RequestBody String login, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> loginMap = new Gson().fromJson(login, Map.class);

		memberVO = memberService.loginByMember(loginMap);
		adminVO = memberService.loginByAdmin(loginMap);

		HttpSession session = request.getSession();
		if (memberVO != null) { // member�� �α��� ���� ��
			session.setAttribute("loginStatus", "member");
			session.setAttribute("loginInfo", memberVO);
			return "true";
		} else if (adminVO != null) { // admin���� �α��� ���� ��
			session.setAttribute("loginStatus", "admin");
			session.setAttribute("loginInfo", adminVO);
			return "true";
		} else { // �α��� ���� ��
			return "false";
		}
	}

	@Override
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public ResponseEntity logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("loginStatus");
		session.removeAttribute("loginInfo");

		String message = "<script>";
		message += "alert('로그아웃 되었습니다');";
		message += "location.href='" + request.getContextPath() + "/main/main.do';";
		message += ("</script>");

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");

		ResponseEntity resEntity = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
}