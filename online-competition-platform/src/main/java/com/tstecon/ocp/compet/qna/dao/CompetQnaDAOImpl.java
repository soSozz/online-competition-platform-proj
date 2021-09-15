package com.tstecon.ocp.compet.qna.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tstecon.ocp.compet.qna.vo.CompetQnaVO;



@Repository("CompetQnaDAO")
public  class CompetQnaDAOImpl implements CompetQnaDAO{

	@Autowired
	private SqlSession sqlSession;
	

//문의 게시판 내용	
	@Override
	public List selectAllQnaList() throws DataAccessException {
		List<CompetQnaVO> qnaList = sqlSession.selectList("mappers.competQna.selectAllQnaList");
		return qnaList;
	}
	
	
	
	

}
