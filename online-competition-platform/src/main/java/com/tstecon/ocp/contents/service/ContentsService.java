package com.tstecon.ocp.contents.service;

import com.tstecon.ocp.contents.vo.ContentsFileVO;

public interface ContentsService {

	public int newContentsFileId() throws Exception;

	public void addNewContentsFile(ContentsFileVO contentsFileVO) throws Exception;
}
