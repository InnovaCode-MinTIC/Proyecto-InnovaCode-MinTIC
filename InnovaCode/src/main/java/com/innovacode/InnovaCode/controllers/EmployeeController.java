package com.innovacode.InnovaCode.controllers;

import com.innovacode.InnovaCode.entities.Employee;
import com.innovacode.InnovaCode.services.EmployeeService;
import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

//    @GetMapping("/users")
//    public List<Employee> getEmployeeList(){
//        return this.service.getEmployeeList();
//    }
//    @PostMapping("/users")
//    public Employee postEmployee(@RequestBody Employee employee){
//        return this.service.postEmployee(employee);
//    }
//    @GetMapping("/users/{id}")
//    public Employee getEmployeeById(@PathVariable Long id){
//        return this.service.getEmployeeById(id);
//    }
//    @PatchMapping("/users/{id}")
//    public Employee patchEmployee(@PathVariable Long id,@RequestBody Employee employee){
//        return this.service.patchEmployee(id,employee);    }
//    @DeleteMapping("/users/{id}")
//    public void deleteEmployee(@PathVariable Long id){
//        this.service.deleteEmployee(id);
//    }

    @GetMapping("/users")
    public String ListUsers(Model model){
        model.addAttribute("employees", this.service.getEmployeeList());
        return "UsersList";
    }

    @GetMapping("/users/create")
    public String FormCreateUser (Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "UsersCreate";
    }

    @PostMapping("/users")
    public String saveUser(@ModelAttribute("employee") Employee employee){
        this.service.postEmployee(employee);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String FormEditUser(@PathVariable Long id, Model model){
        model.addAttribute("employee", this.service.getEmployeeById(id));
        return "UsersEdit";
    }

    @PostMapping("/users/{id}")
    public String patchUser(@PathVariable Long id, @ModelAttribute("employee") Employee employee, Model model){
        this.service.patchEmployee(id, employee);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id){
        this.service.deleteEmployee(id);
        return "redirect:/users";
    }
}
