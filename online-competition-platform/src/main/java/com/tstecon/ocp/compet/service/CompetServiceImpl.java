package com.tstecon.ocp.compet.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.compet.dao.CompetDAO;
import com.tstecon.ocp.compet.vo.CompetFileVO;
import com.tstecon.ocp.compet.vo.CompetVO;
import com.tstecon.ocp.notice.compet.vo.NoticeCompetVO;
import com.tstecon.ocp.qna.vo.CompetQnaVO;

@Service("competService")
public class CompetServiceImpl implements CompetService{
	@Autowired
	private CompetDAO competDAO;

//	대회안내
	@Override
	public Map<String, List<CompetVO>> CompetInfo(String compet_id) throws DataAccessException {
		Map<String,List<CompetVO>> CompetMap=new HashMap<String,List<CompetVO>>();
		List<CompetVO> competList=competDAO.selectCompetPoster("poster");
		CompetMap.put("poster",competList);
		competList=competDAO.selectCompetInfo("info");
		CompetMap.put("info",competList);

		return CompetMap;
	}

//문의 게시판
	@Override
	public List<CompetQnaVO> qnalistArticles() throws Exception {
		List<CompetQnaVO> qnaList = competDAO.selectAllQnaList();
		return qnaList;
	}
	
//대회 공지사항: 작은 포스터 가져오기
	@Override
	public CompetFileVO CompetSmallPoster(String compet_id) throws DataAccessException{
		CompetFileVO CompetSmallPoster = competDAO.selectCompetSmallPoster(compet_id);
		return CompetSmallPoster;

	}

}
