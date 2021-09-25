package com.tstecon.ocp.compet.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tstecon.ocp.compet.vo.CompetFileVO;
import com.tstecon.ocp.compet.vo.CompetVO;


@Repository("CompetDAO")
public class CompetDAOImpl implements CompetDAO {

	@Autowired
	private SqlSession sqlSession;

//	대회안내 포스터
	// 큰 포스터
	@Override
	public List<CompetFileVO> selectCompetBigPoster(int compet_id) throws DataAccessException {
		List<CompetFileVO> competList = (ArrayList) sqlSession.selectList("mappers.compet.selectCompetBigPoster",
				compet_id);
		return competList;
	}

	public List<CompetFileVO> selectCompetSmallPoster(int compet_id) throws DataAccessException {
		List<CompetFileVO> competList = (ArrayList) sqlSession.selectList("mappers.compet.selectCompetSmallPoster",
				compet_id);
		return competList;
	}

//	대회안내 내용
	@Override
	public List<CompetVO> selectCompetInfo(int compet_id) throws DataAccessException {
		List<CompetVO> competList = (ArrayList) sqlSession.selectList("mappers.compet.selectCompetInfo", compet_id);
		return competList;
	}

//	대회 포스터 클릭
	@Override
	public List<CompetVO> selectCompet_id(int compet_id) throws DataAccessException {
		List<CompetVO> competList = (ArrayList) sqlSession.selectList("mappers.compet.selectCompet_id", compet_id);
		return competList;
	}

	@Override
	public List<CompetFileVO> selectCompet_id_file(int compet_id) throws DataAccessException {
		List<CompetFileVO> competList = (ArrayList) sqlSession.selectList("mappers.compet.selectCompet_id_file",
				compet_id);
		return competList;
	}


	@Override
	public List<CompetVO> selectCompetId(int i) throws DataAccessException {
		List<CompetVO> competNameList = (ArrayList) sqlSession.selectList("mappers.compet.selectCompetNames", i);
		return competNameList;
	}

	// 카테고리 아이디를 통해 진행중인 대회 리스트 3개 가져오기
	@Override
	public List<CompetVO> selectCompetsByCategIdToThree(int i) throws DataAccessException {
		return (ArrayList) sqlSession.selectList("mappers.compet.selectCompetsByCategIdToThree", i);
	}

	// 카테고리 아이디를 통해 종료된 대회 리스트 가져오기
	@Override
	public List<CompetVO> selectFinishCompet(int i) throws DataAccessException {
		List<CompetVO> competNameList = (ArrayList) sqlSession.selectList("mappers.compet.selectFinishCompet", i);
		return competNameList;
	}

	// 대회 이름 가져오기
	@Override
	public List<CompetVO> selectCompetName() throws DataAccessException {
		List<CompetVO> competName = (ArrayList) sqlSession.selectList("mappers.compet.selectCompetName");
		return competName;
	}

	// 카테고리 아이디을 통해 대회 이름 가져오기
	@Override
	public List<CompetVO> selectCompetNameByName(int i) throws DataAccessException {
		List<CompetVO> competName = (ArrayList) sqlSession.selectList("mappers.compet.selectCompetNameByName");
		return competName;
	}

	// 대회 추가하기
	@Override
	public int insertCompet(Map<String, Object> competMap) throws DataAccessException {
		int addCompet = sqlSession.insert("mappers.compet.insertCompet", competMap);
		return addCompet;
	}

	// 대회 파일 추가
	@Override
	public int insertCompetFile(Map<String, Object> competMap) throws DataAccessException {
		List<CompetFileVO> imageFileList = (ArrayList) competMap.get("imageFileList");
		int articleNO = (Integer) competMap.get("compet_id");
		int addCompetFile = 0;
		for (CompetFileVO competFileVO : imageFileList) {
			int imageFileNO = sqlSession.selectOne("mappers.compet.selectNewCompetFileId");
			competFileVO.setCompet_file_id(imageFileNO);
			addCompetFile = sqlSession.insert("mappers.compet.insertCompetFile", competFileVO);
		}

		return addCompetFile;
	}

	@Override
	public int selectAddCompetId() throws DataAccessException {
		int competId = sqlSession.selectOne("mappers.compet.selectNewCompetId");
		return competId;
	}

	//대회 종료하기
	@Override
	public int updateCompetTerminated(String compet_name) throws DataAccessException {
		int updateCompet = sqlSession.update("mappers.compet.updateCompetTerminated", compet_name);
		return updateCompet;
	}
	
	// 종료된 대회 삭제하기
	@Override
	public int deleteCompet(String compet_name) throws DataAccessException {
		return sqlSession.delete("mappers.compet.deleteCompet", compet_name);
	}
	
	// 카테고리 아이디를 통해 대회 리스트 가져오기
	@Override
	public List<CompetVO> selectCompetListByCategId(int categ_id) throws DataAccessException {
		List<CompetVO> competList = sqlSession.selectList("mappers.compet.selectCompetListByCategId", categ_id);
		return competList;
	}

}
