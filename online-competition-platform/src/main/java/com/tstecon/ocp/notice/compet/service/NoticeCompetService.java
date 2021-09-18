package com.tstecon.ocp.notice.compet.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.compet.vo.CompetFileVO;
import com.tstecon.ocp.notice.compet.vo.NoticeCompetVO;

public interface NoticeCompetService {
	public List<NoticeCompetVO> listCompetNotices(int compet_id) throws DataAccessException;
	public CompetFileVO CompetSmallPoster(int compet_id) throws DataAccessException;
}
