package com.innovacode.InnovaCode.controllers;

import com.innovacode.InnovaCode.entities.Employee;
import com.innovacode.InnovaCode.entities.Enterprise;
import com.innovacode.InnovaCode.entities.Transaction;
import com.innovacode.InnovaCode.services.EmployeeService;
import com.innovacode.InnovaCode.services.EnterpriseService;
import com.innovacode.InnovaCode.services.TransactionService;
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
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/enterprises")
    public String ListarEmpresa(Model model){
        model.addAttribute("enterprises", service.getEnterpriseList());
        return "enterprises/app-enterprise-list";
    }

    @GetMapping("/enterprises/create")
    public String FormCreateEnterprise(Model modelo){
        Enterprise enterprise = new Enterprise();
        modelo.addAttribute("enterprise", enterprise);
        return "enterprises/app-enterprise-create";
        //return "EnterprisesCreate";
    }

    @PostMapping("/enterprises")
     public String saveEntreprises(@ModelAttribute("enterprise") Enterprise enterprise){
        service.postEnterprise(enterprise);
        return "redirect:/enterprises";
    }

    @GetMapping("/enterprises/edit/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("enterprise", service.getEnterpriseById(id));
        return "enterprises/app-enterprise-edit";
        //return "enterprisesEdit";
    }

    @PostMapping("/enterprises/{id}")
    public String patchEnterprise(@PathVariable Long id, @ModelAttribute("enterprise") Enterprise enterprise,Model modelo) {
       service.patchEnterprise(id, enterprise);
        return "redirect:/enterprises";
    }

    @GetMapping("/enterprises/delete/{id}")
    public String deleteEnterprise(@PathVariable Long id) {
        service.deleteEnterprise(id);
        return  "redirect:/enterprises";
    }

    @GetMapping("/enterprises/{id}")
    public String getEnterprise(@PathVariable Long id, Model model){
        List<Transaction> transactionList= transactionService.getTransactionByEnterprise(id);
        List<Employee> employeeList= employeeService.getEmployeeByEnterprise(id);
        model.addAttribute("enterprise", this.service.getEnterpriseById(id));
        model.addAttribute("transactions", transactionList);
        model.addAttribute("employees", employeeList);
        return "enterprises/app-enterprise-view";
    }

}
