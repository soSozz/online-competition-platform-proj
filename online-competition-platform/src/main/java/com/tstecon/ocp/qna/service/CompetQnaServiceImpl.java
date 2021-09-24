package com.tstecon.ocp.qna.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.qna.dao.CompetQnaDAO;
import com.tstecon.ocp.qna.vo.CompetQnaVO;

@Service("CompetQnaService")
public class CompetQnaServiceImpl implements CompetQnaService {
	@Autowired
	private CompetQnaDAO competQnaDAO;
	


//문의 게시판
	@Override
	public List<CompetQnaVO> qnalistArticles() throws Exception {
		List<CompetQnaVO> qnaList = competQnaDAO.selectAllQnaList();
		return qnaList;
	}
//로그인
	@Override
	public CompetQnaVO login(CompetQnaVO competqnaVO) throws Exception {
		return competQnaDAO.quaLogin(competqnaVO);
	}
//글 쓰기 추가
	@Override
	public int addNewArticle(Map articleMap) throws Exception {
		Iterator<String> keys = articleMap.keySet().iterator();

		System.out.println("service의 map");
		while (keys.hasNext()) {
			String key = keys.next();
			System.out.println(String.format("키 : %s, 값 : %s", key, articleMap.get(key)));
		}
		return competQnaDAO.insertNewArticle(articleMap);
	}
//상세 페이지 보기
	public CompetQnaVO viewArticle(int articleNO) throws Exception {
		CompetQnaVO articleVO = competQnaDAO.selectQnaArticle(articleNO);
		return articleVO;
	}
//문의 글 수정	
		public void modArticle(Map articleMap) throws Exception{
			competQnaDAO.updateArticle(articleMap);
		}
//문의 글 삭제		
		public void removeArticle(int articleNO) throws Exception{
			competQnaDAO.deleteArticle(articleNO);
		}

}
