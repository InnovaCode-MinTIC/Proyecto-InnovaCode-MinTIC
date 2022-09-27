package com.innovacode.InnovaCode.controllers;

import com.innovacode.InnovaCode.entities.Employee;
import com.innovacode.InnovaCode.entities.Enterprise;
import com.innovacode.InnovaCode.entities.Transaction;
import com.innovacode.InnovaCode.services.EmployeeService;
import com.innovacode.InnovaCode.services.EnterpriseService;
import com.innovacode.InnovaCode.services.TransactionService;
import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//import java.awt.desktop.PreferencesEvent;
import java.util.List;

@Controller
public class TransactionController {
    @Autowired
    private TransactionService service;
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/movements")
    public String ListMovements(Model model, @AuthenticationPrincipal OidcUser principal){
        if(principal != null){
            Employee employee = this.employeeService.getOrCreateUser(principal.getClaims());
            model.addAttribute("user",employee);
        }
        model.addAttribute("transactions", this.service.getTransactionList());
        return "transactions/app-transactions-list";
    }

    @GetMapping("/movements/create")
    public String FormCreateMovement(Model model, @AuthenticationPrincipal OidcUser principal){
        if(principal != null){
            Employee employee = this.employeeService.getOrCreateUser(principal.getClaims());
            model.addAttribute("user",employee);
        }
        Transaction transaction = new Transaction();
        model.addAttribute("transaction",this.service.postTransaction(transaction));
        List<Enterprise> enterpriseList = enterpriseService.getEnterpriseList();
        model.addAttribute("enterpriseList", enterpriseList);
        List<Employee> employeeList = employeeService.getEmployeeList();
        model.addAttribute("employeeList", employeeList);
        return "transactions/app-transaction-create";
        //return "MovementsCreate";
    }

    @PostMapping("/movements")
    public String saveMovement(@ModelAttribute("transaction") Transaction transaction){
        this.service.postTransaction(transaction);
        return "redirect:/movements";
    }

    @GetMapping("/movements/edit/{id}")
    public String FormEditUser(@PathVariable Long id, Model model, @AuthenticationPrincipal OidcUser principal){
        if(principal != null){
            Employee employee = this.employeeService.getOrCreateUser(principal.getClaims());
            model.addAttribute("user",employee);
        }

        model.addAttribute("transaction", this.service.getTransactionById(id));
        List<Enterprise> enterpriseList = enterpriseService.getEnterpriseList();
        model.addAttribute("enterpriseList", enterpriseList);
        List<Employee> employeeList = employeeService.getEmployeeList();
        model.addAttribute("employeeList", employeeList);
        return "transactions/app-transaction-edit";
        //return "MovementsEdit";
    }

    @PostMapping("/movements/{id}")
    public String patchMovement(@PathVariable Long id, @ModelAttribute("transaction")Transaction transaction){
        this.service.patchTransaction(id, transaction);
        return "redirect:/movements";
    }

    @GetMapping("/movements/delete/{id}")
    public String deleteMovement(@PathVariable Long id) {
        this.service.deleteTransaction(id);
        return "redirect:/movements";
    }

}
