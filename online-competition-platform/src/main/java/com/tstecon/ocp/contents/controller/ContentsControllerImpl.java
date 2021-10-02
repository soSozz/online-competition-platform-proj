package com.tstecon.ocp.contents.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.tstecon.ocp.contents.service.ContentsService;
import com.tstecon.ocp.contents.vo.ContentsFileVO;
import com.tstecon.ocp.contents.vo.ContentsVO;
import com.tstecon.ocp.contents.vo.ListContentsVO;
import com.tstecon.ocp.member.vo.MemberVO;

@Controller("contentsController")
public class ContentsControllerImpl implements ContentsController {
	private static final String CONTENTS_IMAGE_IN_TEXT = "C:\\ocp\\contentsfile\\img_in_text";

	@Autowired
	private ContentsService contentsService;

	@Autowired
	private ContentsFileVO contentsFileVO;

	@Autowired
	private ContentsVO contentsVO;

	@Override
	@RequestMapping(value = { "/contents/contentsForm.do" }, method = { RequestMethod.GET })
	public ModelAndView contentsForm(@RequestParam("compet_id") int compet_id,
			HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		HttpSession session = request.getSession();
		
		mav.addObject("mem_id", ((MemberVO)session.getAttribute("loginInfo")).getMem_id());
		mav.addObject("compet_id", compet_id);
		return mav;
	}

	// 컨텐츠 작성 시 삽입되는 이미지들을 DB와 스토리지에 저장
	@Override
	@RequestMapping(value = { "/contents/uploadImgInText.do" }, method = { RequestMethod.POST })
	public @ResponseBody String upload(@RequestBody String jsonMap, HttpServletRequest request,
			HttpServletResponse reponse) throws Exception {
		request.setCharacterEncoding("utf-8");

		Map<String, String> imageMap = new Gson().fromJson(jsonMap, Map.class);
		String base64 = imageMap.get("base64");
		String fileName = imageMap.get("fileName");
		String ext = (imageMap.get("ext") == "jpeg") ? "jpg" : imageMap.get("ext");
		byte[] binary = Base64.getDecoder().decode(base64);

		// 추가될 compet 파일의 id 가져오기
		int contents_file_id = contentsService.newContentsFileId();

		contentsFileVO.setContents_file_id(contents_file_id);
		contentsFileVO.setContents_file_name(fileName);
		contentsFileVO.setContents_file_type("img");

		File outFile = new File(CONTENTS_IMAGE_IN_TEXT + "\\" + String.valueOf(contents_file_id) + "\\" + fileName);
		if (!outFile.exists()) {
			// 하드디스크에 파일 저장
			try {
				if (!outFile.getParentFile().exists()) {
					outFile.getParentFile().mkdirs();
				}
				FileOutputStream fileOutputStream = new FileOutputStream(outFile);
				fileOutputStream.write(binary);
				fileOutputStream.close();

			} catch (Throwable e) {
				e.printStackTrace(System.out);
			}
		}

		// DB에 파일 저장(contents_id 칼럼은 null)
		contentsService.addNewContentsFile(contentsFileVO);

		return String.valueOf(contents_file_id);
	}

	// 컨텐츠 조회 시 텍스트 내 삽입되어 있는 이미지 불러오기
//	@Override
	@RequestMapping(value = { "/contents/downloadImgInText.do" }, method = { RequestMethod.GET })
	public void download(@RequestParam("contents_file_id") int contents_file_id,
			@RequestParam("fileName") String fileName, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");

		OutputStream out = response.getOutputStream();
		String filePath = CONTENTS_IMAGE_IN_TEXT + "\\" + String.valueOf(contents_file_id) + "\\" + fileName;
		File image = new File(filePath);

		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment;");
		FileInputStream in = new FileInputStream(image);
		byte[] buffer = new byte[1024 * 8];
		while (true) {
			int count = in.read(buffer); // 버퍼에 읽어들인 문자개수
			if (count == -1) // 버퍼의 마지막에 도달했는지 체크
				break;
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
	}

	// 컨텐츠 게시판
	@Override
	@RequestMapping(value = { "/contents/listContents.do" }, method = { RequestMethod.GET })
	public ModelAndView listContents(@RequestParam("compet_id") int compet_id, HttpServletRequest request,
			HttpServletResponse reponse) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);

		//댓글, 좋아요 뺀 리스트 정보 가져오기
		List<ListContentsVO> contentsList = contentsService.listContents(compet_id);

		// 대회 아이디 저장
		mav.addObject("compet_id", compet_id);
		// 댓글, 좋아요 뺀 리스트 정보 저장
		mav.addObject("listContents", contentsList);

		return mav;
	}

//	@Override
	@RequestMapping(value = { "/contents/addContents.do" }, method = { RequestMethod.POST })
	public ResponseEntity listContents(@RequestParam HashMap<String, String> contentsMap, HttpServletRequest request,
			HttpServletResponse reponse) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);

		contentsVO.setCompet_id(Integer.parseInt(contentsMap.get("compet_id")));
		contentsVO.setContents_name(contentsMap.get("contents_name"));
		contentsVO.setContents_text(contentsMap.get("contents_text"));
		contentsVO.setContents_state("제출완료");
		contentsVO.setMem_id(contentsMap.get("mem_id"));

		int contents_id = contentsService.addNewContents(contentsVO); // 컨텐츠 추가한 후 contents_id 반환

		// 미리 저장되어 있던 파일들의 contents_id를 업데이트
		String contents_file_list_string = contentsMap.get("constents_file_list");
		contents_file_list_string = contents_file_list_string.substring(0, contents_file_list_string.length() - 1);
		List<String> contents_file_list = Arrays.asList(contents_file_list_string.split(","));
		contentsService.addContentsIdToFiles(contents_file_list, contents_id);

		String message = "<script>";
		message += "alert('컨텐츠가 제출되었습니다');";
		message += "location.href='" + request.getContextPath() + "/compet/competInfo.do?compet_id="
				+ contentsMap.get("compet_id") + "';";
		message += ("</script>");

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");

		ResponseEntity resEntity = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}

	// 컨텐츠 자세히 보기
	@Override
	@RequestMapping(value = { "/contents/contentsView.do" }, method = { RequestMethod.GET })
	public ModelAndView contentsView(@RequestParam("contents_id") int contents_id, HttpServletRequest request, HttpServletResponse reponse)
			throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		// 클릭 시 조회 수 증가
		contentsService.updateContentsView(contents_id);
		
		// 댓글 제외 리스트 저장
		List<ListContentsVO> contentsView = contentsService.selectContentsView(contents_id);
		
		// 댓글 리스트 저장
		List<ListContentsVO> contentsCmt = contentsService.selectContentsCmt(contents_id);
		
		// 컨텐츠 파일 리스트 저장
		List<ContentsFileVO> contentsFileView = contentsService.selectContentsFile(contents_id);
		
		mav.addObject("contentsView", contentsView);
		mav.addObject("contentsCmt", contentsCmt);
		mav.addObject("contentsFileView", contentsFileView);
		return mav;
	}
	
	

}
