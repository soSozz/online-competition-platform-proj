package com.tstecon.ocp.compet.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;


import com.tstecon.ocp.compet.vo.CompetFileVO;
import com.tstecon.ocp.compet.vo.CompetVO;

@Service
public interface CompetService {
//	대회 안내
	public Map<String,List<CompetVO>> CompetInfo(int compet_id) throws DataAccessException;
	public Map<String,List<CompetFileVO>> CompetPoster(int compet_id) throws DataAccessException;
	// 대회 이름 리스트 가져오기

	// 카테고리 아이디를 통해 대회 리스트 가져오기
	public List<CompetVO> competListById(int i) throws Exception;

	// 카테고리 아이디를 통해 대회 리스트 3개 가져오기
	public List<CompetVO> competListByCategIdToThree(int i) throws Exception;

	// 종료된 대회 가져오기
	public List<CompetVO> finishCompetList(int i) throws Exception;

	// 카테고리 아이디를 통해 대회 이름 가져오기
	public List<CompetVO> competListByName(int i) throws Exception;

	List<CompetFileVO> CompetSmallPoster(int compet_id) throws DataAccessException;

	public List<CompetVO> CompetName() throws DataAccessException;

	// admin 대회 추가하기
	public void addCompet(Map<String, Object> competMap) throws DataAccessException;
	
	// 대회 추가 시 대회 아이디 값 증가
	public int addCompetId() throws DataAccessException;
	
	//대회 종료하기
	public int competFinish(String compet_name) throws DataAccessException;
	
	// 종료된 대회 삭제하기
	public int competDelete(String compet_name) throws DataAccessException;
	
	// 카테고리 아이디를 통해 대회 리스트 가져오기
	public List<CompetVO> competListByCategId(int categ_id) throws DataAccessException;

}

