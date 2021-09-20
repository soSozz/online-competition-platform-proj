package com.tstecon.ocp.admin.contents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.admin.contents.dao.AdminContentsDAO;
import com.tstecon.ocp.contents.vo.ContentsVO;

@Service("AdminContentsService")
public class AdminContentsServiceImpl implements AdminContentsService{
	
	@Autowired
	private AdminContentsDAO adminContentsDAO;
	
	@Override
	public List<ContentsVO> ContentsList() {
		List<ContentsVO> contentsList = adminContentsDAO.selectContentsName(); 
		return null;
	}

}
