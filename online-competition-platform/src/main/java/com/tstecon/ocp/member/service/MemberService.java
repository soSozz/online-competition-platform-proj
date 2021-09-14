package com.tstecon.ocp.member.service;

import java.util.Map;

import com.tstecon.ocp.member.vo.MemberVO;

public interface MemberService {
	public MemberVO login(Map<String, String> loginMap) throws Exception;
}
