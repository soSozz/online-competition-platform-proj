package com.tstecon.ocp.admin.contents.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tstecon.ocp.contents.vo.ContentsVO;

@Repository("AdminContentsDAO")
public class AdminContentsDAOImpl implements AdminContentsDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ContentsVO> selectContentsList(int compet_id) throws DataAccessException {
		List<ContentsVO> contentsList = (ArrayList)sqlSession.selectList("mappers.contents.selectContentsList", compet_id);
		return contentsList;
	}

	@Override
	public List<ContentsVO> selectApprContentsList(int compet_id) throws DataAccessException {
		List<ContentsVO> apprContentsList = (ArrayList)sqlSession.selectList("mappers.contents.selectApprContentsList", compet_id);
		return apprContentsList;
	}

	@Override
	public void updateApprContents(int contents_id) throws DataAccessException {
		sqlSession.update("mappers.contents.updateApprContents", contents_id);
		return;
	}

}
