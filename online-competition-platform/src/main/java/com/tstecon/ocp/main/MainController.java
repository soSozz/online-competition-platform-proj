package com.tstecon.ocp.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tstecon.ocp.banner.service.BannerService;
import com.tstecon.ocp.banner.vo.BannerFileVO;
import com.tstecon.ocp.categ.service.CategService;
import com.tstecon.ocp.categ.vo.CategVO;
import com.tstecon.ocp.common.base.BaseController;
import com.tstecon.ocp.compet.service.CompetService;
import com.tstecon.ocp.compet.vo.CompetVO;
import com.tstecon.ocp.sidebar.service.SidebarService;
import com.tstecon.ocp.sidebar.vo.SidebarVO;

@Controller("mainController")
@EnableAspectJAutoProxy
public class MainController extends BaseController {
	@Autowired
	private BannerService bannerService;
	@Autowired
	private CategService categService;
	@Autowired
	private CompetService competService;
	@Autowired
	private SidebarService sidebarService;

	@RequestMapping(value = { "/main/main.do" }, method = { RequestMethod.GET })
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");

		List<BannerFileVO> bannerFileList = bannerService.listBannerFiles();

		List<CategVO> categList = categService.listCategs();
		Map<String, List<CompetVO>> competsMap = new HashMap<String, List<CompetVO>>();

		for (CategVO c : categList) {
			List<CompetVO> competList = competService.competListByCategIdToThree(c.getCateg_id());
			competsMap.put(c.getCateg_name(), competList);
		}

		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("bannerFileList", bannerFileList);
		mav.addObject("competsMap", competsMap);

		Map<String, List<SidebarVO>> sidebarMap = sidebarService.listRankings();
		HttpSession session = request.getSession();
		session.setAttribute("sidebarMap", sidebarMap);

		return mav;
	}

	@RequestMapping(value = { "/" }, method = { RequestMethod.GET })
	public String mainOnlySlash(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "redirect:/main/main.do";
	}

	@RequestMapping(value = { "/main/siteInfo.do" }, method = { RequestMethod.GET })
	public String siteInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return (String) request.getAttribute("viewName");
	}
}
