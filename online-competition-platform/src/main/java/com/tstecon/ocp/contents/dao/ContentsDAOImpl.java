package com.tstecon.ocp.contents.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tstecon.ocp.contents.vo.ContentsVO;
import com.tstecon.ocp.contents.vo.ListContentsVO;

@Repository("ContentsDAO")
public class ContentsDAOImpl implements ContentsDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ListContentsVO> listContents(int compet_id) throws DataAccessException {
		List<ListContentsVO> listContents = sqlSession.selectList("mappers.listContents.selectListContents",compet_id);
		return listContents;
	}

}
