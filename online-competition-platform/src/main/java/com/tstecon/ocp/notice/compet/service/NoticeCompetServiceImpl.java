package com.tstecon.ocp.notice.compet.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.compet.vo.CompetFileVO;
import com.tstecon.ocp.compet.vo.CompetVO;
import com.tstecon.ocp.notice.compet.dao.NoticeCompetDAO;
import com.tstecon.ocp.notice.compet.vo.NoticeCompetVO;

@Service("NoticeCompetService")
public class NoticeCompetServiceImpl implements NoticeCompetService{
	@Autowired
	private NoticeCompetDAO noticeCompetDAO;
	
	@Override
	public List<NoticeCompetVO> listCompetNotices(int compet_id) throws DataAccessException{
		System.out.println(compet_id + "service");
		List<NoticeCompetVO> listCompetNotices = noticeCompetDAO.selectNoticesCompetList(compet_id);
		
		
		return listCompetNotices;
	}
	@Override
	public CompetFileVO CompetSmallPoster(int compet_id) throws DataAccessException{
		CompetFileVO CompetSmallPoster = noticeCompetDAO.selectCompetSmallPoster(compet_id);
		return CompetSmallPoster;
	}
	
	@Override
	public void updateCompetNoticesView(int compet_notice_id) throws DataAccessException {
		noticeCompetDAO.updateCompetNoticesView(compet_notice_id);
		return;
		
	}
	
	public List<NoticeCompetVO> noticeCompetDetail(int compet_notice_id) throws DataAccessException{
		List<NoticeCompetVO> noticeCompetDetail = noticeCompetDAO.selectCompetNoticeDetail(compet_notice_id);
		return noticeCompetDetail;
	}
	public void modNoticeCompet(Map competNoticeMap) throws Exception{
		noticeCompetDAO.updateNoticeCompet(competNoticeMap);
	}
	public void removeNoticeCompet(int compet_notice_id) throws Exception{
		noticeCompetDAO.deleteNoticeCompet(compet_notice_id);
	}
	
	@Override
	public int addNewNoticeCompet(Map addNoticeCompetMap) throws Exception {
		Iterator<String> keys = addNoticeCompetMap.keySet().iterator();

		while (keys.hasNext()) {
			String key = keys.next();
			System.out.println(String.format("Å° : %s, °ª : %s", key, addNoticeCompetMap.get(key)));
		}
		return noticeCompetDAO.insertNewNoticeCompet(addNoticeCompetMap);
	}
}
