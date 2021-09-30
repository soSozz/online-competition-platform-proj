package com.tstecon.ocp.admin.contents.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.contents.vo.ContentsVO;

public interface AdminContentsService {

	public List<ContentsVO> contentsList(int compet_id) throws DataAccessException;

	public List<ContentsVO> apprContentsList(int compet_id) throws DataAccessException;

	public void updateApprContents(int contents_id) throws DataAccessException;


}
