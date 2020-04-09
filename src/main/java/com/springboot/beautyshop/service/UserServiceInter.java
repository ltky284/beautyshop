package com.springboot.beautyshop.service;

import java.util.List;

import com.springboot.beautyshop.model.User;

public interface UserServiceInter {
	public List<User> SelectAllUser();
	public User SelectUserById(int id);
	public boolean InserUser(User user);;
	public boolean UpdateUser(User user);
	public boolean DeleteUserById(int id);
	public List<User> CheckLogin(User user);
}
