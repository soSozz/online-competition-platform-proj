package com.tstecon.ocp.admin.monitor.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.admin.monitor.vo.AdminCmtVO;
import com.tstecon.ocp.admin.monitor.vo.AdminMonitorVO;


public interface AdminMonitorService {
	public List<AdminCmtVO> adminCmtList() throws DataAccessException;
	public List<AdminMonitorVO> adminLikeList(Map dateMap) throws DataAccessException;
	public List<AdminMonitorVO> adminCmtsList(Map dateMaps) throws DataAccessException;
}
