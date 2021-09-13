package com.tstecon.ocp.compet.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import com.tstecon.ocp.compet.vo.CompetQnaVO;
=======
import com.tstecon.ocp.compet.vo.CompetFileVO;
>>>>>>> branch 'master' of https://github.com/ITHwang/online-competition-platform-proj.git
import com.tstecon.ocp.compet.vo.CompetVO;


@Service
public interface CompetService {
//	대회 안내
	public Map<String,List<CompetVO>> CompetInfo(String compet_id) throws DataAccessException;
<<<<<<< HEAD
//문의 	
	public List<CompetQnaVO>qnalistArticles() throws Exception;
=======
	public CompetFileVO CompetSmallPoster(String compet_id) throws DataAccessException;
>>>>>>> branch 'master' of https://github.com/ITHwang/online-competition-platform-proj.git
}
