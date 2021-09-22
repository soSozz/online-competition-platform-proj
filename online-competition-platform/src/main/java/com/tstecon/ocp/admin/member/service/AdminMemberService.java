package com.tstecon.ocp.admin.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.member.vo.MemberVO;

public interface AdminMemberService {
	public List<MemberVO> listMembers() throws DataAccessException;

}
