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
	public CompetFileVO CompetSmallPoster(int compet_id) throws DataAccessException;
//문의 	
	public List<CompetQnaVO>qnalistArticles() throws Exception;
}
