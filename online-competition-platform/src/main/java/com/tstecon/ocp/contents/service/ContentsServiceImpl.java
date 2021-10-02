package com.tstecon.ocp.contents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.contents.dao.ContentsDAO;
import com.tstecon.ocp.contents.vo.ContentsFileVO;
import com.tstecon.ocp.contents.vo.ContentsVO;
import com.tstecon.ocp.contents.vo.ListContentsVO;

@Service("contentsService")
public class ContentsServiceImpl implements ContentsService {

	@Autowired
	private ContentsDAO contentsDAO;

	@Override
	public int newContentsFileId() throws Exception {
		return contentsDAO.selectNewContentsFileId();
	}

	@Override
	public void addNewContentsFile(ContentsFileVO contentsFileVO) throws Exception {
		contentsDAO.insertNewContentsFile(contentsFileVO);
	}
	
	//게시판 리스트 생성
	@Override
	public List<ListContentsVO> listContents(int compet_id) throws DataAccessException {
		List<ListContentsVO> listContents = contentsDAO.listContents(compet_id);
		System.out.println("리스트 : " + listContents);
		return listContents;
	}
	
	// 클릭 시 조회수 1증가
	@Override
	public void updateContentsView(int contents_id) throws DataAccessException {
		contentsDAO.updateContentsView(contents_id);
		return;
		
	}
	
	// 컨텐츠 정보 저장
	@Override
	public List<ListContentsVO> selectContentsView(int contents_id) throws DataAccessException {
		List<ListContentsVO> contentsView = contentsDAO.selectContentsView(contents_id);
		return contentsView;
	}
	// 컨텐츠 댓글 리스트 저장
	@Override
	public List<ListContentsVO> selectContentsCmt(int contents_id) throws DataAccessException {
		List<ListContentsVO> contentsCmt = contentsDAO.selectContentsCmt(contents_id);
		return contentsCmt;
	}
	// 컨텐츠 파일 저장
	@Override
	public List<ContentsFileVO> selectContentsFile(int contents_id) throws DataAccessException {
		List<ContentsFileVO> contentsFile = contentsDAO.selectContentsFile(contents_id);
		return contentsFile;
	}

	@Override
	public int addNewContents(ContentsVO contentsVO) throws DataAccessException {
		return contentsDAO.insertNewContents(contentsVO);
	}

	// contents file들에 contents id 추가
	@Override
	public void addContentsIdToFiles(List<String> contents_file_list, int contents_id) throws DataAccessException {
		contentsDAO.updateContentsFiles(contents_file_list, contents_id);
	}
	// 컨텐츠 댓글 카운트
	@Override
	public List<ListContentsVO> listContentsCmt(int compet_id) throws DataAccessException {
		List<ListContentsVO> contentsCmtList = contentsDAO.selectContentsCmtList(compet_id);
		return contentsCmtList;
	}
	// 컨텐츠 좋아요 카운트
	@Override
	public List<ListContentsVO> listContentsLikes(int compet_id) throws DataAccessException {
		List<ListContentsVO> contentsLikesList = contentsDAO.selectContentsLikesList(compet_id);
		return contentsLikesList;
	}

}
