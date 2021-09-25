package com.tstecon.ocp.admin.monitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.admin.monitor.dao.AdminMonitorDAO;
import com.tstecon.ocp.admin.monitor.vo.AdminCmtVO;


@Service("AdminMonitorService")
public class AdminMonitorServiceImpl implements AdminMonitorService {
	@Autowired
	private AdminMonitorDAO adminMonitorDAO;
	
//	@Override
//	public AdminMonitorVO Likes(HashMap LikesMap) throws Exception{
//		return adminMonitorDAO.Likes(LikesMap);
//	}
//	
//	@Override
//	public AdminMonitorVO Cmt(HashMap CmtMap) throws DataAccessException{
//		return Cmt(CmtMap);
//		
//		
//		
//}
	@Override
	public List<AdminCmtVO> adminCmtList() throws DataAccessException{
		List<AdminCmtVO> adminCmtList = adminMonitorDAO.selectAdminCmtList();
		
		
		return adminCmtList;
}
}
