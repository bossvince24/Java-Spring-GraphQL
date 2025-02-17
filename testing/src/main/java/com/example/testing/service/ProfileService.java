package com.example.testing.service;

import java.util.List;
import java.util.Optional;

import com.example.testing.model.Profile;


public interface ProfileService {
	
	List<Profile> getUserProfiles();
	Optional<Profile> getUserProfile(Long id);
	Profile addProfile(Profile profile);
	List<Profile> getUsersByProfileBio(String bio);

}
