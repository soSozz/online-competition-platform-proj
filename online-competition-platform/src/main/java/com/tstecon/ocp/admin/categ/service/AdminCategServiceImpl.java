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
	public List<CategVO> CategAllList() throws DataAccessException {
//		Map<String,List<CategVO>>categList=new HashMap<String,List<CategVO>>();
		List<CategVO> categList = adminCategDAO.selectCategAllList();
//		categList.put("categList", categ);
		return categList;
	}

	@Override
	public List<CategVO> CategName() throws DataAccessException {
		List<CategVO> categName = adminCategDAO.selectCategName();
		return categName;
	}


}
