package com.innovacode.InnovaCode.controllers;

import com.innovacode.InnovaCode.entities.Employee;
import com.innovacode.InnovaCode.entities.Enterprise;
import com.innovacode.InnovaCode.entities.Transaction;
import com.innovacode.InnovaCode.services.EmployeeService;
import com.innovacode.InnovaCode.services.EnterpriseService;
import com.innovacode.InnovaCode.services.TransactionService;
import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/users")
    public String ListUsers(Model model){
        model.addAttribute("employees", this.service.getEmployeeList());
        return "users/app-user-list";
    }

    @GetMapping("/users/create")
    public String FormCreateUser (Model model){
        Employee employee = new Employee();
        List<Enterprise> enterpriseList = enterpriseService.getEnterpriseList();
        model.addAttribute("enterpriseList", enterpriseList);
        model.addAttribute("employee",employee);
        return "users/app-user-create";
        //return "UsersCreate";
    }

    @PostMapping("/users")
    public String saveUser(@ModelAttribute("employee") Employee employee){
        this.service.postEmployee(employee);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String FormEditUser(@PathVariable Long id, Model model){
        model.addAttribute("employee", this.service.getEmployeeById(id));
        List<Enterprise> enterpriseList = enterpriseService.getEnterpriseList();
        model.addAttribute("enterpriseList", enterpriseList);
        return "users/app-user-edit";
        //return "UsersEdit";
    }

    @PostMapping("/users/{id}")
    public String patchUser(@PathVariable Long id, @ModelAttribute("employee") Employee employee, Model model){
        this.service.patchEmployee(id, employee);
        return "redirect:/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        this.service.deleteEmployee(id);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable Long id, Model model){
        List<Transaction> transactionList= transactionService.getTransactionByEmployee(id);
        model.addAttribute("employee", this.service.getEmployeeById(id));
        model.addAttribute("transactions", transactionList);
        return "users/app-user-view";
    }
}
