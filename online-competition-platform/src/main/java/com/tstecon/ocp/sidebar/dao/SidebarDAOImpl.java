package com.tstecon.ocp.sidebar.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tstecon.ocp.sidebar.vo.SidebarVO;

@Repository("sidebarDAO")
public class SidebarDAOImpl implements SidebarDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<SidebarVO> selectRankListByCompetId(int compet_id) throws DataAccessException {
		return sqlSession.selectList("mappers.sidebar.selectRankListByCompetId", compet_id);
	}

}
