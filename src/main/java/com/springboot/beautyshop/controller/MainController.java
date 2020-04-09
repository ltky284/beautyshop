package com.springboot.beautyshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.beautyshop.model.User;
import com.springboot.beautyshop.service.UserServiceImpl;

@Controller
public class MainController {
	@Autowired
	UserServiceImpl userServiceImpl;
	
	public MainController() {
		System.out.println("Bean has created !!!!");
	}
	
	@RequestMapping(path = "/")
	public String ShowHomePage () {
		return "index";
	}
	
	@RequestMapping(path = "/login")
	public String ShowLoginPage () {
		return "login";
	}
	
	@RequestMapping(path="/register")
	public String ShowRegisterPage() {
		return "register";
	}
	
	@PostMapping(path="/submitlogin")
	public String SubmitLoginPage(User user, ModelMap model) {
		String username = user.getUsername();
		String password = user.getPassword();
		List<User> UserList = new ArrayList<User>();
		UserList = userServiceImpl.CheckLogin(user);

		if( !UserList.isEmpty()) {
			String UserName= UserList.get(0).getUsername();
			String Password= UserList.get(0).getPassword();
			System.out.println("username: "+username);
			System.out.println("password: "+password);
			System.out.println("username: "+UserName);
			System.out.println("password: "+Password);
			model.addAttribute("Message", "Welcome "+UserName);
			return "index";
		}
		else {
			model.addAttribute("Message", "Sign Fail!!! Please try again. ");
			return ("redirect:/login");
		}

	}
	
}
