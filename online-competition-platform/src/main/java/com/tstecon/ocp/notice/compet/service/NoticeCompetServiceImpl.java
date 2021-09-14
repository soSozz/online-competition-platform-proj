package com.tstecon.ocp.notice.compet.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.compet.vo.CompetVO;
import com.tstecon.ocp.notice.compet.dao.NoticeCompetDAO;
import com.tstecon.ocp.notice.compet.vo.NoticeCompetVO;

@Service("NoticeCompetService")
public class NoticeCompetServiceImpl implements NoticeCompetService{
	@Autowired
	private NoticeCompetDAO noticeCompetDAO;
	
	@Override
	public List<NoticeCompetVO> listCompetNotices(int compet_id) throws DataAccessException{
		List<NoticeCompetVO> listCompetNotices = noticeCompetDAO.selectNoticesCompetList(compet_id);
		
		
		return listCompetNotices;
	}

	
	
}
