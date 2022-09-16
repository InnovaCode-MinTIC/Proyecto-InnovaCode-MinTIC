package com.innovacode.InnovaCode.controllers;

import com.innovacode.InnovaCode.entities.Transaction;
import com.innovacode.InnovaCode.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    private TransactionService service;
    @GetMapping("/movements")
    public List<Transaction> getTransactionList(){
        return this.service.getTransactionList();
    }
    @PostMapping("/movements")
    public Transaction postTransaction(@RequestBody Transaction transaction){
        return this.service.postTransaction(transaction);    }
    @GetMapping("/movements/{id}")
    public Transaction getTransactionById(@PathVariable Long id){
        return this.service.getTransactionById(id);
    }
    @PatchMapping("/movements/{id}")
    public Transaction patchTransaction(@PathVariable Long id, @RequestBody Transaction transaction){
        return this.service.patchTransaction(id,transaction);    }
    @DeleteMapping("/movements/{id}")
    public void deleteTransaction(@PathVariable Long id){
        this.service.deleteTransaction(id);
    }
    @GetMapping("/enterprises/{id}/movements")
    public List<Transaction> getTransactionByEnterprise(@PathVariable Long id){
        return this.service.getTransactionByEnterprise(id);
    }
}
