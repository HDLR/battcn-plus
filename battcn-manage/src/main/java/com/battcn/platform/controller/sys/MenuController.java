package com.battcn.platform.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.battcn.framework.common.annotation.BattcnLog;
import com.battcn.framework.common.exception.BattcnException;
import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.platform.controller.BaseController;
import com.battcn.platform.pojo.message.ApiResult;
import com.battcn.platform.pojo.message.MessageId;
import com.battcn.platform.pojo.po.Menu;
import com.battcn.platform.service.MenuService;
import com.google.common.collect.Lists;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;


@Controller
@RequestMapping("/sys/menu")
@Api(value = "菜单管理")
@ApiIgnore
public class MenuController extends BaseController {
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping("/list")
	public String list(DataGrid grid) {
		request.setAttribute("page", this.menuService.listMenuForDataGrid(grid));
		return "sys/menu/list";
	}

	@GetMapping(value = "/edit")
	public String edit(Integer id) {
		if (id != null) {
			request.setAttribute("dto",this.menuService.selectById(id).orElseThrow(() -> BattcnException.notFound("该数据已失效")));
		}
		request.setAttribute("menus",this.menuService.listMenu());
		return "sys/menu/edit";
	}

	@BattcnLog(module = "菜单管理", methods = "保存菜单", description = "添加/修改菜单信息")
	@PostMapping(value = "/save")
	@ResponseBody
	public ApiResult<String> save(Menu menu) {
		this.menuService.saveOrUpdate(menu);
		return ApiResult.getSuccess(MessageId.GENERAL_SUCCESS);
	}

	@BattcnLog(module = "菜单管理", methods = "移除菜单", description = "删除菜单信息")
	@PostMapping(value = "/remove")
	@ResponseBody
	public ApiResult<String> del(Integer[] ids) {
		Lists.newArrayList(ids).forEach(id -> this.menuService.deleteById(id));
		return ApiResult.getSuccess(MessageId.GENERAL_SUCCESS);
	}
	
	

}
