package com.tstecon.ocp.contents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.contents.dao.ContentsDAO;
import com.tstecon.ocp.contents.vo.ContentsFileVO;

@Service("contentsService")
public class ContentsServiceImpl implements ContentsService {

	@Autowired
	private ContentsDAO contentsDAO;

	@Override
	public int newContentsFileId() throws Exception {
		return contentsDAO.selectNewContentsFileId();
	}

	@Override
	public void addNewContentsFile(ContentsFileVO contentsFileVO) throws Exception {
		contentsDAO.insertNewContentsFile(contentsFileVO);
	}

}
