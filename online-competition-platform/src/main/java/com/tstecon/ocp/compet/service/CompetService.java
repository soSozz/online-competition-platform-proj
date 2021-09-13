package com.tstecon.ocp.compet.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.compet.vo.CompetFileVO;
import com.tstecon.ocp.compet.vo.CompetVO;


@Service
public interface CompetService {
	public Map<String,List<CompetVO>> CompetInfo(String compet_id) throws DataAccessException;
	public CompetFileVO CompetSmallPoster(String compet_id) throws DataAccessException;
}
