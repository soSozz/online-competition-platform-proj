package com.tstecon.ocp.compet.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tstecon.ocp.compet.vo.CompetFileVO;
import com.tstecon.ocp.compet.vo.CompetVO;
import com.tstecon.ocp.qna.vo.CompetQnaVO;

@Repository("competDAO")
public class CompetDAOImpl implements CompetDAO{

	@Autowired
	private SqlSession sqlSession;
	
//	대회안내 포스터
	@Override
	public List<CompetVO> selectCompetPoster(int compet_id) throws DataAccessException {
		List<CompetVO> competList = (ArrayList)sqlSession.selectList("mappers.compet.selectCompetPoster",compet_id);
		return competList;
	}
//	대회안내 내용
	@Override
	public List<CompetVO> selectCompetInfo(int compet_id) throws DataAccessException {
		List<CompetVO> competList = (ArrayList)sqlSession.selectList("mappers.compet.selectCompetInfo",compet_id);
		return competList;
	}
	
	@Override
	public CompetFileVO selectCompetSmallPoster(int compet_id) throws DataAccessException {
		CompetFileVO competFile = sqlSession.selectOne("mapper.notice.compet.selectSmallPoster",compet_id);
		return competFile;
	}
//문의 게시판 내용	
	@Override
	public List selectAllQnaList() throws DataAccessException {
		List<CompetQnaVO> qnaList = sqlSession.selectList("mappers.compet.selectAllQnaList");
		return qnaList;
	}
	
	

}
