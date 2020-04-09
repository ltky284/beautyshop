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

import com.springboot.beautyshop.model.User;
import com.springboot.beautyshop.service.UserServiceImpl;
import com.springboot.beautyshop.util.APIMessage;

@RestController
@RequestMapping("/api")
public class UserRestController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	//REST API 
	
	@GetMapping(path = "/users")
	public ResponseEntity<List<User>> GetAllUser (){
		List<User> userlist = userServiceImpl.SelectAllUser();
		if(userlist.isEmpty()) {
			return new ResponseEntity<List<User>>(userlist,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(userlist,HttpStatus.OK);
	}
	
	@GetMapping(path = "/user/id")
	public ResponseEntity<?> GetUserByID (@PathVariable("id") int id){
		User user  = userServiceImpl.SelectUserById(id);
		if(user == null) {
			APIMessage apiMess = new APIMessage("User not found!!!");
			return new ResponseEntity<APIMessage>(apiMess,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	 @PostMapping(value = "insert/user")
	    public ResponseEntity<Boolean> CreateUser(@RequestBody User user) {
		 	boolean check = userServiceImpl.InserUser(user);
	        if (check == false) {
	            return new ResponseEntity<Boolean>(check,HttpStatus.BAD_REQUEST);
	        }
	        return new ResponseEntity<Boolean>(check, HttpStatus.CREATED);
	    }
	 
	 @PutMapping(value = "update/user/id")
	    public ResponseEntity<Boolean> UpdateUser(@PathVariable("id") int id, @RequestBody User user) {
		 	User currentUser = userServiceImpl.SelectUserById(id);

	        currentUser.setId(user.getId());
	        currentUser.setUsername(user.getUsername());
	        currentUser.setPassword(user.getPassword());
	        currentUser.setEmail(user.getEmail());
	        currentUser.setPhoneNumber(user.getPhoneNumber());
	        currentUser.setAddress(user.getAddress());
	        boolean check = userServiceImpl.UpdateUser(user);
	        return new ResponseEntity<Boolean>(check, HttpStatus.OK);
	    }
	
	@DeleteMapping(path = "/delete/user/{id}")
	public ResponseEntity<Boolean> DeleteUserByID (@PathVariable("id") int id){
		boolean check = userServiceImpl.DeleteUserByID(id);
		if (check == false) {
			return new ResponseEntity<Boolean>(check,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Boolean>(check,HttpStatus.OK);
	}
}
