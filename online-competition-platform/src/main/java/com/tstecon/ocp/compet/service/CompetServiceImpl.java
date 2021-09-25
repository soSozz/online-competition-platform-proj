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



@Service("CompetService")
public class CompetServiceImpl implements CompetService {
	@Autowired
	private CompetDAO competDAO;

//	대회안내
	@Override
	public Map<String, List<CompetVO>> CompetInfo(int compet_id) throws DataAccessException {
		Map<String, List<CompetVO>> competInfo = new HashMap<String, List<CompetVO>>();
		List<CompetVO> competList = competDAO.selectCompet_id(compet_id);
		competInfo.put("compet_id", competList);
		competList = competDAO.selectCompetInfo(compet_id);
		competInfo.put("info", competList);

		return competInfo;
	}

//	대회 포스터
	@Override
	public Map<String, List<CompetFileVO>> CompetPoster(int compet_id) throws DataAccessException {
		Map<String, List<CompetFileVO>> competInfo = new HashMap<String, List<CompetFileVO>>();
		// 큰 포스터 가져오기
		List<CompetFileVO> competList = competDAO.selectCompetBigPoster(compet_id);
		competInfo.put("competBigPoster", competList);
		// 작은 포스터 가져오기
		competList = competDAO.selectCompetSmallPoster(compet_id);
		competInfo.put("competSmallPoster", competList);
		// 대회 아이디 가져오기
		competList = competDAO.selectCompet_id_file(compet_id);
		competInfo.put("compet_id", competList);
		return competInfo;

	}	
	

//대회 공지사항: 작은 포스터 가져오기
	@Override
	public List<CompetFileVO> CompetSmallPoster(int compet_id) throws DataAccessException {
		List<CompetFileVO> CompetSmallPoster = competDAO.selectCompetSmallPoster(compet_id);
		return CompetSmallPoster;
	}

	// 대회 리스트 아이디통해 이름 알아내기

	// 진행중인 대회 가져오기

	@Override
	public List<CompetVO> competListById(int i) throws Exception {
		List<CompetVO> competListByName = competDAO.selectCompetId(i);
		return competListByName;
	}


	@Override
	public List<CompetVO> competListByCategIdToThree(int i) throws Exception {
		return competDAO.selectCompetsByCategIdToThree(i);
	}

	// 종료된 대회 가져오기
	@Override
	public List<CompetVO> finishCompetList(int i) throws Exception {
		List<CompetVO> competListFinish = competDAO.selectFinishCompet(i);
		return competListFinish;
	}

	// 카테고리 이름을 통해 대회 이름 출력하기
	@Override
	public List<CompetVO> competListByName(int i) throws Exception {
		List<CompetVO> competNameByName = competDAO.selectCompetNameByName(i);
		return competNameByName;
	}


	// 대회 이름 가져오기
	@Override
	public List<CompetVO> CompetName() throws DataAccessException {
		List<CompetVO> competName = competDAO.selectCompetName();
		return competName;

	}

	// 대회 추가하기
	@Override
	public void addCompet(Map<String, Object> competMap) throws DataAccessException {
		int addCompet = competDAO.insertCompet(competMap);
		int addCompetFile = competDAO.insertCompetFile(competMap);
	}
	
	// 대회 아이디 가져오기
	@Override
	public int addCompetId() throws DataAccessException {
		int addCompetId = competDAO.selectAddCompetId();
		return addCompetId;
	}

	@Override
	public void competFinish(String compet_name) throws DataAccessException {
		competDAO.updateCompetTerminated(compet_name);

	}

	@Override
	public void competDelete(String compet_name) throws DataAccessException {
		competDAO.deleteCompet(compet_name);

	}


}
