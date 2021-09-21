package com.tstecon.ocp.admin.contents.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.contents.vo.ContentsVO;

public interface AdminContentsDAO {

	public List<ContentsVO> selectContentsName()throws DataAccessException;

	public List<ContentsVO> selectApprContentsList()throws DataAccessException;

}
