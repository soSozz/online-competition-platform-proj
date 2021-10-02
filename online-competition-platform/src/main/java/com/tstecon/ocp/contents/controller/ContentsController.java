package com.tstecon.ocp.contents.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

public interface ContentsController {

// 제출 페이지
	public ModelAndView contentsForm(@RequestParam("compet_id") int compet_id, @RequestParam("mem_id") int mem_id,
			HttpServletRequest request, HttpServletResponse reponse) throws Exception;

// 컨텐츠 작성 시 삽입되는 이미지들을 DB와 스토리지에 저장
	public @ResponseBody String upload(@RequestBody String jsonMap, HttpServletRequest request,
			HttpServletResponse reponse) throws Exception;

	public void download(@RequestParam("contents_file_id") int contents_file_id,
			@RequestParam("fileName") String fileName, HttpServletRequest request,
			HttpServletResponse reponse) throws Exception;

	// 컨텐츠 게시판
	public ModelAndView listContents(@RequestParam("compet_id") int compet_id, HttpServletRequest request,
			HttpServletResponse reponse) throws Exception;
	
	// 컨텐츠 자세히 보기
	public ModelAndView contentsView(@RequestParam("contents_id") int contents_id, HttpServletRequest request,
			HttpServletResponse reponse) throws Exception;
}
