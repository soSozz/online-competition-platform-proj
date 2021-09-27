package com.tstecon.ocp.admin.banner.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.admin.banner.dao.AdminBannerDAO;

@Service("adminBannerService")
public class AdminBannerServiceImpl implements AdminBannerService{
	@Autowired
	private AdminBannerDAO adminBannerDAO;
	
	
	 public List selectBannerName() {
		 List bannerList = new ArrayList();
		 bannerList = adminBannerDAO.selectBannerName();
		 
		 
		 
		 
		 return bannerList;
		 
		 
	 }
	

	
}
