package com.zensar.olxapplication.service;

import java.util.ArrayList;
import java.util.List;

import com.zensar.olxapplication.User;

public class OlxServiceimpl implements OlxService {
	static List<User> users = new ArrayList<>();
	static
	{
		users.add(new User(1, "Anand", "Kulkarni", "anand", "anand123", "anand@gmail.com", "12345"));
	}
	
	@Override
	public List<User> getAllUsers() {
		
		return users;
	}

	@Override
	public User userAuthentication(User user, String token) {
		for(User user1 : users)
		{
			if(user1.getUserName()=="anand" && user1.getPassword()=="anand123")
			{
				
			}
		
		}
		return null;
	}

	@Override
	public User createStock(User user) {
		users.add(user);
		return user;
	}

	@Override
	public boolean deleteAllUser(String token) {
		if(token.equals("rm66633"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	

}
