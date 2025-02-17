package com.example.testing.resolver;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.testing.exception.UserNotFoundException;
import com.example.testing.model.Profile;
import com.example.testing.model.User;
import com.example.testing.serviceImpl.ProfileServiceImpl;
import com.example.testing.serviceImpl.UserServiceImpl;

@Controller
public class UserResolver {
	
	@Autowired
	private UserServiceImpl service;
	
	@Autowired
	private ProfileServiceImpl profileService;
	
	@MutationMapping
	public User addUser(@Argument String name, @Argument String email,
						@Argument String bio, @Argument String profilePictureUrl) {
		
		Profile profiles = new Profile();
		profiles.setBio(bio);
		profiles.setProfilePictureUrl(profilePictureUrl);
		
		Profile saveProfile = profileService.addProfile(profiles);
		
		User users = new User();
		users.setName(name);
		users.setEmail(email);
		users.setProfile(saveProfile);
		
		return service.addUser(users);
	}
	
	@QueryMapping
	public User getUser(@Argument Long id) throws UserNotFoundException {
		Optional<User> userOptional = service.getUser(id);
		return userOptional.orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
	}
	
	@QueryMapping
	public List<User> getUsers() {
		return service.getUsers();
	}
	
	@QueryMapping
	public List<User> getUserByName(@Argument String name) {
		return service.getUserByName(name);
	}
}
