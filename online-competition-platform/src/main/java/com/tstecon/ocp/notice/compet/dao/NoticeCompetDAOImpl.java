package com.tstecon.ocp.notice.compet.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tstecon.ocp.notice.compet.vo.NoticeCompetVO;

@Repository("noticeCompetDAO")
public class NoticeCompetDAOImpl implements NoticeCompetDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<NoticeCompetVO> selectNoticesCompetList(int compet_id) throws DataAccessException {
		List<NoticeCompetVO> NoticescompetList = (ArrayList)sqlSession.selectList("mappers.notice.compet.selectNoticesCompetList",compet_id);
		return NoticescompetList;
	}
	
}
