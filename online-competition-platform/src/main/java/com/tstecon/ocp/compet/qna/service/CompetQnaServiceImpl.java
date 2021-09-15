package com.tstecon.ocp.compet.qna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.compet.qna.dao.CompetQnaDAO;
import com.tstecon.ocp.compet.qna.vo.CompetQnaVO;



@Service("CompetQnaService")
public class CompetQnaServiceImpl implements CompetQnaService{
	@Autowired
	private CompetQnaDAO competQnaDAO;



//문의 게시판
	@Override
	public List<CompetQnaVO> qnalistArticles() throws Exception {
		List<CompetQnaVO> qnaList = competQnaDAO.selectAllQnaList();
		return qnaList;
	}
	


}
