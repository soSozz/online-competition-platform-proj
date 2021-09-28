package com.tstecon.ocp.admin.categ.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.categ.vo.CategVO;
import com.tstecon.ocp.compet.vo.CompetVO;

public interface AdminCategService {
	//카테고리 리스트 가져오기
	public List<CategVO> CategAllList() throws DataAccessException;
	//조건없이 카테 이름만 가져오기
	public List<CategVO> categName() throws DataAccessException;
	// 맵을 통해 아이디 가져오기
	public int addCompet(Map<String, Object> addCompetMap) throws DataAccessException;
	//카테고리 삭제
	public void deleteCateg(String categ_name) throws DataAccessException;
	// 카테고리 이름을 통해 아이디 가져오기
	public int CategIdByName(String categ_name) throws DataAccessException;
	// 카테고리 아이디 + 1
	public int categPlusId() throws DataAccessException;
	//카테고리 추가
	public void addCateg(Map map) throws DataAccessException;
	
}
