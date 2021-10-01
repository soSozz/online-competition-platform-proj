package com.tstecon.ocp.contents.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.contents.vo.ContentsFileVO;
import com.tstecon.ocp.contents.vo.ListContentsVO;

public interface ContentsService {

	public int newContentsFileId() throws Exception;

	public void addNewContentsFile(ContentsFileVO contentsFileVO) throws Exception;

	public List<ListContentsVO> listContents(int compet_id) throws DataAccessException;

	public void updateContentsView(int contents_id) throws DataAccessException;

	public List<ListContentsVO> selectContentsView(int contents_id) throws DataAccessException;

	public List<ListContentsVO> selectContentsCmt(int contents_id) throws DataAccessException;

	public List<ContentsFileVO> selectContentsFile(int contents_id) throws DataAccessException;
}
