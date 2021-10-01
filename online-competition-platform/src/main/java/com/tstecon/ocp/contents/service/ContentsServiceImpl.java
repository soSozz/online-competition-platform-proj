package com.tstecon.ocp.contents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.contents.dao.ContentsDAO;
import com.tstecon.ocp.contents.vo.ContentsFileVO;
import com.tstecon.ocp.contents.vo.ListContentsVO;

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

	@Override
	public List<ListContentsVO> listContents(int compet_id) throws DataAccessException {
		List<ListContentsVO> listContents = contentsDAO.listContents(compet_id);
		return listContents;
	}

}
