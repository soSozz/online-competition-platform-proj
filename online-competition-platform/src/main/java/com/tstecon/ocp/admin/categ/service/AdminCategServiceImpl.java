package com.tstecon.ocp.admin.categ.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.admin.categ.dao.AdminCategDAO;
import com.tstecon.ocp.categ.vo.CategVO;
import com.tstecon.ocp.compet.vo.CompetVO;

@Service("AdminCategService")
public class AdminCategServiceImpl implements AdminCategService{
	
	@Autowired
	private AdminCategDAO adminCategDAO;
	
	@Override
	public Map<String, List<CategVO>> Categlist() throws DataAccessException {
		Map<String,List<CategVO>>categList=new HashMap<String,List<CategVO>>();
		List<CategVO> categ = adminCategDAO.selectCategList();
		categList.put("categlist", categ);
		return categList;
	}

	@Override
	public Map<String, List<CompetVO>> Competlist() throws DataAccessException {
		Map<String,List<CompetVO>>competList=new HashMap<String,List<CompetVO>>();
		List<CompetVO> categ = adminCategDAO.selectCompetList();
		competList.put("categlist", categ);
		return competList;
	}


}
