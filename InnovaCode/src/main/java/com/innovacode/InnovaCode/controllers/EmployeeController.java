package com.innovacode.InnovaCode.controllers;

import com.innovacode.InnovaCode.entities.Employee;
import com.innovacode.InnovaCode.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    @GetMapping("/users")
    public List<Employee> getEmployeeList(){
        return this.service.getEmployeeList();
    }

    @PostMapping("/users")
    public Employee postEmployee(@RequestBody Employee employee){
        return this.service.postEmployee(employee);
    }

    @GetMapping("/users/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return this.service.getEmployeeById(id);
    }

    @PatchMapping("/users/{id}")
    public Employee patchEmployee(@PathVariable Long id,@RequestBody Employee employee){
        Employee newEmployee = this.service.getEmployeeById(id);
        return this.service.patchEmployee(newEmployee);
    }

    @DeleteMapping("/users/{id}")
    public void deleteEmployee(@PathVariable Long id){
        this.service.deleteEmployee(id);
    }
}
