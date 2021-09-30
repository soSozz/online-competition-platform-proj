package com.tstecon.ocp.admin.contents.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.contents.vo.ContentsVO;

public interface AdminContentsDAO {

	public List<ContentsVO> selectContentsList(int compet_id)throws DataAccessException;

	public List<ContentsVO> selectApprContentsList(int compet_id)throws DataAccessException;

	public void updateApprContents(int contents_id)throws DataAccessException;

}
