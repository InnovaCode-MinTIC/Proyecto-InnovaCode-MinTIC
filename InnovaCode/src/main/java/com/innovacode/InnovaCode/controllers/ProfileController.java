package com.innovacode.InnovaCode.controllers;

import com.innovacode.InnovaCode.entities.Profile;
import com.innovacode.InnovaCode.services.ProfileService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
    private ProfileService service;

    public ProfileController (ProfileService service){
        this.service = service;
    }
}
