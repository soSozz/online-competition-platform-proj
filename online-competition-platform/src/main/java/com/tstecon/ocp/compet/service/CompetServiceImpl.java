package com.tstecon.ocp.compet.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.tstecon.ocp.compet.dao.CompetDAO;
import com.tstecon.ocp.compet.vo.CompetVO;

public class CompetServiceImpl implements CompetService{
	@Autowired
	private CompetDAO competDAO;

	@Override
	public Map<String, List<CompetVO>> CompetInfo() throws DataException {
		Map<String,List<CompetVO>> CompetMap=new HashMap<String,List<CompetVO>>();
		List<CompetVO> competList=competDAO.selectCompetPoster("compet");
		CompetMap.put("compet",competList);
		competList=competDAO.selectCompetInfo("info");
		CompetMap.put("info",competList);

		return CompetMap;
	}

}
