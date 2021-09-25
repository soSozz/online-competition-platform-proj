package com.tstecon.ocp.compet.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.compet.vo.CompetFileVO;
import com.tstecon.ocp.compet.vo.CompetVO;

public interface CompetDAO {
//	대회안내 포스터
	// 큰 포스터
	public List<CompetFileVO> selectCompetBigPoster(int compet_id) throws DataAccessException;

	// 작은 포스터
	public List<CompetFileVO> selectCompetSmallPoster(int compet_id) throws DataAccessException;

//	대회안내 내용
	public List<CompetVO> selectCompetInfo(int compet_id) throws DataAccessException;

//	대회 포스터 클릭
	public List<CompetVO> selectCompet_id(int compet_id) throws DataAccessException;

	public List<CompetFileVO> selectCompet_id_file(int compet_id) throws DataAccessException;

	// 카테고리 아이디를 통해 진행중인 대회 리스트 출력

	public List<CompetVO> selectCompetId(int i) throws DataAccessException;

	// 카테고리 아이디를 통해 진행중인 대회 리스트 3개 출력
	public List<CompetVO> selectCompetsByCategIdToThree(int i) throws DataAccessException;

	// 카테고리 아이디를 통해 종료된 대회 리스트 출력
	public List<CompetVO> selectFinishCompet(int i) throws DataAccessException;

	public List<CompetVO> selectCompetName() throws DataAccessException;

	// 카테고리 아이디를 통해 대회 이름만 출력
	public List<CompetVO> selectCompetNameByName(int i) throws DataAccessException;

	// 대회 추가
	public int insertCompet(Map<String, Object> competMap) throws DataAccessException;

	// 대회 파일 추가
	public int insertCompetFile(Map<String, Object> competMap) throws DataAccessException;

	public int selectAddCompetId() throws DataAccessException;

	public void updateCompetTerminated(String compet_name) throws DataAccessException;

	public void deleteCompet(String compet_name) throws DataAccessException;

}
