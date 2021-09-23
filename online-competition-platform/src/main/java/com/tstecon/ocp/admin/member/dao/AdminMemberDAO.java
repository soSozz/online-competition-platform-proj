package com.tstecon.ocp.admin.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.member.vo.MemberVO;

public interface AdminMemberDAO {
	public List<MemberVO> selectAllMemberList() throws DataAccessException;
}
