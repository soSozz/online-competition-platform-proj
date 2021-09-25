package com.tstecon.ocp.admin.categ.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.tstecon.ocp.admin.categ.dao.AdminCategDAO;
import com.tstecon.ocp.admin.categ.service.AdminCategService;
import com.tstecon.ocp.categ.vo.CategVO;
import com.tstecon.ocp.compet.service.CompetService;
import com.tstecon.ocp.compet.vo.CompetFileVO;
import com.tstecon.ocp.compet.vo.CompetVO;

@Controller("AdminCategController")
public class AdminCategControllerImpl implements AdminCategController {
	private static final String COMPET_IMAGE_REPO = "C:\\ocp\\competfile";

	@Autowired
	private AdminCategService adminCategService;

	@Autowired
	private CompetService competService;

	@Autowired
	private AdminCategDAO adminCategDAO;

	// 관리자 카테고리 기본 페이지 컨트롤러
	@Override
	@RequestMapping(value = { "/admin/admincateg.do" }, method = { RequestMethod.GET })
	public ModelAndView adminCateg(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);

		// Map<String, List<CompetVO> aa

		// 카테고리들 가져오기
		// List<String> categList = adminCategService.Categlist();

		// 반복하기
		// 각 카테고리에 해당하는 competVO들 가져오기
		// List<CompetVO> competList = competService.competListByName(카테고리이름);
		// aa.put("카테고리이름", competList);

		Map<String, List<CompetVO>> aa = new HashMap<String, List<CompetVO>>();
		Map<String, List<CompetVO>> bb = new HashMap<String, List<CompetVO>>();
		List<CategVO> categList = adminCategService.CategAllList();
		// List<CategVO> categList = ...

		// 진행중인 대회 가져오기
		for (CategVO i : categList) {
			List<CompetVO> competList = competService.competListById(i.getCateg_id());
			// ... = competService.competListByCategId(i.categ_id);
			aa.put(i.getCateg_name(), competList);
			// aa.put(i.categ_name, competList);
		}
		mav.addObject("competInCateg", aa);

