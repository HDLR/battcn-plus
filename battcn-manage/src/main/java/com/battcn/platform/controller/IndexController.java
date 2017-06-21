package com.battcn.platform.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.battcn.framework.common.exception.AuthException;
import com.battcn.platform.pojo.po.Manager;
import com.battcn.platform.pojo.po.Menu;
import com.battcn.platform.pojo.po.Operate;
import com.battcn.platform.service.MenuService;
import com.battcn.platform.service.OperateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

@Api(value = "入口请求")
@Controller
public class IndexController extends BaseController {

	static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(IndexController.class);

	@Autowired
	MenuService menuService;
	@Autowired
	OperateService operateService;

	@ApiIgnore
	@GetMapping(value = { "/", "/index" })
	public String index(Model model) {
		Manager manager = new Manager();
		manager.setRoleId((byte) 1);
		model.addAttribute("trees", menuService.listTree(1));
		return "index";
	}

	@ApiIgnore
	@GetMapping(value = "main")
	public String main() {
		return PATH_MAIN;
	}

	@RequestMapping("op_{oper}_{menuId}")
	@ApiOperation(value = "根据oper与id转发到指定的地址", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 404, message = "地址错误"),
			@ApiResponse(code = 500, message = "系统错误,请联系管理人员") })
	public String forward(@PathVariable String oper, @PathVariable Integer menuId, Model model) {
		Menu menu = this.menuService.selectById(menuId).orElseThrow(() -> AuthException.notFound("无访问权限"));
		List<Operate> op = Optional.ofNullable(this.operateService.listOperateByRoleIdAndMenuId(1, menuId))
				.orElseThrow(() -> AuthException.notFound("无权限"));
		model.addAttribute("operates", op);
		model.addAttribute("OP", op.get(0));
		model.addAttribute("MENU", menu);// 获取对应的菜单对象
		String forword = String.format("forward:%s/%s", menu.getChannel(), oper);
		LOGGER.info("[转发地址] - [{}]", forword);
		return forword;
	}

}
