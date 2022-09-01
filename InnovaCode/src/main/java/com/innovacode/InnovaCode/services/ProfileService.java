package com.innovacode.InnovaCode.services;

import com.innovacode.InnovaCode.entities.Profile;
import com.innovacode.InnovaCode.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private ProfileRepository repository;

    public ProfileService(ProfileRepository repository){
        this.repository = repository;
    }

    public Profile getProfile(){
        return (Profile) this.repository.findAll();
    }

    @Override
    public String toString() {
        return "ProfileService{}";
    }

    public Profile createProfile(Profile profile) {
        return this.repository.save(profile);
    }
}
