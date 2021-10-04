package com.tstecon.ocp.contents.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tstecon.ocp.contents.vo.ContentsFileVO;
import com.tstecon.ocp.contents.vo.ContentsVO;
import com.tstecon.ocp.contents.vo.ListContentsVO;

@Repository("contentsDAO")
public class ContentsDAOImpl implements ContentsDAO {

	@Autowired
	private ContentsVO contentsVO;

	@Autowired
	private ContentsFileVO contentFileVO;

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int selectNewContentsFileId() throws DataAccessException {
		return sqlSession.selectOne("mappers.contents.selectNewContentsFileId");
	}

	@Override
	public void insertNewContentsFile(ContentsFileVO contentsFileVO) throws DataAccessException {
		if (contentsFileVO.getContents_id() == 0) {
			sqlSession.insert("mappers.contents.insertNewContentsFileWithOutContentsId", contentsFileVO);
		} else {
			sqlSession.insert("mappers.contents.insertNewContentsFile", contentsFileVO);
		}
	}
	// 컨텐츠 리스트 생성
	@Override
	public List<ListContentsVO> listContents(int compet_id) throws DataAccessException {
		List<ListContentsVO> listContents = sqlSession.selectList("mappers.listContents.selectListContents", compet_id);
		return listContents;
	}
	// 클릭 시 조회수 증가
	@Override
	public void updateContentsView(int contents_id) throws DataAccessException {
		sqlSession.update("mappers.listContents.updateContentsView",contents_id);
		return;
		
	}
	// 댓글 제외 리스트 저장
	@Override
	public List<ListContentsVO> selectContentsView(int contents_id) throws DataAccessException {
		List<ListContentsVO> contentsView = sqlSession.selectList("mappers.listContents.selectContentsView", contents_id);
		return contentsView;
	}
	// 댓글 리스트 저장
	@Override
	public List<ListContentsVO> selectContentsCmt(int contents_id) throws DataAccessException {
		List<ListContentsVO> contentsCmt = sqlSession.selectList("mappers.listContents.selectContentsCmt", contents_id);
		return contentsCmt;
	}
	// 컨텐츠 파일 리스트 저장
	@Override
	public List<ContentsFileVO> selectContentsFile(int contents_id) throws DataAccessException {
		List<ContentsFileVO> contentsFile = sqlSession.selectList("mappers.listContents.selectContentsFile",contents_id);
		return contentsFile;
	}

	@Override
	public int insertNewContents(ContentsVO contentsVO) throws DataAccessException {
		int contents_id = sqlSession.selectOne("mappers.contents.selectNewContentsId");
		contentsVO.setContents_id(contents_id);
		sqlSession.insert("mappers.contents.insertNewContents", contentsVO);
		return contents_id;
	}

	@Override
	public int selectNewContentsId() throws DataAccessException {
		return sqlSession.insert("mappers.contents.selectNewContentsId");
	}

	@Override
	public void updateContentsFiles(List<String> contents_file_list, int contents_id) throws DataAccessException {
		for (String contents_file_id : contents_file_list) {
			Map<String, Integer> fileMap = new HashMap<String, Integer>();
			fileMap.put("contents_id", contents_id);
			fileMap.put("contents_file_id", Integer.parseInt(contents_file_id));
			sqlSession.update("mappers.contents.updateContentsFiles", fileMap);
		}
	}
	// 컨텐츠 댓글 카운트
	@Override
	public List<ListContentsVO> selectContentsCmtList(int compet_id) throws DataAccessException {
		List<ListContentsVO> contentsCmtList = sqlSession.selectList("selectListContentsCmt",compet_id);
		return contentsCmtList;
	}
	// 컨텐츠 좋아요 카운트
	@Override
	public List<ListContentsVO> selectContentsLikesList(int compet_id) throws DataAccessException {
		List<ListContentsVO> contentsLikesList = sqlSession.selectList("selectListContentsLikes",compet_id);
		return contentsLikesList;
	}

}
