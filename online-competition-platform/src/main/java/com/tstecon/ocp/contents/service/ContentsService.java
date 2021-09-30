package com.tstecon.ocp.contents.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.contents.vo.ContentsVO;
import com.tstecon.ocp.contents.vo.ListContentsVO;

@Service
public interface ContentsService {

	public List<ListContentsVO> listContents(int compet_id)throws DataAccessException;;

}
