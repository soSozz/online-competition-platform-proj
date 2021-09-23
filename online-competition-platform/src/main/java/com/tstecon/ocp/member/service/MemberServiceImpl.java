package com.tstecon.ocp.member.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tstecon.ocp.member.dao.MemberDAO;
import com.tstecon.ocp.member.vo.AdminVO;
import com.tstecon.ocp.member.vo.MemberVO;

@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public MemberVO loginByMember(Map loginMap) throws Exception {
		return memberDAO.selectMemberByLogin(loginMap);
	}

	@Override
	public AdminVO loginByAdmin(Map loginMap) throws Exception {
		return memberDAO.selectAdminByLogin(loginMap);
	}

}
