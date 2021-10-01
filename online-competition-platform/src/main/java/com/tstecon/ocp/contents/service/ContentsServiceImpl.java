package com.tstecon.ocp.contents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.contents.dao.ContentsDAO;
import com.tstecon.ocp.contents.vo.ContentsFileVO;
import com.tstecon.ocp.contents.vo.ContentsVO;
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

	@Override
	public int addNewContents(ContentsVO contentsVO) throws DataAccessException {
		return contentsDAO.insertNewContents(contentsVO);
	}

	// contents file들에 contents id 추가
	@Override
	public void addContentsIdToFiles(List<String> contents_file_list, int contents_id) throws DataAccessException {
		contentsDAO.updateContentsFiles(contents_file_list, contents_id);
	}

}
