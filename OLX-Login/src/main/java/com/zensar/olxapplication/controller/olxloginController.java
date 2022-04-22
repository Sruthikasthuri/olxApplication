package com.zensar.olxapplication.controller;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxapplication.User;

//@Controller
@RequestMapping("/user")
@RestController
public class olxloginController {

	static List<User> users = new ArrayList<User>();
	static {
		users.add(new User(1L, "Anand", "Kulkarni", "anand", "anand123", "anand@gmail.com", 12345));
	}

	// @GetMapping(value = "/user", produces = { MediaType.APPLICATION_JSON_VALUE,
	// MediaType.APPLICATION_XML_VALUE })
	@RequestMapping(method=RequestMethod.GET)
	public List<User> getAllUsers(@RequestHeader("userName") String username,
			@RequestHeader("password") String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			return users;
		}
		return null;
	}

	// @PostMapping(value = "/user", produces = {
	// MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, consumes
	// = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		users.add(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@DeleteMapping("/logout/{userId}")
	public boolean logoutUser(@PathVariable("userId") long id, @RequestHeader("userName") String username,
			@RequestHeader("password") String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			for (User user : users) {
				if (user.getId() == id) {
					users.remove(user);
					return true;
				}
			}
		}
		return false;
	}

	// @PostMapping(value = "/user/authenticate", produces = {
	// MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, consumes
	// = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	@PostMapping(value = "/authenticate")
	
	public String loginUser(@RequestBody User user) {
		return user.getUserName() + "\n" + user.getPassword();
	}
}

/*
 * static List<User> users = new ArrayList<User>();
 * 
 * static { users.add(new User(1L, "Anand", "Kulkarni", "anand", "anand123",
 * "anand@gmail.com", 12345));
 * 
 * }
 * 
 * @GetMapping("/user")
 * 
 * public List<User> getAllUsers(@RequestHeader("userName") String userName,
 * 
 * @RequestHeader("password") String password) {
 * 
 * if (userName.equals("anand") && password.equals("anand123")) { return users;
 * }
 * 
 * return null;
 * 
 * }
 * 
 * @PostMapping("/user") public ResponseEntity<User> registerUser(@RequestBody
 * User user) { users.add(user);
 * 
 * return new ResponseEntity<User>(user, HttpStatus.CREATED); }
 * 
 * @DeleteMapping("/user/logout/{userId}") public boolean
 * logoutUser(@PathVariable("userId") long id1, @RequestHeader("userName")
 * String username,
 * 
 * @RequestHeader("password") String password) {
 * 
 * if (username.equals("anand") && password.equals("anand123")) { for (User user
 * : users) { if (user.getId() == id1) { users.remove(user);
 * 
 * return true; }
 * 
 * }
 * 
 * } return false;
 * 
 * }
 * 
 * @PostMapping("/user/authenticate") public String loginUser(@RequestBody User
 * user) {
 * 
 * return user.getUserName() + "\n" + user.getPassword();
 * 
 * }
 */
