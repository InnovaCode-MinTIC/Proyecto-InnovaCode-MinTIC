package com.innovacode.InnovaCode.services;

import com.innovacode.InnovaCode.entities.Transaction;
import com.innovacode.InnovaCode.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> getTransactionList() {
        return this.repository.findAll();
    }

    public Transaction postTransaction(Transaction transaction) {
        return this.repository.save(transaction);
    }

    public Transaction getTransactionById(Long id) {
        return this.repository.findById(id).get();
    }

    public Transaction patchTransaction(Long id, Transaction transaction){

        return this.repository.save(transaction);
    }

    public void deleteTransaction(Long id){
        this.repository.deleteById(id);
    }
}
