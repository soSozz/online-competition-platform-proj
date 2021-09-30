package com.tstecon.ocp.contents.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.contents.vo.ContentsVO;
import com.tstecon.ocp.contents.vo.ListContentsVO;

public interface ContentsDAO {

	public List<ListContentsVO> listContents(int compet_id) throws DataAccessException;

}
