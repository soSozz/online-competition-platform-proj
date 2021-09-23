package com.tstecon.ocp.banner.service;

import java.util.List;

import com.tstecon.ocp.banner.vo.BannerFileVO;

public interface BannerService {

	public List<BannerFileVO> listBannerFiles() throws Exception;
}
