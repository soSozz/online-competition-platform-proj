package com.tstecon.ocp.compet.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.tstecon.ocp.compet.vo.CompetVO;


@Service
public interface CompetService {
	public Map<String,List<CompetVO>> CompetInfo() throws DataException;
}
