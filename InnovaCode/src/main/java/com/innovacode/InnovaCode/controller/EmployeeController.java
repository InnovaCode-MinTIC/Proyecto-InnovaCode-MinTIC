package com.innovacode.InnovaCode.controller;

import com.innovacode.InnovaCode.entity.Employee;
import com.innovacode.InnovaCode.entity.Enterprise;
import com.innovacode.InnovaCode.service.EmployeeService;
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
//    public List<Employee> employeeList(){
//        return this.service.listEmployee();
//    }
//
//    @PostMapping("/users")
//    public Employee createEmployee(@RequestBody Employee employee){
//        return this.service.saveEmployee(employee);
//    }
//
//    @GetMapping("/users/{id}")
//    public Employee employeeById(@PathVariable Long id){
//        return this.service.getEmployee(id);
//    }
//
//    @PatchMapping("/users/{id}")
//    public Employee updateEmployee(@PathVariable Employee employee){
//        return this.service.updateEmployee(employee);
//    }
//
//    @DeleteMapping("/users/{id}")
//    public void deleteEmployeeById(@PathVariable Long id){
//        this.service.deleteEmployee(id);
//    }


    @GetMapping({"/employee"})
    public String listarEmpleados(Model modelo){
        modelo.addAttribute("employee", service.listEmployee());
        return "EmployeeList";
    }
    @GetMapping("/employee/create")
    public String FormCreateEmployee(Model modelo){
        Employee employee = new Employee();
        modelo.addAttribute("employee", employee);
        return "EmployeeCreate";
    }

    @PostMapping("/employee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        service.saveEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/employee/edit/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("employee", service.getEmployee(id));
        return "employeeEdit";
    }

    @PostMapping("/employee/{id}")
    public String updateEmployee(@PathVariable Long id,@ModelAttribute("employee") Employee employee,Model modelo){
        Employee employeeExistente = service.getEmployee(id);
        employeeExistente.setId(id);
        employeeExistente.setEmail(employee.getEmail());
        employeeExistente.setProfile(employee.getProfile());
        employeeExistente.setRole(employee.getRole());
        employeeExistente.setEnterprise(employee.getEnterprise());
        service.updateEmployee(employeeExistente);
        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}")
    public String deleteEnterprises(@PathVariable Long id) {
        service.deleteEmployee(id);
        return  "redirect:/enterprises";
    }
}
