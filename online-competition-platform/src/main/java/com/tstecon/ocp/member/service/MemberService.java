package com.tstecon.ocp.member.service;

import java.util.Map;

import com.tstecon.ocp.member.vo.AdminVO;
import com.tstecon.ocp.member.vo.MemberVO;

public interface MemberService {
	public MemberVO loginByMember(Map<String, String> loginMap) throws Exception;

	public AdminVO loginByAdmin(Map<String, String> loginMap) throws Exception;
}
