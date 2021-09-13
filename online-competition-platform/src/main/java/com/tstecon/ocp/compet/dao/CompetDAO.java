package com.tstecon.ocp.compet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.compet.vo.CompetFileVO;
import com.tstecon.ocp.compet.vo.CompetVO;


public interface CompetDAO {
	public List<CompetVO> selectCompetPoster(String compet_id) throws DataAccessException;
	public List<CompetVO> selectCompetInfo(String Compet_id) throws DataAccessException;
	public CompetFileVO selectCompetSmallPoster(String Compet_id) throws DataAccessException;
}
