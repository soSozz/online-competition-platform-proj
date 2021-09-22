package com.tstecon.ocp.categ.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tstecon.ocp.categ.dao.CategDAO;
import com.tstecon.ocp.categ.vo.CategVO;

@Service("categService")
public class CategServiceImpl implements CategService {
	@Autowired
	private CategDAO categDAO;

	@Override
	public List<CategVO> listCategs() throws Exception {
		return categDAO.selectCategList();
	}

}
