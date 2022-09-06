package com.innovacode.InnovaCode.controller;

import com.innovacode.InnovaCode.entity.Employee;
import com.innovacode.InnovaCode.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/users")
    public List<Employee> employeeList(){
        return this.service.listEmployee();
    }

    @PostMapping("/users")
    public Employee createEmployee(@RequestBody Employee employee){
        return this.service.saveEmployee(employee);
    }

    @GetMapping("/users/{id}")
    public Employee employeeById(@PathVariable Long id){
        return this.service.getEmployee(id);
    }

    @PatchMapping("/users/{id}")
    public Employee updateEmployee(@PathVariable Employee employee){
        return this.service.updateEmployee(employee);
    }

    @DeleteMapping("/users/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
        this.service.deleteEmployee(id);
    }

}
