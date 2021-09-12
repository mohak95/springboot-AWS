package com.jdbctest.SpringJdbcApp.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdbctest.SpringJdbcApp.pojo.UserStudent;
import com.jdbctest.SpringJdbcApp.service.UserService;

@RestController
@RequestMapping(path="/user")
public class UserController {

	@Autowired
	private UserService userService;
	

	
	

	
	
	
	
	@GetMapping
	public String check() {
		return "Welcome to Spring Boot";
	}
	
	@GetMapping("/getusernames")
	public List<String> getAllUserName(){
		
		return userService.getAllUsers();
	}
	
	@GetMapping("/getuserstudents")
	public List<?> getAllUserStudents() throws ClassNotFoundException{
		
		return userService.getAllUserStudents();
	}
	
	@GetMapping("/{id}")
	public String getUserStudentById(@PathVariable("id") String id) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.writeValueAsString(userService.getUserStudentById(Integer.parseInt(id)));
	}
	
	@PostMapping("/saveuser")
	public String saveUserStudents(@RequestBody List<UserStudent> studentList) throws Exception {
		
			userService.saveStudents(studentList);
			
			return "success";
	}
}
