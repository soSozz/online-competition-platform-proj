package com.tstecon.ocp.compet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.compet.vo.CompetVO;


public interface CompetDAO {
//	대회안내 포스터
	public List<CompetVO> selectCompetPoster(String compet_id) throws DataAccessException;
//	대회안내 내용
	public List<CompetVO> selectCompetInfo(String Compet_id) throws DataAccessException;
}
