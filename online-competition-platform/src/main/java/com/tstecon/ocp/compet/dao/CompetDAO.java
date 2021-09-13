package com.tstecon.ocp.compet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

<<<<<<< HEAD

=======
import com.tstecon.ocp.compet.vo.CompetFileVO;
>>>>>>> branch 'master' of https://github.com/ITHwang/online-competition-platform-proj.git
import com.tstecon.ocp.compet.vo.CompetVO;


public interface CompetDAO {
//	대회안내 포스터
	public List<CompetVO> selectCompetPoster(String compet_id) throws DataAccessException;
//	대회안내 내용
	public List<CompetVO> selectCompetInfo(String Compet_id) throws DataAccessException;
<<<<<<< HEAD
// 문의 게시판 내용
	public List selectAllQnaList() throws DataAccessException;
=======
	public CompetFileVO selectCompetSmallPoster(String Compet_id) throws DataAccessException;
>>>>>>> branch 'master' of https://github.com/ITHwang/online-competition-platform-proj.git
}
