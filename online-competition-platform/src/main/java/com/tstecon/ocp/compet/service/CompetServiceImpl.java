package com.tstecon.ocp.compet.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.compet.dao.CompetDAO;
import com.tstecon.ocp.compet.vo.CompetVO;

@Service("competService")
public class CompetServiceImpl implements CompetService{
	@Autowired
	private CompetDAO competDAO;

//	대회안내
	@Override
	public Map<String, List<CompetVO>> CompetInfo(String compet_id) throws DataAccessException {
		Map<String,List<CompetVO>> CompetMap=new HashMap<String,List<CompetVO>>();
		List<CompetVO> competList=competDAO.selectCompetPoster("poster");
		CompetMap.put("Poster",competList);
		competList=competDAO.selectCompetInfo("info");
		CompetMap.put("info",competList);

		return CompetMap;
	}

}
