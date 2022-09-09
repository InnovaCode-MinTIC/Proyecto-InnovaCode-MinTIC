package com.innovacode.InnovaCode.services;

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
//        Enterprise enterprise = new Enterprise();
//        enterprise = enterpriseRepository.findById(transaction.getEnterprise().getId()).get();
//        transaction.setEnterprise(enterprise);
        return this.repository.save(transaction);
    }

    public Transaction getTransactionById(Long id) {
        return this.repository.findById(id).get();
    }

    public Transaction patchTransaction(Long id, Transaction transaction){
        Transaction newTransaction = getTransactionById(id);
        newTransaction.setId(id);
        newTransaction.setConcept(transaction.getConcept());

        return this.repository.save(newTransaction);
    }

    public void deleteTransaction(Long id){
        this.repository.deleteById(id);
    }

    public Transaction getTransactionByEnterprise(Long id){
        Enterprise enterprise2 = new Enterprise();
        enterprise2 = enterpriseRepository.findById(id).get();

        return this.repository.findByEnterprise(Enterprise enterprise2);
    }
}
