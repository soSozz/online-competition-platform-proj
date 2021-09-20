package com.tstecon.ocp.member.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tstecon.ocp.member.vo.AdminVO;
import com.tstecon.ocp.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	// 회원 아이디로 로그인
	@Override
	public MemberVO selectMemberByLogin(Map loginMap) throws DataAccessException {
		return (MemberVO) sqlSession.selectOne("mappers.member.selectMemberByLogin", loginMap);
	}

	// 관리자 아이디로 로그인
	@Override
	public AdminVO selectAdminByLogin(Map loginMap) throws DataAccessException {
		return (AdminVO) sqlSession.selectOne("mappers.member.selectAdminByLogin", loginMap);
	}

	@Override
	public void insertNewMember(MemberVO memberVO) throws DataAccessException {
		sqlSession.insert("mapper.member.insertNewMember", memberVO);
	}

	@Override
	public String selectOverlappedID(String id) throws DataAccessException {
		String result = sqlSession.selectOne("mapper.member.selectOverlappedID", id);
		return result;
	}

}
