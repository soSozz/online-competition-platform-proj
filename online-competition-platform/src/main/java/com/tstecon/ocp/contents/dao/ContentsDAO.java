package com.tstecon.ocp.contents.dao;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.contents.vo.ContentsFileVO;

public interface ContentsDAO {
	public int selectNewContentsFileId() throws DataAccessException;

	public void insertNewContentsFile(ContentsFileVO contentsFileVO) throws DataAccessException;

}
