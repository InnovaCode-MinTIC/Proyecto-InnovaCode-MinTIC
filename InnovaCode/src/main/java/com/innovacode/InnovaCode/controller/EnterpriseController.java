package com.innovacode.InnovaCode.controller;

import com.innovacode.InnovaCode.entities.Enterprise;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EnterpriseController {


    @PutMapping("/enterprises")
    ResponseEntity<String> MetodoPut() {
        return ResponseEntity.ok("Status 200 metodo PUT");
    }

    @GetMapping("/enterprises")
    public String mostrarStatusEnterprise(){
        return "Enterprises";
    }

    @PostMapping("/enterprises")
    public String mostrarStatusEnterprisePost(){
        return "EnterprisesPost";
    }

    @GetMapping("/enterprises/{id}")
    ResponseEntity<String> MetodoGetId() {
        return ResponseEntity.ok("Status 200 metodo GET por Id");
    }

    @PatchMapping("/enterprises/{id}")
    ResponseEntity<String> MetodoPatchId() {
        return ResponseEntity.ok("Status 200 metodo PATCH por Id");
    }

    @DeleteMapping("/enterprises/{id}")
    ResponseEntity<String> MetodoDeleteId() {
        return ResponseEntity.ok("Status 200 metodo DELETE por Id");
    }

}
