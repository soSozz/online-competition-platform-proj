package com.tstecon.ocp.contents.dao;

import java.util.List;

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
		List<ContentsFileVO> contentsFile = sqlSession.selectList("mappers.listContens.selectContentsFile",contents_id);
		return contentsFile;
	}

}
