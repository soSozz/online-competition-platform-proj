package com.tstecon.ocp.sidebar.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.compet.dao.CompetDAO;
import com.tstecon.ocp.compet.vo.CompetVO;
import com.tstecon.ocp.sidebar.dao.SidebarDAO;
import com.tstecon.ocp.sidebar.vo.SidebarVO;

@Service("sidebarService")
public class SidebarServiceImpl implements SidebarService {
	@Autowired
	private CompetDAO competDAO;

	@Autowired
	private SidebarDAO sidebarDAO;

	@Override
	public Map<String, List<SidebarVO>> listRankings() throws Exception {
		List<CompetVO> competList = competDAO.selectCompetByTerminated("Y");

		// Map<대회 이름, 해당 대회 랭킹 리스트>
		Map<String, List<SidebarVO>> sidebarMap = new HashMap<String, List<SidebarVO>>();
		for (CompetVO c : competList) {
			List<SidebarVO> rankList = sidebarDAO.selectRankListByCompetId(c.getCompet_id());
			sidebarMap.put(c.getCompet_name(), rankList);
		}
		return sidebarMap;
	}
}
