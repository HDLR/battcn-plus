package com.battcn.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
public class LoginController extends BaseController {
	
	@ApiIgnore
	@GetMapping("login")
	public String login() {
		return PATH_LOGIN;
	}
	
	@ApiIgnore
	@GetMapping("logout")
	public String main() {
		
		return PATH_REDIRECT_LOGOUT;
	}

}
