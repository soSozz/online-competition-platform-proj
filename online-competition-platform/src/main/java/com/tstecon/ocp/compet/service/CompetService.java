package com.tstecon.ocp.compet.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;


import com.tstecon.ocp.compet.vo.CompetFileVO;
import com.tstecon.ocp.compet.vo.CompetVO;
import com.tstecon.ocp.qna.vo.CompetQnaVO;

@Service
public interface CompetService {
//	대회 안내


	public Map<String,List<CompetVO>> CompetInfo(int compet_id) throws DataAccessException;
	public Map<String,List<CompetFileVO>> CompetPoster(int compet_id) throws DataAccessException;




	// 대회 이름 리스트 가져오기
	public List<CompetVO> competListById(int i) throws Exception;

	List<CompetFileVO> CompetSmallPoster(int compet_id) throws DataAccessException;

	public List<CompetVO> CompetName() throws DataAccessException;
}

