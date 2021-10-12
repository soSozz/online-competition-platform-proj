package com.tstecon.ocp.admin.categ.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.admin.categ.dao.AdminCategDAO;
import com.tstecon.ocp.categ.vo.CategVO;

@Service("adminCategService")
public class AdminCategServiceImpl implements AdminCategService {

	@Autowired
	private AdminCategDAO adminCategDAO;

	@Override
	public List<CategVO> CategAllList() throws DataAccessException {
//		Map<String,List<CategVO>>categList=new HashMap<String,List<CategVO>>();
		List<CategVO> categList = adminCategDAO.selectCategAllList();
//		categList.put("categList", categ);
		return categList;
	}

	@Override
	public List<CategVO> categName() throws DataAccessException {
		List<CategVO> categName = adminCategDAO.selectCategName();
		return categName;
	}

	@Override
	public int addCompet(Map<String, Object> addCompetMap) throws DataAccessException {
//		addCompetMap.put("categ_id", categ_id);
		int addCompet = adminCategDAO.selectCategIdByName(addCompetMap);
		return addCompet;
		
	}
	//카테고리 삭제
	@Override
	public void deleteCateg(String categ_name) throws DataAccessException {
		adminCategDAO.deleteCategByName(categ_name);
		
	}
	//카테고리 이름을 통해 아이디 가져오기
	@Override
	public int CategIdByName(String categ_name) throws DataAccessException {
		int categ_id = adminCategDAO.selectcategIdByName(categ_name);
		return categ_id;
	}
	// 카테고리 아이디 + 1
	@Override
	public int categPlusId() throws DataAccessException {
		int categ_id = adminCategDAO.selectCategPlusId();
		return categ_id;
	}
	// 카테고리 추가
	@Override
	public void addCateg(Map map) throws DataAccessException {
		adminCategDAO.insertCateg(map);
		return;
	}

}
