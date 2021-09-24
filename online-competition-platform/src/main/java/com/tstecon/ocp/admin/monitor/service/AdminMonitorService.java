package com.tstecon.ocp.admin.monitor.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.admin.monitor.vo.AdminCmtVO;
import com.tstecon.ocp.admin.monitor.vo.AdminMonitorVO;


public interface AdminMonitorService {
//	public AdminMonitorVO Likes(HashMap LikesMap) throws Exception;
//	public AdminMonitorVO Cmt(HashMap CmtMap) throws Exception;
	public List<AdminCmtVO> adminCmtList() throws DataAccessException;
}
