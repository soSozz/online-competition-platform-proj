package com.tstecon.ocp.admin.contents.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tstecon.ocp.contents.vo.ContentsVO;

@Repository("AdminContentsDAO")
public class AdminContentsDAOImpl implements AdminContentsDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ContentsVO> selectContentsName() {
		List<ContentsVO> contentsName = (ArrayList)sqlSession.selectList("mappers.contents.selectContentsName");
		return contentsName;
	}

}
