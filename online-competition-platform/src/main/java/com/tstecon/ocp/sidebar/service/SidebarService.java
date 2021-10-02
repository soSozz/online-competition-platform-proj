package com.tstecon.ocp.sidebar.service;

import java.util.List;
import java.util.Map;

import com.tstecon.ocp.sidebar.vo.SidebarVO;

public interface SidebarService {

	public Map<String, List<SidebarVO>> listRankings() throws Exception;
}
