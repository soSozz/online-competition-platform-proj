package com.tstecon.ocp.admin.categ.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tstecon.ocp.categ.vo.CategVO;
import com.tstecon.ocp.compet.vo.CompetVO;

@Repository("AdminCategDAO")
public class AdminCategDAOImpl implements AdminCategDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<CategVO> selectCategAllList() {
		List<CategVO> categList = (ArrayList)sqlSession.selectList("mappers.admin_categ.selectAllCateg");
		return categList;
	}

	@Override
	public List<CompetVO> selectCompetList() {
		List<CompetVO> competList = (ArrayList)sqlSession.selectList("mappers.compet.selectAllCompet");
		return competList;
	}

}
