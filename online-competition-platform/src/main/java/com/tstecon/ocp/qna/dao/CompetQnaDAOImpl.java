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
// 문의 로그인
	public CompetQnaVO quaLogin(CompetQnaVO competqnaVO) throws DataAccessException {
		CompetQnaVO vo = sqlSession.selectOne("mappers.competQna.qnaLogin", competqnaVO); // vo가 들어가는 이유는 vo에 담겨있는 login
																							// 값을 쿼리문에 보내줘야 해서?
		return vo;
	}
//글 쓰기 추가
	public int insertNewArticle(Map articleMap) throws DataAccessException {
		int articleNO = selectNewArticleNO();
		articleMap.put("articleNO", articleNO);
		System.out.println("articleNO :" + articleNO);
		sqlSession.insert("mappers.competQna.insertNewQna", articleMap);
		return articleNO;
	}
//글 쓰기 추가, 글 번호 가져오기
	private int selectNewArticleNO() throws DataAccessException {
		return sqlSession.selectOne("mappers.competQna.selectNewQnaNO");
	}
//상세 페이지 보기	
	public CompetQnaVO selectQnaArticle(int articleNO) throws DataAccessException {
		return sqlSession.selectOne("mappers.competQna.selectQnaArticle", articleNO);
	}
//문의 글 수정		
	public void updateArticle(Map articleMap) throws DataAccessException{
		System.out.println( "수정 데이터1 :" + articleMap );
		sqlSession.update("mappers.competQna.updateArticle", articleMap);
		
	}
//문의 글 삭제		
	public void deleteArticle(int articleNO) throws DataAccessException{
		sqlSession.delete("mappers.competQna.deleteArticle", articleNO);
	}

}
