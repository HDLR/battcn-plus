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
import com.battcn.platform.pojo.dto.OperateDto;
import com.battcn.platform.pojo.message.ApiResult;
import com.battcn.platform.pojo.message.MessageId;
import com.battcn.platform.pojo.po.Operate;
import com.battcn.platform.service.MenuService;
import com.battcn.platform.service.OperateService;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/operate")
public class OperateController extends BaseController {
	@Autowired
	MenuService menuService;
	@Autowired
	OperateService operateService;
	
	@ApiIgnore
	@GetMapping("/list")
	public String list() {
		return "sys/operate/list";
	}

	@ApiIgnore
	@GetMapping(value = "/edit")
	public String edit(Integer id) {
		if (id != null) {
			request.setAttribute("dto",this.operateService.selectById(id).orElseThrow(() -> BattcnException.notFound("该数据已失效")));
		}
		request.setAttribute("menus",this.menuService.listMenu());
		return "sys/operate/edit";
	}

	@GetMapping(value = "/query")
	@ResponseBody
	public PageInfo<OperateDto> query(DataGrid grid) {
		return this.operateService.listOperateByPage(grid);
	}

	@BattcnLog(module = "操作管理", methods = "保存操作", description = "添加/修改操作信息")
	@PostMapping(value = "/save")
	@ResponseBody
	public ApiResult<String> save(Operate dto) {
		if (dto != null && dto.getId() != null) {
			return ApiResult.getResponse(this.operateService.updateSelectiveById(dto));
		}
		return ApiResult.getResponse(this.operateService.insertSelective(dto));
	}

	@BattcnLog(module = "操作管理", methods = "移除操作", description = "删除操作信息")
	@PostMapping(value = "/remove")
	@ResponseBody
	public ApiResult<String> del(Integer[] ids) {
		Lists.newArrayList(ids).forEach(id -> this.operateService.deleteById(id));
		return ApiResult.getSuccess(MessageId.GENERAL_SUCCESS);
	}

}
