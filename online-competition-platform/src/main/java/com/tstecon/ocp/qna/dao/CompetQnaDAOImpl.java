package com.tstecon.ocp.qna.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tstecon.ocp.qna.vo.CompetQnaVO;

@Repository("CompetQnaDAO")
public class CompetQnaDAOImpl implements CompetQnaDAO {

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	private CompetQnaVO competqnaVO;

//문의 게시판 내용	
	@Override
	public List selectAllQnaList() throws DataAccessException {
		List<CompetQnaVO> qnaList = sqlSession.selectList("mappers.competQna.selectAllQnaList");
		return qnaList;
	}

	public CompetQnaVO quaLogin(CompetQnaVO competqnaVO) throws DataAccessException {
		CompetQnaVO vo = sqlSession.selectOne("mappers.competQna.qnaLogin", competqnaVO); // vo가 들어가는 이유는 vo에 담겨있는 login
																							// 값을 쿼리문에 보내줘야 해서?
		return vo;
	}

	public int insertNewArticle(Map articleMap) throws DataAccessException {
		int articleNO = selectNewArticleNO();
		articleMap.put("articleNO", articleNO);
		sqlSession.insert("mappers.competQna.insertNewQna", articleMap);
		return articleNO;
	}

	private int selectNewArticleNO() throws DataAccessException {
		return sqlSession.selectOne("mappers.competQna.selectNewQnaNO");
	}
	
	public CompetQnaVO selectQnaArticle(int articleNO) throws DataAccessException {
		return sqlSession.selectOne("mappers.competQna.selectQnaArticle", articleNO);
	}
	
	public void updateArticle(Map articleMap) throws DataAccessException{
		System.out.println( "수정 데이터1 :" + articleMap );
		sqlSession.update("mappers.competQna.updateArticle", articleMap);
		
	}
	public void deleteArticle(int articleNO) throws DataAccessException{
		sqlSession.delete("mapper.board.deleteArticle", articleNO);
	}

}
