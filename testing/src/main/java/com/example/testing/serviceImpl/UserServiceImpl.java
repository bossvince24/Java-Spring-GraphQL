package com.example.testing.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testing.exception.UserNotFoundException;
import com.example.testing.model.User;
import com.example.testing.repository.UserRepository;
import com.example.testing.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<User> getUser(Long id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.findById(id))
				.orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
	}
	
	@Override
    public List<User> getUserByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
}
