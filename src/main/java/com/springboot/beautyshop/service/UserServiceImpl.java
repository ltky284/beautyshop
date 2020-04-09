package com.springboot.beautyshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.beautyshop.mapper.UserMapper;
import com.springboot.beautyshop.model.User;

@Service(value="userService")
public class UserServiceImpl {
	
	@Autowired
	UserMapper userMapper;
	
	public List<User> SelectAllUser() {
		return userMapper.SelectAllUser();
	}
	
	public User SelectUserById(int id) {
		return userMapper.SelectUserById(id);
		
	}
	
	public boolean InserUser(User user) {
		return userMapper.InsertUser(user);
	}
	

	public boolean UpdateUser(User user) {
		return userMapper.UpdateUser(user);
	}
	

	public boolean DeleteUserByID(int id) {
		return userMapper.DeleteUserById(id);
	}
	
	public List<User> CheckLogin(User user) {
		return userMapper.CheckLogin(user);
	}
	
	

}
