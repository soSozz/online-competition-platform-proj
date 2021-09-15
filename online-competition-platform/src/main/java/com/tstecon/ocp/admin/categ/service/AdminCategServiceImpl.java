package com.tstecon.ocp.admin.categ.service;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<CompetVO>> Competlist() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


}
