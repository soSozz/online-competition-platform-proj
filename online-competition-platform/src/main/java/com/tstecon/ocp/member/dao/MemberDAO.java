package com.tstecon.ocp.member.dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.member.vo.AdminVO;
import com.tstecon.ocp.member.vo.MemberVO;

public interface MemberDAO {
	public MemberVO selectMemberByLogin(Map loginMap) throws DataAccessException;

	public AdminVO selectAdminByLogin(Map loginMap) throws DataAccessException;

	public void insertNewMember(MemberVO memberVO) throws DataAccessException;

	public String selectOverlappedID(String id) throws DataAccessException;
}
