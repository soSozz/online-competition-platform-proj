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

}
