package com.battcn.platform.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.battcn.framework.common.annotation.BattcnLog;
import com.battcn.framework.common.exception.BattcnException;
import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.platform.controller.BaseController;
import com.battcn.platform.pojo.dto.ManagerDto;
import com.battcn.platform.pojo.message.ApiResult;
import com.battcn.platform.pojo.message.MessageId;
import com.battcn.platform.pojo.po.Manager;
import com.battcn.platform.service.ManagerService;
import com.battcn.platform.service.RoleService;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/manager")
@Api(value = "用户管理")
public class ManagerController extends BaseController {
	
	@Autowired
	private ManagerService managerService;
	@Autowired
	private RoleService roleService;
	
	@ApiIgnore
	@GetMapping("/list")
	public String list(Model model) {
		return "sys/manager/list";
	}

	@ApiIgnore
	@GetMapping(value = "/edit")
	public String edit(Integer id) {
		if (id != null) {
			request.setAttribute("dto",
					this.managerService.selectById(id).orElseThrow(() -> BattcnException.notFound("该数据已失效")));
		}
		request.setAttribute("roles", this.roleService.listRole());
		return "sys/manager/edit";
	}

	@GetMapping(value = "/query")
	@ResponseBody
	public PageInfo<ManagerDto> query(DataGrid grid, String name, String account) {
		return this.managerService.listManagerByName(grid, name, account);
	}

	@BattcnLog(module = "用户管理", methods = "保存用户", description = "添加/修改用户信息")
	@PostMapping(value = "/save")
	@ResponseBody
	public ApiResult<Manager> save(Manager dto) {
		if (dto != null && dto.getId() != null) {
			return ApiResult.getResponse(this.managerService.updateSelectiveById(dto));
		}
		return ApiResult.getResponse(this.managerService.insertSelective(dto));
	}

	@BattcnLog(module = "用户管理", methods = "移除用户", description = "删除用户信息")
	@PostMapping(value = "/remove")
	@ResponseBody
	public ApiResult<String> del(Integer[] ids) {
		Lists.newArrayList(ids).forEach(id -> this.managerService.deleteById(id));
		return ApiResult.getSuccess(MessageId.GENERAL_SUCCESS);
	}

}
