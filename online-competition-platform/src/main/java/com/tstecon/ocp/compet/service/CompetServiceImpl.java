package com.tstecon.ocp.compet.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.compet.dao.CompetDAO;
import com.tstecon.ocp.compet.vo.CompetFileVO;
import com.tstecon.ocp.compet.vo.CompetVO;
import com.tstecon.ocp.notice.compet.vo.NoticeCompetVO;

public class CompetServiceImpl implements CompetService{
	@Autowired
	private CompetDAO competDAO;

	@Override
	public Map<String, List<CompetVO>> CompetInfo(String compet_id) throws DataAccessException {
		Map<String,List<CompetVO>> CompetMap=new HashMap<String,List<CompetVO>>();
		List<CompetVO> competList=competDAO.selectCompetPoster("poster");
		CompetMap.put("Poster",competList);
		competList=competDAO.selectCompetInfo("info");
		CompetMap.put("info",competList);

		return CompetMap;
	}
	
	//대회 공지사항: 작은 포스터 가져오기
	@Override
	public CompetFileVO CompetSmallPoster(String compet_id) throws DataAccessException{
		CompetFileVO CompetSmallPoster = competDAO.selectCompetSmallPoster(compet_id);
		return CompetSmallPoster;
	}

}
