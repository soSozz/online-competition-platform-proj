package com.tstecon.ocp.banner.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tstecon.ocp.banner.vo.BannerFileVO;

@Repository("bannerDAO")
public class BannerDAOImpl implements BannerDAO {
	@Autowired
	private SqlSession sqlSession;

	@Autowired
	private BannerFileVO bannerFileVO;

	@Override
	public List<BannerFileVO> selectAllBannerFiles() throws DataAccessException {
		return sqlSession.selectList("mappers.banner.selectAllBannerFilesWithName");
	}

}
