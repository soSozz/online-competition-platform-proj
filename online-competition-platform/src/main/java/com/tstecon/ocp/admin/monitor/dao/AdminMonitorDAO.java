package com.tstecon.ocp.admin.monitor.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.admin.monitor.vo.AdminCmtVO;
import com.tstecon.ocp.admin.monitor.vo.AdminMonitorVO;
import com.tstecon.ocp.admin.stat.vo.AdminStatVO;


public interface AdminMonitorDAO {
	public List<AdminCmtVO> selectAdminCmtList() throws DataAccessException;
	public List<AdminMonitorVO> selectAdminMoniterLikeList(Map dateMap) throws DataAccessException;
	public List<AdminMonitorVO> selectAdminMoniterCmtList(Map dateMaps) throws DataAccessException;
}
