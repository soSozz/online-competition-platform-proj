package com.tstecon.ocp.compet.qna.service;

import java.util.List;
import java.util.Map;


import com.tstecon.ocp.compet.qna.vo.CompetQnaVO;





public interface CompetQnaService {

//문의 	
	public List<CompetQnaVO>qnalistArticles() throws Exception;
//문의 로그인
	 public CompetQnaVO login(CompetQnaVO competqnaVO) throws Exception;
//문의 글 번호 추가	 
	 public int addNewArticle(Map articleMap) throws Exception;
//문의 상세글	
	 public CompetQnaVO viewArticle(int articleNO) throws Exception;
	 
	 
}
