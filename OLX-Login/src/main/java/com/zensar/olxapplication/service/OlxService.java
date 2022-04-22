package com.zensar.olxapplication.service;

import java.util.List;

import com.zensar.olxapplication.User;

public interface OlxService {
	public List<User> getAllUsers();
	public User userAuthentication(User user,String token);
	public User createStock( User user);
	public boolean deleteAllUser(String token);

}
