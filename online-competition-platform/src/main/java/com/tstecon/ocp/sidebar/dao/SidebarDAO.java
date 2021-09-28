package com.tstecon.ocp.sidebar.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.sidebar.vo.SidebarVO;

public interface SidebarDAO {

	public List<SidebarVO> selectRankListByCompetId(int compet_id) throws DataAccessException;
}
