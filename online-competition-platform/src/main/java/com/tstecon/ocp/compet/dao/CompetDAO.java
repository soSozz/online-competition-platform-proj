package com.tstecon.ocp.compet.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

<<<<<<< HEAD
import com.tstecon.ocp.compet.qna.vo.CompetQnaVO;
=======
import com.tstecon.ocp.categ.vo.CategVO;
>>>>>>> branch 'master' of https://github.com/ITHwang/online-competition-platform-proj.git
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

	

<<<<<<< HEAD

=======
// 문의 게시판 내용
	public List selectAllQnaList() throws DataAccessException;
	
	public int insertNewArticle(Map articleMap) throws DataAccessException;
>>>>>>> branch 'master' of https://github.com/ITHwang/online-competition-platform-proj.git

	public List<CompetVO> selectCompetId(int i) throws DataAccessException;




}
