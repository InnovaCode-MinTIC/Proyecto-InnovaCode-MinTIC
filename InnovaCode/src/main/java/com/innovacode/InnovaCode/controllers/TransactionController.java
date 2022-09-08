package com.innovacode.InnovaCode.controllers;

import com.innovacode.InnovaCode.services.TransactionService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    private TransactionService service;

    public TransactionController(TransactionService service){
        this.service = service;
    }
}
