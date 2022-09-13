package com.innovacode.InnovaCode.controllers;

import com.innovacode.InnovaCode.entities.Enterprise;
import com.innovacode.InnovaCode.services.EnterpriseService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnterpriseController {

    @Autowired
    private EnterpriseService service;

    @GetMapping("/enterprises")
    public List<Enterprise> getEnterpriseList() {
        return this.service.getEnterpriseList();
    }

    @PostMapping("/enterprises")
    public Enterprise postEnterprise(@RequestBody Enterprise enterprise) {
        return this.service.postEnterprise(enterprise);
    }

    @GetMapping("/enterprises/{id}")
    public Enterprise getEnterpriseById(@PathVariable Long id) {
        return this.service.getEnterpriseById(id);
    }

    @PatchMapping("/enterprises/{id}")
    public Enterprise patchEnterprise(@PathVariable Long id, @RequestBody Enterprise enterprise) {
        return this.service.patchEnterprise(id, enterprise);
    }

    @DeleteMapping("/enterprises/{id}")
    public void deleteEnterprise(@PathVariable Long id) {
        this.service.deleteEnterprise(id);
    }

}
