package com.tstecon.ocp.compet.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.compet.dao.CompetDAO;
import com.tstecon.ocp.compet.qna.vo.CompetQnaVO;
import com.tstecon.ocp.compet.vo.CompetFileVO;
import com.tstecon.ocp.compet.vo.CompetVO;
import com.tstecon.ocp.notice.compet.vo.NoticeCompetVO;

@Service("CompetService")
public class CompetServiceImpl implements CompetService{
	@Autowired
	private CompetDAO competDAO;

//	대회안내
	@Override
	public Map<String, List<CompetVO>> CompetInfo(int compet_id) throws DataAccessException {
		Map<String,List<CompetVO>>competInfo=new HashMap<String,List<CompetVO>>();
		List<CompetVO> competList=competDAO.selectCompet_id(compet_id);
		competInfo.put("compet_id",competList);
		competList=competDAO.selectCompetInfo(compet_id);
		competInfo.put("info",competList);

		return competInfo;
	}
	
//	대회 포스터
	@Override
	public Map<String, List<CompetFileVO>> CompetPoster(int compet_id) throws DataAccessException {
		Map<String,List<CompetFileVO>>competInfo=new HashMap<String,List<CompetFileVO>>();
		List<CompetFileVO> competList=competDAO.selectCompetBigPoster(compet_id);
		competInfo.put("competBigPoster",competList);
		competList=competDAO.selectCompetSmallPoster(compet_id);
		competInfo.put("competSmallPoster",competList);
		competList=competDAO.selectCompet_id_file(compet_id);
		competInfo.put("compet_id",competList);
		return competInfo;
	}


	
//대회 공지사항: 작은 포스터 가져오기
	@Override
	public List<CompetFileVO> CompetSmallPoster(int compet_id) throws DataAccessException{
		List<CompetFileVO> CompetSmallPoster = competDAO.selectCompetSmallPoster(compet_id);
		return CompetSmallPoster;

	}


}
