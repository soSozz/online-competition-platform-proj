package com.tstecon.ocp.admin.categ.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.categ.vo.CategVO;
import com.tstecon.ocp.compet.vo.CompetVO;

public interface AdminCategService {

	public Map<String,List<CategVO>> Categlist() throws DataAccessException;

	public Map<String,List<CompetVO>> Competlist() throws DataAccessException;

}
