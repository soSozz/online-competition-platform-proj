package com.tstecon.ocp.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public interface MemberController {
	public @ResponseBody String login(@RequestBody String login, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	public ResponseEntity logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
