package com.tstecon.ocp.notice.compet.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.compet.vo.CompetFileVO;
import com.tstecon.ocp.notice.compet.vo.NoticeCompetVO;

public interface NoticeCompetService {
	public List<NoticeCompetVO> listCompetNotices(int compet_id) throws DataAccessException;
	public CompetFileVO CompetSmallPoster(int compet_id) throws DataAccessException;
	public List<NoticeCompetVO> noticeCompetDetail(int compet_notice_id) throws DataAccessException;
	public void modNoticeCompet(Map competNoticeMap) throws Exception;
	public void removeNoticeCompet(int compet_notice_id) throws Exception;
	public int addNewNoticeCompet(Map addNoticeCompetMap) throws Exception;
	public void updateCompetNoticesView(int compet_notice_id) throws DataAccessException;
}
