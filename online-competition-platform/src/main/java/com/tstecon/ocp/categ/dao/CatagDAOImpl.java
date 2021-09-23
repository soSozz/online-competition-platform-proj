package com.tstecon.ocp.categ.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tstecon.ocp.categ.vo.CategVO;

@Repository("categDAO")
public class CatagDAOImpl implements CategDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<CategVO> selectCategList() {
		List<CategVO> categList = (ArrayList) sqlSession.selectList("mappers.categ.selectAllCateg");
		return categList;
	}

}
