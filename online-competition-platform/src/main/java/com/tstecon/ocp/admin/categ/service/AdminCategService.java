package com.tstecon.ocp.admin.categ.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.categ.vo.CategVO;
import com.tstecon.ocp.compet.vo.CompetVO;

public interface AdminCategService {

	public List<CategVO> CategAllList() throws DataAccessException;
	public List<CategVO> CategName() throws DataAccessException;
}
