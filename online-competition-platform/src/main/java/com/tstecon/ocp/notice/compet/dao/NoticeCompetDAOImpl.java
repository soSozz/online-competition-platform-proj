package com.tstecon.ocp.notice.compet.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tstecon.ocp.compet.vo.CompetFileVO;
import com.tstecon.ocp.compet.vo.CompetVO;
import com.tstecon.ocp.notice.compet.vo.NoticeCompetVO;

@Repository("noticeCompetDAO")
public class NoticeCompetDAOImpl implements NoticeCompetDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<NoticeCompetVO> selectNoticesCompetList(int compet_id) throws DataAccessException {

<<<<<<< HEAD

		List<NoticeCompetVO> NoticescompetList = (ArrayList)sqlSession.selectList("mappers.notice.compet.selectNoticesCompetList",compet_id);

=======
		List<NoticeCompetVO> NoticescompetList = (ArrayList)sqlSession.selectList("mappers.notice.compet.selectNoticeCompetList",compet_id);

>>>>>>> branch 'master' of https://github.com/ITHwang/online-competition-platform-proj.git
		return NoticescompetList;
	}
	
//	대회 포스터 클릭
	@Override
	public CompetFileVO selectCompetSmallPoster(int compet_id) throws DataAccessException {
		CompetFileVO CompetSmallPoster = sqlSession.selectOne("mappers.notice.compet.selectCompetSmallPoster",compet_id);
		return CompetSmallPoster;
	}
	
}
