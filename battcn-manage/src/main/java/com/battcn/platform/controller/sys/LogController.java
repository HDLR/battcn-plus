package com.battcn.platform.controller.sys;

import com.battcn.framework.common.exception.BattcnException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.battcn.framework.common.annotation.BattcnLog;
import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.platform.pojo.po.Log;
import com.battcn.platform.service.LogService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

import static com.battcn.framework.common.exception.BattcnException.badRequest;

@Controller
@RequestMapping("/sys/log")
@ApiIgnore
public class LogController {

	@Autowired
	LogService logService;

	@RequestMapping(value = "/list")
	@BattcnLog(description = "进入日志查询的页面", module = "日志模块", methods = "日志list")
	@ApiOperation(value = "跳转日志页面", hidden = true)
	public String list() throws BattcnException {
		return "sys/log/list";
	}

	@RequestMapping(value = "/query")
	@ResponseBody
	@ApiOperation(value = "根据分页条件查询分页的结果集", httpMethod = "GET", produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 404, message = "地址错误"),
			@ApiResponse(code = 500, message = "系统错误,请联系管理人员") })
	public PageInfo<Log> query(DataGrid grid) {
		return this.logService.listForDataGrid(grid);
	}

}
