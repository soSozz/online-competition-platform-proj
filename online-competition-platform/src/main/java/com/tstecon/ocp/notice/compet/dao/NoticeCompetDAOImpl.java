package com.tstecon.ocp.notice.compet.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tstecon.ocp.compet.vo.CompetFileVO;
import com.tstecon.ocp.notice.compet.vo.NoticeCompetVO;
import com.tstecon.ocp.qna.vo.CompetQnaVO;

@Repository("noticeCompetDAO")
public class NoticeCompetDAOImpl implements NoticeCompetDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<NoticeCompetVO> selectNoticesCompetList(int compet_id) throws DataAccessException {

		List<NoticeCompetVO> NoticescompetList = (ArrayList) sqlSession.selectList("mappers.notice.compet.selectNoticesCompetList", compet_id);
		return NoticescompetList;


	}

	@Override
	public CompetFileVO selectCompetSmallPoster(int compet_id) throws DataAccessException {
		CompetFileVO CompetSmallPoster = sqlSession.selectOne("mappers.notice.compet.selectCompetSmallPoster",compet_id);
		return CompetSmallPoster;
	}
	
	@Override
	public void updateCompetNoticesView(int compet_notice_id) throws DataAccessException {
		sqlSession.update("mappers.notice.compet.updateCompetNoticesView",compet_notice_id);
		return;
		
	}
	
	public List<NoticeCompetVO> selectCompetNoticeDetail(int compet_notice_id) throws DataAccessException {
		return sqlSession.selectList("mappers.notice.compet.selectCompetNoticeDetail", compet_notice_id);
	}
	public void updateNoticeCompet(Map competNoticeMap) throws DataAccessException{
		
		int res = sqlSession.update("mappers.notice.compet.updateCompetNotice", competNoticeMap);
		
		
		
	}
    public void deleteNoticeCompet(int compet_notice_id) throws DataAccessException{
		
		sqlSession.update("mappers.notice.compet.deleteCompetNotice", compet_notice_id);
		
		
	}
  //글 쓰기 추가
  	public int insertNewNoticeCompet(Map addNoticeCompetMap) throws DataAccessException {
  		int compet_notice_id = selectNewCompetNoticeNO();
  		addNoticeCompetMap.put("compet_notice_id", compet_notice_id);
  		
  		sqlSession.insert("mappers.notice.compet.insertNewCompetNotice", addNoticeCompetMap);
  		return compet_notice_id;
  	}
  //글 쓰기 추가, 글 번호 가져오기
  	private int selectNewCompetNoticeNO() throws DataAccessException {
  		return sqlSession.selectOne("mappers.notice.compet.selectNewCompetNoticeNO");
  	}

}
