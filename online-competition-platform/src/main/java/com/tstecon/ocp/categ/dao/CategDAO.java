package com.tstecon.ocp.categ.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.categ.vo.CategVO;

public interface CategDAO {

	public List<CategVO> selectCategList() throws DataAccessException;

}
