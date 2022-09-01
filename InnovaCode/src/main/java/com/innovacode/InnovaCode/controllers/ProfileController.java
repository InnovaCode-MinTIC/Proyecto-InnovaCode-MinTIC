package com.innovacode.InnovaCode.controllers;

import com.innovacode.InnovaCode.entities.Profile;
import com.innovacode.InnovaCode.services.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    ProfileService service;

    public ProfileController(ProfileService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public Profile profile(){
        return this.service.getProfile();
    }

    @PostMapping("/tasks")
    public Profile createProfile(@RequestBody Profile profile){
        return this.service.createProfile(profile);
    }
}
