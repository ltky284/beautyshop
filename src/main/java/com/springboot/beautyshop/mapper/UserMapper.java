package com.springboot.beautyshop.mapper;

import java.util.List;

import com.springboot.beautyshop.model.User;

public interface UserMapper {
	public List<User> SelectAllUser();
	public User SelectUserById(int id);
	public boolean InsertUser(User user);
	public boolean UpdateUser(User user);
	public boolean DeleteUserById(int id);
	public List<User> CheckLogin(User user);
}
