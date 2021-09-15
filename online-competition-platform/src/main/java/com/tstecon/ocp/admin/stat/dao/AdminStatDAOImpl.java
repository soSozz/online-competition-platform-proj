
package com.tstecon.ocp.admin.stat.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tstecon.ocp.admin.stat.vo.AdminStatVO;

@Repository("adminStatDAO")
public class AdminStatDAOImpl implements AdminStatDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<AdminStatVO> selectAdminStatContentsList() throws DataAccessException {
		List<AdminStatVO> AdminStatContentsList = (ArrayList)sqlSession.selectList("mappers.admin.stat.selectAdminStatContentsList");
		return AdminStatContentsList;
	}
	
	@Override
	public List<AdminStatVO> selectAdminStatLikesList() throws DataAccessException {
		List<AdminStatVO> AdminStatLikesist = (ArrayList)sqlSession.selectList("mappers.admin.stat.selectAdminStatLikesList");
		return AdminStatLikesist;
	}
	
	@Override
	public List<AdminStatVO> selectAdminStatCmtList() throws DataAccessException {
		List<AdminStatVO> AdminStatCmtist = (ArrayList)sqlSession.selectList("mappers.admin.stat.selectAdminStatCmtList");
		return AdminStatCmtist;
	}
	
	@Override
	public List<AdminStatVO> selectAdminStatViewList() throws DataAccessException {
		List<AdminStatVO> AdminStatViewist = (ArrayList)sqlSession.selectList("mappers.admin.stat.selectAdminStatViewList");
		return AdminStatViewist;
	}
}


