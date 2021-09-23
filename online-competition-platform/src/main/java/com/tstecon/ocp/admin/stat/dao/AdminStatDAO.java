package com.tstecon.ocp.admin.stat.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.admin.stat.vo.AdminStatVO;


public interface AdminStatDAO {
	public List<AdminStatVO> selectAdminStatContentsList() throws DataAccessException;
	
	public List<AdminStatVO> selectAdminStatLikesList() throws DataAccessException;
	
	public List<AdminStatVO> selectAdminStatCmtList() throws DataAccessException;
	
	public List<AdminStatVO> selectAdminStatViewList() throws DataAccessException;
}
