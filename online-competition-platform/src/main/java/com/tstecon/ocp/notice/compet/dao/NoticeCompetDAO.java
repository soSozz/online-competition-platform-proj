package com.tstecon.ocp.notice.compet.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.compet.vo.CompetFileVO;
import com.tstecon.ocp.compet.vo.CompetVO;
import com.tstecon.ocp.notice.compet.vo.NoticeCompetVO;

public interface NoticeCompetDAO {
	public List<NoticeCompetVO> selectNoticesCompetList(int compet_id) throws DataAccessException;
	public CompetFileVO selectCompetSmallPoster(int compet_id) throws DataAccessException;
	public List<NoticeCompetVO> selectCompetNoticeDetail(int compet_notice_id) throws DataAccessException;
	public void deleteNoticeCompet(int compet_notice_id) throws DataAccessException;
	public void updateNoticeCompet(Map competNoticeMap)throws DataAccessException;
	public int insertNewNoticeCompet(Map addNoticeCompetMap) throws DataAccessException;
	public void updateCompetNoticesView(int compet_notice_id) throws DataAccessException ;
}

