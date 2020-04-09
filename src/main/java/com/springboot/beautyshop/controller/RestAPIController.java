package com.springboot.beautyshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.beautyshop.mapper.UserMapper;
import com.springboot.beautyshop.model.ResponseData;
import com.springboot.beautyshop.model.User;
import com.springboot.beautyshop.service.UserServiceImpl;
import com.springboot.beautyshop.util.APIMessage;
import com.springboot.beautyshop.util.APIMessage;



@RestController
public class RestAPIController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping(path = "/user")
	public ModelAndView GetAll(){
		List<User> userList = userServiceImpl.SelectAllUser();
		ModelAndView mav = new ModelAndView("userList");
		mav.addObject("list", userList);
		return mav;
	}
	
	@PostMapping(path="/submitregister")
	public String SubmitRegister(User user) {
		userServiceImpl.InserUser(user);
		System.out.println("username: "+user.getUsername());
		System.out.println("password: "+user.getPassword());
		System.out.println("email: "+user.getEmail());
		System.out.println("phone number "+user.getPhoneNumber());
		System.out.println("address: "+user.getAddress());
		
		return "index";
	}
	
	@PostMapping(path="/addnew")
	public String AddNew(User user) {
		userServiceImpl.InserUser(user);
		System.out.println("username: "+user.getUsername());
		System.out.println("password: "+user.getPassword());
		System.out.println("email: "+user.getEmail());
		System.out.println("phone number "+user.getPhoneNumber());
		System.out.println("address: "+user.getAddress());
		
		return "userList";
	}
	
	@PostMapping(path = "/edit/user/{id}")
	public ModelAndView EditUser(@PathVariable ("id") int id ){
		User user = userServiceImpl.SelectUserById(id);
		ModelAndView mav = new ModelAndView("user-info-form");
		mav.addObject("user", user);
		return mav;
	}
	
	@PostMapping(path = "/remove/user/{id}")
	public String RemoveUser(@PathVariable ("id") int id ){
		userServiceImpl.DeleteUserByID(id);
//		if(check == false) {
//			System.out.println("Delete failed user with id "+id);
//			return "error";
//		}
		return "redirect:/user";
		
		
	}
	
	
	
}
