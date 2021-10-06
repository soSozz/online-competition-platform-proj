package com.tstecon.ocp.contents.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.contents.vo.ContentsFileVO;
import com.tstecon.ocp.contents.vo.ContentsVO;
import com.tstecon.ocp.contents.vo.ListContentsVO;

public interface ContentsDAO {
	public int selectNewContentsFileId() throws DataAccessException;

	public void insertNewContentsFile(ContentsFileVO contentsFileVO) throws DataAccessException;

	public List<ListContentsVO> listContents(int compet_id) throws DataAccessException;

	public int insertNewContents(ContentsVO contentsVO) throws DataAccessException;

	public int selectNewContentsId() throws DataAccessException;

	public void updateContentsFiles(List<String> contents_file_list, int contents_id) throws DataAccessException;

	public void updateContentsView(int contents_id) throws DataAccessException;

	public List<ListContentsVO> selectContentsView(int contents_id) throws DataAccessException;

	public List<ListContentsVO> selectContentsCmt(int contents_id) throws DataAccessException;

	public List<ContentsFileVO> selectContentsFile(int contents_id) throws DataAccessException;
	// 컨텐츠 댓글 카운트
	public List<ListContentsVO> selectContentsCmtList(int compet_id) throws DataAccessException;
	// 컨텐츠 좋아요 카운트
	public List<ListContentsVO> selectContentsLikesList(int compet_id) throws DataAccessException;
	// 좋아요 클릭 여부 검색
	public int selectlikeChenk(Map update)throws DataAccessException;
	// 좋아요 클릭 시 
	public void updateLike(Map update)throws DataAccessException;
    // 좋아요 클릭 취소
	public void deleteLike(Map update)throws DataAccessException;

	public int countLike(int contents_id) throws DataAccessException;

}
