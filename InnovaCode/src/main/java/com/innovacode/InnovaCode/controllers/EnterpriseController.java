package com.innovacode.InnovaCode.controllers;

import com.innovacode.InnovaCode.entities.Enterprise;
import com.innovacode.InnovaCode.services.EnterpriseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnterpriseController {

    private EnterpriseService service;

    @GetMapping("/enterprises")
    public List<Enterprise> enterpriseList(){
        return this.service.getEnterpriseList();
    }

    @PostMapping("/enterprises")
    public Enterprise createEnterprise(@RequestBody Enterprise enterprise){
        return this.service.postEnterprise(enterprise);
    }

    

}
