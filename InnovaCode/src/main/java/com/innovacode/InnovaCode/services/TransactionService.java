package com.innovacode.InnovaCode.services;

import com.innovacode.InnovaCode.entities.Employee;
import com.innovacode.InnovaCode.entities.Enterprise;
import com.innovacode.InnovaCode.entities.Transaction;
import com.innovacode.InnovaCode.repositories.EnterpriseRepository;
import com.innovacode.InnovaCode.repositories.TransactionRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository repository;
    private EnterpriseRepository enterpriseRepository;

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
        Transaction newTransaction = getTransactionById(id);
        newTransaction.setId(id);
        if(transaction.getConcept() != null) newTransaction.setConcept(transaction.getConcept());
        //if(transaction.getAmount() != null)
        newTransaction.setAmount(transaction.getAmount());
        if(transaction.getEnterprise() != null) newTransaction.setEnterprise(transaction.getEnterprise());
        return this.repository.save(newTransaction);
    }

    public void deleteTransaction(Long id){
        this.repository.deleteById(id);
    }

    public List<Transaction> getTransactionByEnterprise(Long id){
        Enterprise enterprise = new Enterprise();
        enterprise.setId(id);
        return this.repository.findByEnterprise(enterprise);
    }

    public List<Transaction> getTransactionByEmployee(Long id){
        Employee employee = new Employee();
        employee.setId(id);
        return this.repository.findByEmployee(employee);
    }

}
