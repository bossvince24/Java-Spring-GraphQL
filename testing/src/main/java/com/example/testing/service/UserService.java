package com.example.testing.service;

import java.util.List;
import java.util.Optional;

import com.example.testing.exception.UserNotFoundException;
import com.example.testing.model.User;

public interface UserService {
	
	User addUser(User user);
	List<User> getUsers();
	Optional<User> getUser(Long id) throws UserNotFoundException;
	List<User> getUserByName(String name);
}
