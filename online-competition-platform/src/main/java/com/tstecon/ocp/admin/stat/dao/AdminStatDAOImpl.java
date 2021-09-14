//package com.tstecon.ocp.admin.stat.dao;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.stereotype.Repository;
//
//import com.tstecon.ocp.admin.stat.vo.AdminStatVO;
//import com.tstecon.ocp.notice.compet.vo.NoticeCompetVO;
//@Repository("adminStatDAO")
//public class AdminStatDAOImpl {
//	@Autowired
//	private SqlSession sqlSession;
//	
//	@Override
//	public List<AdminStatVO> selectNoticesCompetList(int compet_id) throws DataAccessException {
//		List<NoticeCompetVO> NoticescompetList = (ArrayList)sqlSession.selectList("mapper.admin.stat.selectNoticeCompetList",compet_id);
//		return NoticescompetList;
//	}
//}
