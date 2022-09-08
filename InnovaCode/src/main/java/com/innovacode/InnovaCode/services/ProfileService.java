package com.innovacode.InnovaCode.services;

import com.innovacode.InnovaCode.entities.Profile;
import com.innovacode.InnovaCode.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private ProfileRepository repository;

    public ProfileService(ProfileRepository repository){
        this.repository = repository;
    }

    public List<Profile> getProfileList(){
        return this.repository.findAll();
    }

    public Profile postProfile (Profile profile){
        return this.repository.save(profile);
    }

    public Profile getProfileById(String id){
        return this.repository.findById(id).get();
    }

    public Profile patchProfile(Profile profile){
        return this.repository.save(profile);
    }

    public void deleteProfile(String id){
        this.repository.deleteById(id);
    }
}
