package com.innovacode.InnovaCode.controllers;

import com.innovacode.InnovaCode.entities.Employee;
import com.innovacode.InnovaCode.entities.Transaction;
import com.innovacode.InnovaCode.services.TransactionService;
import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//import java.awt.desktop.PreferencesEvent;
import java.util.List;

@Controller
public class TransactionController {
    @Autowired
    private TransactionService service;

    @GetMapping("/movements")
    public String ListMovements(Model model){
        model.addAttribute("transactions", this.service.getTransactionList());
        return "transactions/app-transactions-list";
    }

    @GetMapping("/movements/create")
    public String FormCreateMovement(Model model){
        Transaction transaction = new Transaction();
        model.addAttribute("transaction",this.service.postTransaction(transaction));
        return "MovementsCreate";
    }

    @PostMapping("/movements")
    public String saveMovement(@ModelAttribute("transaction") Transaction transaction){
        this.service.postTransaction(transaction);
        return "redirect:/movements";
    }

    @GetMapping("/movements/edit/{id}")
    public String FormEditUser(@PathVariable Long id, Model model){
        model.addAttribute("transaction", this.service.getTransactionById(id));
        return "MovementsEdit";
    }

    @PostMapping("/movements/{id}")
    public String patchMovement(@PathVariable Long id, @ModelAttribute("transaction")Transaction transaction){
        this.service.patchTransaction(id, transaction);
        return "redirect:/movements";
    }

    @GetMapping("/movements/{id}")
    public String deleteMovement(@PathVariable Long id) {
        this.service.deleteTransaction(id);
        return "redirect:/movements";
    }

}
