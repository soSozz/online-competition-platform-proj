package com.tstecon.ocp.admin.contents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.admin.contents.dao.AdminContentsDAO;
import com.tstecon.ocp.contents.vo.ContentsVO;

@Service("AdminContentsService")
public class AdminContentsServiceImpl implements AdminContentsService{
	
	@Autowired
	private AdminContentsDAO adminContentsDAO;
	
	@Override
	public List<ContentsVO> contentsList(int compet_id) {
		List<ContentsVO> contentsList = adminContentsDAO.selectContentsList(compet_id); 
		return contentsList;
	}

	@Override
	public List<ContentsVO> apprContentsList(int compet_id) {
		List<ContentsVO> contentsList = adminContentsDAO.selectApprContentsList(compet_id);
		return contentsList;
	}

	@Override
	public void updateApprContents(int contents_id) throws DataAccessException {
		adminContentsDAO.updateApprContents(contents_id);
		return;
	}


}
