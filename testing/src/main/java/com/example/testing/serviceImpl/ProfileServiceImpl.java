package com.example.testing.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testing.model.Profile;
import com.example.testing.repository.ProfileRepository;
import com.example.testing.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileRepository repository;

	@Override
	public List<Profile> getUserProfiles() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<Profile> getUserProfile(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Profile addProfile(Profile profile) {
		// TODO Auto-generated method stub
		return repository.save(profile);
	}

	@Override
	public List<Profile> getUsersByProfileBio(String bio) {
		// TODO Auto-generated method stub
		return repository.findByBioContainingIgnoreCase(bio);
	}

}
