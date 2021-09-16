package com.tstecon.ocp.compet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;




import com.tstecon.ocp.compet.vo.CompetFileVO;
import com.tstecon.ocp.compet.vo.CompetVO;


public interface CompetDAO {
//	대회안내 포스터
	public List<CompetVO> selectCompetPoster(int compet_id) throws DataAccessException;
//	대회안내 내용
	public List<CompetVO> selectCompetInfo(int Compet_id) throws DataAccessException;
//	대회 포스터 클릭
	public List<CompetVO> selectCompet_id(int Compet_id) throws DataAccessException;
	
	
// 문의 게시판 내용
	public List selectAllQnaList() throws DataAccessException;

}
