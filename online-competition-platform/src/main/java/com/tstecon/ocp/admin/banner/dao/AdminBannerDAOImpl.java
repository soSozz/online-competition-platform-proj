package com.tstecon.ocp.admin.banner.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tstecon.ocp.banner.vo.BannerFileVO;

@Repository("adminBannerDAO")
public class AdminBannerDAOImpl implements AdminBannerDAO{
	@Autowired
	private SqlSession ss;
	
	public List	selectBannerName() {
		List<BannerFileVO> selectBannerName = new ArrayList();
		selectBannerName = ss.selectList("mappers.admin_Banner.selectAllBannerList");
		return selectBannerName;
	}
	

}
