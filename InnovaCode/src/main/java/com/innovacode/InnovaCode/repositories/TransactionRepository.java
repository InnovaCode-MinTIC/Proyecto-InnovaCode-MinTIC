package com.innovacode.InnovaCode.repositories;

import com.innovacode.InnovaCode.entities.Employee;
import com.innovacode.InnovaCode.entities.Enterprise;
import com.innovacode.InnovaCode.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByEnterprise(Enterprise enterprise);
    List<Transaction> findByEmployee(Employee employee);
}
