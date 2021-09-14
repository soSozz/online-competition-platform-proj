package com.tstecon.ocp.notice.compet.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.notice.compet.vo.NoticeCompetVO;

public interface NoticeCompetService {
	public List<NoticeCompetVO> listCompetNotices(String compet_id) throws DataAccessException;
}
