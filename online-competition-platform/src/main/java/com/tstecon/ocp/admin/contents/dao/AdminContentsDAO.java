package com.tstecon.ocp.admin.contents.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.contents.vo.ContentsFileVO;
import com.tstecon.ocp.contents.vo.ContentsVO;

public interface AdminContentsDAO {

	public List<ContentsVO> selectContentsList(int compet_id)throws DataAccessException;

	public List<ContentsVO> selectApprContentsList(int compet_id)throws DataAccessException;

	public void updateApprContents(int contents_id)throws DataAccessException;

	public List<ContentsVO> selectContentsView(int contents_id)throws DataAccessException;

	public void updateRefusalContents(Map map) throws DataAccessException;

	public List<ContentsFileVO> selectContentsFileView(int contents_id) throws DataAccessException;

}
