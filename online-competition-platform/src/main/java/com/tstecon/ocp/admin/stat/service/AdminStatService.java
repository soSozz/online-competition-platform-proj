package com.tstecon.ocp.admin.stat.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.admin.stat.vo.AdminStatVO;
import com.tstecon.ocp.notice.compet.vo.NoticeCompetVO;

public interface AdminStatService {
	public List<AdminStatVO> adminContentsList() throws DataAccessException;
	public List<AdminStatVO> adminLikesList() throws DataAccessException;
	public List<AdminStatVO> adminCmtList() throws DataAccessException;
	public List<AdminStatVO> adminViewList() throws DataAccessException;
}
