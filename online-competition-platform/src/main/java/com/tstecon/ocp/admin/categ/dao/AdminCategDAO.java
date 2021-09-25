package com.tstecon.ocp.admin.categ.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.categ.vo.CategVO;
import com.tstecon.ocp.compet.vo.CompetVO;

public interface AdminCategDAO {

	public List<CategVO> selectCategAllList() throws DataAccessException;

	public List<CompetVO> selectCompetList() throws DataAccessException;

	public List<CategVO> selectCategName() throws DataAccessException;

	public int selectCategIdByName(Map<String, Object> addCompetMap) throws DataAccessException;
}
