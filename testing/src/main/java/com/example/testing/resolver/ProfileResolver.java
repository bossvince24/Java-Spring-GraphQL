package com.example.testing.resolver;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.testing.model.Profile;
import com.example.testing.model.User;
import com.example.testing.serviceImpl.ProfileServiceImpl;

@Controller
public class ProfileResolver {
	
	@Autowired
	private ProfileServiceImpl service;
	
	@QueryMapping
	public List<Profile> getUserProfiles() {
		return service.getUserProfiles();
	}
	
	@QueryMapping
	public Profile getUserProfile(@Argument Long id) {
		Optional<Profile> profileOptional = service.getUserProfile(id);
		return profileOptional.get();
	}
	
	public Profile addProfile(@Argument Profile profile) {
		return service.addProfile(profile);
	}
	
	@QueryMapping
	public List<Profile> getUsersByProfileBio(@Argument String bio) {
		return service.getUsersByProfileBio(bio);
	}
}
