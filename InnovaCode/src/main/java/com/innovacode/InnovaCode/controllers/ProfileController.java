package com.innovacode.InnovaCode.controllers;

import com.innovacode.InnovaCode.entities.Profile;
import com.innovacode.InnovaCode.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileController {

    @Autowired
    private ProfileService service;

    @GetMapping("/profiles")
    public List<Profile> getProfileList(){
        return this.service.getProfileList();
    }

    @PostMapping("/profiles")
    public Profile postProfile(@RequestBody Profile profile){
        return this.service.postProfile(profile);
    }

    @GetMapping("/profiles/{id}")
    public Profile getProfileById(@PathVariable String id){
        return this.service.getProfileById(id);
    }

    @PatchMapping("/profiles/{id}")
    public Profile patchProfile(@PathVariable String id, @RequestBody Profile profile){
        return this.service.patchProfile(id, profile);
    }

    @DeleteMapping("/profiles/{id}")
    public void deleteProfile(@PathVariable String id){
        this.service.deleteProfile(id);
    }
}
