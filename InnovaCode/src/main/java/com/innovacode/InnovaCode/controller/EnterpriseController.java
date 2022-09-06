package com.innovacode.InnovaCode.controller;

import com.innovacode.InnovaCode.entity.Enterprise;
import com.innovacode.InnovaCode.service.EnterpriseService;
//import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EnterpriseController {

    @Autowired
    private EnterpriseService servicio;

/*
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
    }*/

    //CRUD
    @GetMapping({"/enterprises", "/"})
    public String listarEnterpsises(Model modelo){
        modelo.addAttribute("enterprises", servicio.listEnterprises());
        return "EnterprisesList";
    }
    @GetMapping("/enterprises/create")
    public String FormCreateEnterprise(Model modelo){
        Enterprise enterprise = new Enterprise();
        modelo.addAttribute("enterprise", enterprise);
        return "EnterprisesCreate";
    }

    @PostMapping("/enterprises")
    public String saveEntreprises(@ModelAttribute("enterprise") Enterprise enterprise){
        servicio.saveEnterprise(enterprise);
        return "redirect:/enterprises";
    }

    @GetMapping("/enterprises/edit/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("enterprise", servicio.consultarEnterprise(id));
        return "enterprisesEdit";
    }

    @PostMapping("/enterprises/{id}")
    public String updateEnterpsises(@PathVariable Long id,@ModelAttribute("enterprise") Enterprise enterprise,Model modelo){
        Enterprise enterprisesExistente = servicio.consultarEnterprise(id);
        enterprisesExistente.setId(id);
        enterprisesExistente.setName(enterprise.getName());
        enterprisesExistente.setDocument(enterprise.getDocument());
        enterprisesExistente.setPhone(enterprise.getPhone());
        enterprisesExistente.setAddress(enterprise.getAddress());
        servicio.updateEnterpsises(enterprisesExistente);
        return "redirect:/enterprises";
    }

    @GetMapping("/enterprises/{id}")
    public String deleteEnterprises(@PathVariable Long id) {
        servicio.deleteEnterprose(id);
        return  "redirect:/enterprises";
    }

}
