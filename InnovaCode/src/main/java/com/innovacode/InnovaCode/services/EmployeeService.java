package com.innovacode.InnovaCode.services;

import com.innovacode.InnovaCode.entities.Employee;
import com.innovacode.InnovaCode.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository){
        this.repository = repository;
    }

    public List<Employee> getEmployeeList(){
        return this.repository.findAll();
    }

    public Employee postEmployee(Employee employee){
        return this.repository.save(employee);
    }

    public Employee getEmployeeById(Long id){
        return this.repository.findById(id).get();
    }

    public Employee patchEmployee(Long id, Employee employee){
        Employee newEmployee = getEmployeeById(id);
        newEmployee.setId(id);
        if (employee.getEmail() != null) newEmployee.setEmail(employee.getEmail());
        if (employee.getPhone() != null) newEmployee.setEmail(employee.getPhone());
        if (employee.getImage() != null) newEmployee.setEmail(employee.getImage());
        if (employee.getRole() != null) newEmployee.setRole(employee.getRole());
        if (employee.getEnterprise() != null) newEmployee.setEnterprise(employee.getEnterprise());

        return this.repository.save(newEmployee);
    }

    public void deleteEmployee(Long id){
        this.repository.deleteById(id);
    }
}