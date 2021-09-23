package com.tstecon.ocp.banner.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tstecon.ocp.banner.vo.BannerFileVO;

public interface BannerDAO {

	public List<BannerFileVO> selectAllBannerFiles() throws DataAccessException;

}
