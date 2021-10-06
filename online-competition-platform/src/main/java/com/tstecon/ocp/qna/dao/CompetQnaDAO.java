package com.tstecon.ocp.qna.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.qna.vo.CompetQnaVO;

public interface CompetQnaDAO {

// 문의 게시판 내용
	public List selectAllQnaList(int compet_id) throws DataAccessException;

	public int insertNewArticle(Map articleMap) throws DataAccessException;

	public CompetQnaVO selectQnaArticle(int articleNO) throws DataAccessException;
	
	public void updateArticle(Map articleMap) throws DataAccessException;
	
	public void deleteArticle(int articleNO) throws DataAccessException;
	
	public int insertReplyNewArticle(Map articleMap) throws DataAccessException;

	public void updateQnaView(int articleNO) throws DataAccessException;
	
}
