package com.tstecon.ocp.qna.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tstecon.ocp.qna.vo.CompetQnaVO;

public interface CompetQnaController {

//문의 페이지
	public ModelAndView Compet_qna_list(@RequestParam("compet_id") int compet_id,HttpServletRequest request, HttpServletResponse response) throws Exception;

//문의 글쓰기창 로그인, 로그아웃
	public ModelAndView Compet_qna_login(@ModelAttribute("member") CompetQnaVO competqnaVO, RedirectAttributes rAttr,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView Compet_qna_logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
//문의 글쓰기 추가
	public ResponseEntity addNewArticle(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception;
//문의 상세창 보기
	public ModelAndView viewArticle(@RequestParam("articleNO") int articleNO, HttpServletRequest request,
			HttpServletResponse response) throws Exception;
//문의 글 수정
	public ResponseEntity modArticle(MultipartHttpServletRequest multipartRequest,  HttpServletResponse response) throws Exception;
//문의  글 삭제	
	public ResponseEntity  removeArticle(@RequestParam("articleNO") int articleNO, HttpServletRequest request, HttpServletResponse response) throws Exception;
//문의 답변 글쓰기 추가
		public ResponseEntity replyAddNewArticle(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
				throws Exception;	

	
	
	
	
}


