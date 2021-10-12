package com.tstecon.ocp.admin.contents.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.admin.contents.dao.AdminContentsDAO;
import com.tstecon.ocp.contents.vo.ContentsFileVO;
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

	@Override
	public List<ContentsVO> selectContentsView(int contents_id) throws DataAccessException {
		List<ContentsVO> contentsView = adminContentsDAO.selectContentsView(contents_id);
		return contentsView;
	}

	@Override
	public void updateRefusalContents(Map map) throws DataAccessException {
		adminContentsDAO.updateRefusalContents(map);
		return;	
	}

	@Override
	public List<ContentsFileVO> selectContentsFileView(int contents_id) throws DataAccessException {
		List<ContentsFileVO> contentsFileView = adminContentsDAO.selectContentsFileView(contents_id);
		return contentsFileView;
	}


}
