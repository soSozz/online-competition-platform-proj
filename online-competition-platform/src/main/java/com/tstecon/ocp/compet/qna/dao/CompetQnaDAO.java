package com.tstecon.ocp.compet.qna.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.compet.qna.vo.CompetQnaVO;




public interface CompetQnaDAO {

// 문의 게시판 내용
	public List selectAllQnaList() throws DataAccessException;
	public int insertNewArticle(Map articleMap) throws DataAccessException;
	public CompetQnaVO quaLogin(CompetQnaVO competqnaVO) throws DataAccessException;
}
