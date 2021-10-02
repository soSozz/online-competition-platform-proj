
package com.tstecon.ocp.admin.monitor.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tstecon.ocp.admin.monitor.vo.AdminCmtVO;
import com.tstecon.ocp.admin.monitor.vo.AdminMonitorVO;

@Repository("adminMonitorDAO")
public class AdminMonitorDAOImpl implements AdminMonitorDAO{
	@Autowired
	private SqlSession sqlSession;
	
//	@Override
//	public AdminMonitorVO selectAdminMoniterLikesMap(HashMap LikesMap) throws DataAccessException {
//		AdminMonitorVO Likes =(AdminMonitorVO) sqlSession.selectOne("mappers.admin.monitor.selectAdminMoniterLikesMap", LikesMap);
//		return Likes;
//	}
//	
//	@Override
//	public AdminMonitorVO selectAdminMoniterCmtMapt(HashMap CmtMap) throws DataAccessException {
//		AdminMonitorVO Cmt =(AdminMonitorVO) sqlSession.selectOne("mappers.admin.monitor.selectAdminMoniterCmtMap", CmtMap);
//		return Cmt;
//	}
	@Override
	public List<AdminCmtVO> selectAdminCmtList() throws DataAccessException {
		List<AdminCmtVO> adminCmtist = (ArrayList)sqlSession.selectList("mappers.admin.monitor.selectAdminCmtList");
		return adminCmtist;
	}
	
	@Override
	public List<AdminMonitorVO> selectAdminMoniterLikeList(Map dateMap) throws DataAccessException {
		List<AdminMonitorVO> adminLikeList = (ArrayList)sqlSession.selectList("mappers.admin.monitor.selectAdminMoniterLikeList", dateMap);
		return adminLikeList;
	}
	
	@Override
	public List<AdminMonitorVO> selectAdminMoniterCmtList(Map dateMaps) throws DataAccessException {
		List<AdminMonitorVO> adminCmtList = (ArrayList)sqlSession.selectList("mappers.admin.monitor.selectAdminMoniterCmtList", dateMaps);
		return adminCmtList;
	}
	
}


