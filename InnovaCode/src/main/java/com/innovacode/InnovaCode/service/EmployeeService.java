package com.innovacode.InnovaCode.service;

import com.innovacode.InnovaCode.entity.Employee;
import com.innovacode.InnovaCode.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService{

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> listEmployee(){
        return repository.findAll();
    }

    public Employee saveEmployee(Employee employee){
        return repository.save(employee);
    }

    public Employee getEmployee(Long id){
        return repository.findById(id).get();
    }

    public Employee updateEmployee(Employee employee){
        return repository.save(employee);
    }

    public void deleteEmployee(Long id){
        repository.deleteById(id);
    }
}
