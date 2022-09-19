package com.innovacode.InnovaCode.services;

import com.innovacode.InnovaCode.entities.Employee;
import com.innovacode.InnovaCode.entities.Enterprise;
import com.innovacode.InnovaCode.entities.Transaction;
import com.innovacode.InnovaCode.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.reactive.TransactionalOperator;

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
        if (employee.getPhone() != null) newEmployee.setPhone(employee.getPhone());
        if (employee.getImage() != null) newEmployee.setImage(employee.getImage());
        if (employee.getRole() != null) newEmployee.setRole(employee.getRole());
        if (employee.getEnterprise() != null) newEmployee.setEnterprise(employee.getEnterprise());

        return this.repository.save(newEmployee);
    }

    public void deleteEmployee(Long id){
        this.repository.deleteById(id);
    }

    public List<Employee> getEmployeeByEnterprise(Long id){
        Enterprise enterprise = new Enterprise();
        enterprise.setId(id);
        return this.repository.findByEnterprise(enterprise);
    }

}
