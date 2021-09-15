package com.tstecon.ocp.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileDownloadController {
	private static String CURR_IMAGE_REPO_PATH = "C:\\ocp";

	@RequestMapping("/bannerFile_download")
	protected void bannerFile_download(@RequestParam("banner_file_name") String banner_file_name, @RequestParam("banner_file_type") String banner_file_type, @RequestParam("banner_id") String banner_id,
			HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath = CURR_IMAGE_REPO_PATH + "\\bannerfile\\" + banner_id + "\\"+ banner_file_type + "\\" + banner_file_name;
		File image = new File(filePath);

		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; banner_file_name=" + banner_file_name);
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
	
	@RequestMapping("/competFile_download")
	protected void competFile_download(@RequestParam("compet_file_name") String compet_file_name, @RequestParam("compet_file_type") String compet_file_type, @RequestParam("compet_id") int compet_id,
			HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath = CURR_IMAGE_REPO_PATH + "\\competfile\\" + compet_id + "\\" + compet_file_type + "\\" + compet_file_name;
		File image = new File(filePath);

		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; compet_file_name=" + compet_file_name);
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
	
	@RequestMapping("/competNoticeFile_download")
	protected void competNoticeFile_download(@RequestParam("compet_notice_file_name") String compet_notice_file_name, @RequestParam("compet_notice_file_type") String compet_notice_file_type, @RequestParam("compet_notice_id") int compet_notice_id,
			HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath = CURR_IMAGE_REPO_PATH + "\\competnoticefile\\" + compet_notice_id + "\\" + compet_notice_file_type + "\\" + compet_notice_file_name;
		File image = new File(filePath);

		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; compet_notice_file_name=" + compet_notice_file_name);
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
	
	@RequestMapping("/contentsFile_download")
	protected void contentsFile_download(@RequestParam("contents_file_name") String contents_file_name, @RequestParam("contents_file_type") String contents_file_type, @RequestParam("contents_id") int contents_id,
			HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath = CURR_IMAGE_REPO_PATH + "\\contentsfile\\" + contents_id + "\\" + contents_file_type + "\\" + contents_file_name;
		File image = new File(filePath);

		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; contents_file_name=" + contents_file_name);
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
	
	@RequestMapping("/mainNoticeFile_download")
	protected void mainNoticeFile_download(@RequestParam("main_notice_file_name") String main_notice_file_name, @RequestParam("main_notice_file_type") String main_notice_file_type, @RequestParam("main_notice_id") int main_notice_id,
			HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath = CURR_IMAGE_REPO_PATH + "\\mainnoticefile\\" + main_notice_id + "\\" + main_notice_file_type + "\\" + main_notice_file_name;
		File image = new File(filePath);

		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; main_notice_file_name=" + main_notice_file_name);
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
	
	@RequestMapping("/memberFile_download")
	protected void memberFile_download(@RequestParam("member_file_name") String member_file_name,@RequestParam("member_file_type") String member_file_type, @RequestParam("member_id") String member_id,
			HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath = CURR_IMAGE_REPO_PATH + "\\memberfile\\" + member_id + "\\" + member_file_type + "\\" + member_file_name;
		File image = new File(filePath);

		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; member_file_name=" + member_file_name);
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

	// 썸네일 필요할 때 라이브러리 임포트해서 사용
//	@RequestMapping("/thumbnails.do")
//	protected void thumbnails(@RequestParam("fileName") String fileName, @RequestParam("goods_id") String goods_id,
//			HttpServletResponse response) throws Exception {
//		OutputStream out = response.getOutputStream();
//		String filePath = CURR_IMAGE_REPO_PATH + "\\" + goods_id + "\\" + fileName;
//		File image = new File(filePath);
//
//		if (image.exists()) {
//			Thumbnails.of(image).size(121, 154).outputFormat("png").toOutputStream(out);
//		}
//		byte[] buffer = new byte[1024 * 8];
//		out.write(buffer);
//		out.close();
//	}
}