		// 종료된 대회 가져오기
		for (CategVO i : categList) {
			List<CompetVO> competList = competService.finishCompetList(i.getCateg_id());
			// ... = competService.competListByCategId(i.categ_id);
			bb.put(i.getCateg_name(), competList);
			// aa.put(i.categ_name, competList);
		}
		mav.addObject("finishCompet", bb);
		return mav;
	}

	// 관리자 카테고리 편집 페이지 컨트롤러 -->> 나중에 학원에서 고치기
	@Override
	@RequestMapping(value = { "/admin/addCategForm.do" }, method = { RequestMethod.GET })
	public ModelAndView addCategForm(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}

	// 대회 추가
	@Override
	@RequestMapping(value = { "/admin/addCompet.do" }, method = { RequestMethod.POST })
	public ResponseEntity addCompet(@RequestParam Map<String, Object> competMap,
			MultipartHttpServletRequest multipartRequest, HttpServletResponse reponse) throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");

		int compet_id = competService.addCompetId(); // 추가될 대회의 id 가져오기
		int categ_id = adminCategService.addCompet(competMap); // 추가될 대회의 카테고리의 id 가져오기
		competMap.put("compet_id", compet_id);
		competMap.put("categ_id", categ_id);

		List<CompetFileVO> imageFileList = new ArrayList<CompetFileVO>(); // competfile table에 insert할 때 필요한 리스트
		Iterator<String> fileNames = multipartRequest.getFileNames(); // file type에 해당하는 input 태그의 name값 가져오기 ex)
																		// BigPoster, SmallPoster

		while (fileNames.hasNext()) { // fileName이 있으면

			String fileName = fileNames.next(); // fileName 꺼내기
			MultipartFile mFile = multipartRequest.getFile(fileName); // fileName으로 지정된 input 태그에 저장되었던 파일 가져오기
			String mFileName = mFile.getOriginalFilename(); // 파일의 이름
			String mFileExtension = mFileName.substring(mFileName.indexOf('.')); // 파일의 확장자명 ex) .jpg, .png 등

			// 형식에 맞는 이름으로 파일 이름 바꾸기
			String updatedFileName = null;
			if (fileName.equals("BigPoster")) {
				updatedFileName = competMap.get("compet_name") + "-big" + mFileExtension;
			} else {
				updatedFileName = competMap.get("compet_name") + "-small" + mFileExtension;
			}

			// 파일 VO 만들어서 세팅 후 리스트에 추가
			CompetFileVO competFileVO = new CompetFileVO();
			competFileVO.setCompet_file_name(updatedFileName);
			competFileVO.setCompet_file_type("img");
			competFileVO.setCompet_id((Integer) competMap.get("compet_id"));
			// competDAOImpl.insertCompetFile()에서 setCompet_file_id할 예정
			imageFileList.add(competFileVO);

			// 하드디스크에 파일 저장
			File file = new File(COMPET_IMAGE_REPO + "\\" + String.valueOf(competMap.get("compet_id")) + "\\img\\"
					+ updatedFileName);
			if (mFile.getSize() != 0) { // File Null Check
				if (!file.exists()) { // 경로상에 파일이 존재하지 않을 경우
					file.getParentFile().mkdirs(); // 경로에 해당하는 디렉토리들을 생성
					// 임시로 저장된 multipartFile을 실제 파일로 전송
					mFile.transferTo(file);
				}
			}
		}

		// DB에 파일 저장
		competMap.put("imageFileList", imageFileList);
		competService.addCompet(competMap); // compet table, compet file table에 추가

		// 리디렉트
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");

		message = "<script>";
		message += " alert('대회을 추가했습니다');";
		message += " location.href='" + multipartRequest.getContextPath() + "/admin/admincateg.do'; ";
		message += " </script>";
		resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

		return resEnt;
	}

	// 대회 종료
	@Override
	@RequestMapping(value = { "/admin/competFinish.do" }, method = { RequestMethod.GET })
	public ModelAndView competFinish(@RequestParam("compet_name") String compet_name, HttpServletRequest request,
			HttpServletResponse reponse) throws Exception {
		ModelAndView mav = new ModelAndView();
		competService.competFinish(compet_name);
		mav.setViewName("redirect:/admin/admincateg.do");
		return mav;
	}

	// 종료된 대회 삭제
	@Override
	@RequestMapping(value = { "/admin/competDelete.do" }, method = { RequestMethod.GET })
	public ModelAndView competDelete(@RequestParam("compet_name") String compet_name, HttpServletRequest request,
			HttpServletResponse reponse) throws Exception {
		ModelAndView mav = new ModelAndView();
		competService.competDelete(compet_name);
		mav.setViewName("redirect:/admin/admincateg.do");
		return mav;
	}

//	private List<String> upload(MultipartHttpServletRequest multipartRequest) throws Exception {
////		CompetVO competVO = new CompetVO();
////		int compet_id = competVO.getCompet_id();
//		List<String> fileList = new ArrayList<String>();
//		Iterator<String> fileNames = multipartRequest.getFileNames();
//		while (fileNames.hasNext()) {
//			String fileName = fileNames.next();
//			MultipartFile mFile = multipartRequest.getFile(fileName);
//			String originalFileName = mFile.getOriginalFilename();
//			fileList.add(originalFileName);
//			File file = new File(COMPET_IMAGE_REPO + "\\" + compet_id + "\\img\\temp\\" + fileName);
//			if (mFile.getSize() != 0) { // File Null Check
//				if (!file.exists()) { // 경로상에 파일이 존재하지 않을 경우
//					file.getParentFile().mkdirs(); // 경로에 해당하는 디렉토리들을 생성
//					mFile.transferTo(new File(
//							COMPET_IMAGE_REPO + "\\" + "competfile" + "\\" + /* compet_id + */"\\" + originalFileName)); // 임시로
//																															// 저장된
//																															// multipartFile을
//																															// 실제
//																															// 파일로
//																															// 전송
//				}
//			}
//		}
//		return fileList;
//	}

}
