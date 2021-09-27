package com.tstecon.ocp.admin.categ.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.categ.vo.CategVO;
import com.tstecon.ocp.compet.vo.CompetVO;

public interface AdminCategDAO {

	public List<CategVO> selectCategAllList() throws DataAccessException;
	
	public List<CompetVO> selectCompetList() throws DataAccessException;
	//조건없이 카테고리 이름 가져오기
	public List<CategVO> selectCategName() throws DataAccessException;
	//맵을 통해 카테고리 아이디 가져오기
	public int selectCategIdByName(Map<String, Object> addCompetMap) throws DataAccessException;
	// 카테고리 삭제
	public void deleteCategByName(String categ_name) throws DataAccessException;
	//카테고리 이름을 통해 아이디 가져오기
	public int selectcategIdByName(String categ_name) throws DataAccessException;
}
