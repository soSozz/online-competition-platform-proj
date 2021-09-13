package com.tstecon.ocp.notice.compet.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.compet.vo.CompetVO;
import com.tstecon.ocp.notice.compet.dao.NoticeCompetDAO;
import com.tstecon.ocp.notice.compet.vo.NoticeCompetVO;


public class NoticeCompetServiceImpl implements NoticeCompetService{
	@Autowired
	private NoticeCompetDAO NociteCompetDAO;
	
	@Override
	public List<NoticeCompetVO> listCompetNotices(String compet_id) throws DataAccessException{
		List<NoticeCompetVO> competList=competDAO.selectCompetPoster("poster");
		CompetMap.put("Poster",competList);
		competList=competDAO.selectCompetInfo("info");
		CompetMap.put("info",competList);
		
		return null;
	}
//	@Override
//	public Map<String, List<NoticeCompetVO>> CompetInfo(String compet_id) throws DataAccessException {
//		Map<String,List<NoticeCompetVO>> CompetMap=new HashMap<String,List<NoticeCompetVO>>();
//		List<CompetVO> competList=competDAO.selectCompetPoster("poster");
//		CompetMap.put("Poster",competList);
//		competList=competDAO.selectCompetInfo("info");
//		CompetMap.put("info",competList);
//
//		return CompetMap;
//	}
	
	
}
