package com.tstecon.ocp.admin.monitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.admin.monitor.dao.AdminMonitorDAO;
import com.tstecon.ocp.admin.monitor.vo.AdminCmtVO;
import com.tstecon.ocp.admin.monitor.vo.AdminMonitorVO;


@Service("AdminMonitorService")
public class AdminMonitorServiceImpl implements AdminMonitorService {
	@Autowired
	private AdminMonitorDAO adminMonitorDAO;
	
	@Override
	public List<AdminMonitorVO> adminLikeList() throws DataAccessException{
		List<AdminMonitorVO> adminLikeList = adminMonitorDAO.selectAdminMoniterLikeList();
		
		
		return adminLikeList;
}

	@Override
	public List<AdminCmtVO> adminCmtList() throws DataAccessException{
		List<AdminCmtVO> adminCmtList = adminMonitorDAO.selectAdminCmtList();
		
		
		return adminCmtList;
}
}
