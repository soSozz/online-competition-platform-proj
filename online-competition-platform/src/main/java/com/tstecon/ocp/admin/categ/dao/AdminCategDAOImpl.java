package com.tstecon.ocp.admin.categ.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tstecon.ocp.categ.vo.CategVO;
import com.tstecon.ocp.compet.vo.CompetVO;

@Repository("adminCategDAO")
public class AdminCategDAOImpl implements AdminCategDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<CategVO> selectCategAllList() {
		List<CategVO> categList = (ArrayList) sqlSession.selectList("mappers.admin_categ.selectAllCateg");
		return categList;
	}

	@Override
	public List<CompetVO> selectCompetList() {
		List<CompetVO> competList = (ArrayList) sqlSession.selectList("mappers.compet.selectAllCompet");
		return competList;
	}

	@Override
	public List<CategVO> selectCategName() throws DataAccessException {
		List<CategVO> categName = (ArrayList) sqlSession.selectList("mappers.admin_categ.selectCategName");
		return categName;
	}

	@Override
	public int selectCategIdByName(Map<String, Object> addCompetMap) throws DataAccessException {
		int categ_id = sqlSession.selectOne("mappers.admin_categ.selectCategIdByName", addCompetMap);
		return categ_id;
	}

}
