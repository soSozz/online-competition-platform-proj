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

	@Override
	public List<ListContentsVO> listContents(int compet_id) throws DataAccessException {
		List<ListContentsVO> listContents = sqlSession.selectList("mappers.listContents.selectListContents", compet_id);
		return listContents;
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

}
