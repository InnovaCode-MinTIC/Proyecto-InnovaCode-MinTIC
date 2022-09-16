package com.innovacode.InnovaCode.controllers;

import com.innovacode.InnovaCode.entities.Enterprise;
import com.innovacode.InnovaCode.services.EnterpriseService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EnterpriseController {

    @Autowired
    private EnterpriseService service;

    @GetMapping("/enterprises")
    public String ListarEmpresa(Model model){
        model.addAttribute("enterprises", service.getEnterpriseList());
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
        service.postEnterprise(enterprise);
        return "redirect:/enterprises";
    }

    @GetMapping("/enterprises/edit/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("enterprise", service.getEnterpriseById(id));
        return "enterprisesEdit";
    }

    @PostMapping("/enterprises/{id}")
    public String patchEnterprise(@PathVariable Long id, @ModelAttribute("enterprise") Enterprise enterprise,Model modelo) {
       service.patchEnterprise(id, enterprise);
        return "redirect:/enterprises";
    }

    @GetMapping("/enterprises/{id}")
    public String deleteEnterprise(@PathVariable Long id) {
        service.deleteEnterprise(id);
        return  "redirect:/enterprises";
    }

}
