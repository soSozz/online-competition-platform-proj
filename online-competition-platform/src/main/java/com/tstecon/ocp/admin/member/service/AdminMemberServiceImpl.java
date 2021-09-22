package com.tstecon.ocp.admin.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tstecon.ocp.admin.member.dao.AdminMemberDAO;
import com.tstecon.ocp.member.vo.MemberVO;

@Service("adminMemberService")
@Transactional(propagation = Propagation.REQUIRED)
public class AdminMemberServiceImpl implements AdminMemberService {
	@Autowired
	private AdminMemberDAO adminMemberDAO;

	@Override
	public List<MemberVO> listMembers() throws DataAccessException {
		//adminMemberDAO 불러서 회원 리스트
		List<MemberVO> membersList = adminMemberDAO.selectAllMemberList();
		return membersList;
	}

}

