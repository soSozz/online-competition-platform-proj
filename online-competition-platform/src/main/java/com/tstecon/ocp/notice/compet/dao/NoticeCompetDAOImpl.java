package com.tstecon.ocp.notice.compet.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;


import com.tstecon.ocp.notice.compet.vo.NoticeCompetVO;

public class NoticeCompetDAOImpl {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<NoticeCompetVO> selectNoticeCompetInfo(String compet_Notice_id) throws DataAccessException {
		List<NoticeCompetVO> competList = (ArrayList)sqlSession.selectList("mapper.notice.compet.selectNoticeCompetInfo",compet_id);
		return competList;
	}
	@Override
	public List<NoticeCompetVO> selectNoticeCompetPoster(String compet_Notice_id) throws DataAccessException {
		<NoticeCompetVO> competList = (ArrayList)sqlSession.selectOne("mapper.notice.compet.selectCompetPoster",compet_id);
		return null;
	}
}
