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

@Controller
public class IndexController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/")
    public String IndexListMovements(Model model){
        model.addAttribute("employeeCount", this.employeeService.countEmployees());
        model.addAttribute("enterpriseCount", this.enterpriseService.countEnterprise());
        model.addAttribute("transactionCount", this.transactionService.countTransaction());
        return "index/index";
    }

}
