package com.tstecon.ocp.compet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;


public interface CompetDAO {
	public List selectCompetPoster() throws DataAccessException;
	public List selectCompetInfo() throws DataAccessException;
}
