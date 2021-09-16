package com.tstecon.ocp.admin.stat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.admin.stat.dao.AdminStatDAO;
import com.tstecon.ocp.admin.stat.vo.AdminStatVO;
import com.tstecon.ocp.notice.compet.dao.NoticeCompetDAO;
import com.tstecon.ocp.notice.compet.service.NoticeCompetService;
import com.tstecon.ocp.notice.compet.vo.NoticeCompetVO;

@Service("AdminStatService")
public class AdminStatServiceImpl implements AdminStatService {
	@Autowired
	private AdminStatDAO adminStatDAO;
	
	@Override
	public List<AdminStatVO> adminContentsList() throws DataAccessException{
		List<AdminStatVO> adminContentsList = adminStatDAO.selectAdminStatContentsList();
		
		
		return adminContentsList;
}
	
	@Override
	public List<AdminStatVO> adminLikesList() throws DataAccessException{
		List<AdminStatVO> adminLikesList = adminStatDAO.selectAdminStatLikesList();
		
		
		return adminLikesList;
}
	
	@Override
	public List<AdminStatVO> adminCmtList() throws DataAccessException{
		List<AdminStatVO> adminCmtList = adminStatDAO.selectAdminStatCmtList();
		
		
		return adminCmtList;
}
	@Override
	public List<AdminStatVO> adminViewList() throws DataAccessException{
		List<AdminStatVO> adminViewList = adminStatDAO.selectAdminStatViewList();
		
		
		return adminViewList;
}
	
}
