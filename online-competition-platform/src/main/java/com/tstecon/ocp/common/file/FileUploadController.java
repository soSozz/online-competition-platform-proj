package com.tstecon.ocp.common.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {
	private static final String CURR_IMAGE_REPO_PATH = "\\home\\ubuntu\\ocp";

	@RequestMapping(value = "/form")
	public String form() {
		return "uploadForm";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView upload(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		// 매개변수 정보와 파일 정보를 저장할 Map을 생성합니다.
		Map map = new HashMap();

		Enumeration enu = multipartRequest.getParameterNames();

		// 전송된 매개변수 값을 key/value로 map에 저장합니다.
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = multipartRequest.getParameter(name);
			map.put(name, value);
		}
		// 파일을 업로드한 후 반환된 파일 이름이 저장된 fileList를 다시 map에 저장합니다.
		List fileList = fileProcess(multipartRequest);
		map.put("fileList", fileList);

		ModelAndView mav = new ModelAndView();

		// map을 결과창으로 포워딩합니다.
		mav.addObject("map", map);
		mav.setViewName("result");
		return mav;
	}

	private List<String> fileProcess(MultipartHttpServletRequest multipartRequest) throws Exception {
		List<String> fileList = new ArrayList<String>();

		// 첨부된 파일 이름을 가져옵니다.
		Iterator<String> fileNames = multipartRequest.getFileNames();

		while (fileNames.hasNext()) {
			String fileName = fileNames.next();

			// 파일 이름에 대한 MultipartFile 객체를 가져옵니다.
			MultipartFile mFile = multipartRequest.getFile(fileName);

			// 실제 파일 이름을 가져옵니다.
			String originalFileName = mFile.getOriginalFilename();

			// 파일 이름을 하나씩 fileList에 저장합니다.
			fileList.add(originalFileName);

			File file = new File(CURR_IMAGE_REPO_PATH + "\\" + fileName);

			// 첨부된 파일이 있는지 체크합니다.
			if (mFile.getSize() != 0) {
				if (!file.exists()) {
					if (file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				// 임시로 저장된 multipartFile을 실제 파일로 전송합니다.
				mFile.transferTo(new File(CURR_IMAGE_REPO_PATH + "\\" + originalFileName));
			}
		}
		// 첨부한 파일 이름이 저장된 fileList를 반환합니다.
		return fileList;
	}
}
