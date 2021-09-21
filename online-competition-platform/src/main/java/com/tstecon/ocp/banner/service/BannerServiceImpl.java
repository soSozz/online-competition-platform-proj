package com.tstecon.ocp.banner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.banner.dao.BannerDAO;
import com.tstecon.ocp.banner.vo.BannerFileVO;

@Service("bannerService")
public class BannerServiceImpl implements BannerService {
	@Autowired
	private BannerDAO bannerDAO;

	@Override
	public List<BannerFileVO> listBannerFiles() throws Exception {
		return bannerDAO.selectAllBannerFiles();
	}

}
