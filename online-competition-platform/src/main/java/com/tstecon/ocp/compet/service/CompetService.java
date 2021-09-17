package com.tstecon.ocp.compet.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import com.tstecon.ocp.compet.qna.vo.CompetQnaVO;
=======
import com.tstecon.ocp.categ.vo.CategVO;
>>>>>>> branch 'master' of https://github.com/ITHwang/online-competition-platform-proj.git
import com.tstecon.ocp.compet.vo.CompetFileVO;
import com.tstecon.ocp.compet.vo.CompetVO;


@Service
public interface CompetService {
//	대회 안내

	public Map<String,List<CompetVO>> CompetInfo(int compet_id) throws DataAccessException;


	public Map<String,List<CompetFileVO>> CompetPoster(int compet_id) throws DataAccessException;
<<<<<<< HEAD
}
=======

//문의 	
	public List<CompetQnaVO>qnalistArticles() throws Exception;
//문의 글쓰기창
	 public CompetQnaVO login(CompetQnaVO competqnaVO) throws Exception;

	 //대회 이름 리스트 가져오기
	 public List<CompetVO> competListById(int i) throws Exception;
}
>>>>>>> branch 'master' of https://github.com/ITHwang/online-competition-platform-proj.git
