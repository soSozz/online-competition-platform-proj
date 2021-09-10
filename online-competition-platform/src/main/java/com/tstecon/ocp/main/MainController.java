package com.tstecon.ocp.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tstecon.ocp.common.base.BaseController;

@Controller("mainController")
@EnableAspectJAutoProxy
public class MainController extends BaseController {
//	@Autowired

	@RequestMapping(value = { "/main/main.do" }, method = { RequestMethod.GET })
	public String main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");

		return viewName;
	}

	@RequestMapping(value = { "/" }, method = { RequestMethod.GET })
	public String mainOnlySlash(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/";
	}
}
