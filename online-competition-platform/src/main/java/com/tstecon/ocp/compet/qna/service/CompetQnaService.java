package com.tstecon.ocp.compet.qna.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.compet.qna.vo.CompetQnaVO;
import com.tstecon.ocp.compet.vo.CompetFileVO;
import com.tstecon.ocp.compet.vo.CompetVO;


@Service
public interface CompetQnaService {

//문의 	
	public List<CompetQnaVO>qnalistArticles() throws Exception;
//문의 글쓰기창
	 public CompetQnaVO login(CompetQnaVO competqnaVO) throws Exception;
}
