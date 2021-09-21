package com.tstecon.ocp.admin.contents.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.contents.vo.ContentsVO;

public interface AdminContentsService {

	public List<ContentsVO> ContentsList() throws DataAccessException;

	public List<ContentsVO> ApprContentsList() throws DataAccessException;

}
