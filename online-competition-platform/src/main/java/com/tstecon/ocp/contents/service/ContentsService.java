package com.tstecon.ocp.contents.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.contents.vo.ContentsFileVO;
import com.tstecon.ocp.contents.vo.ListContentsVO;

public interface ContentsService {

	public int newContentsFileId() throws Exception;

	public void addNewContentsFile(ContentsFileVO contentsFileVO) throws Exception;

	public List<ListContentsVO> listContents(int compet_id) throws DataAccessException;;

}
