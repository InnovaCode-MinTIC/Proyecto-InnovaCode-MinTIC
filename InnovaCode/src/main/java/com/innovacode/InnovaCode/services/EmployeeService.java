package com.innovacode.InnovaCode.services;

import com.innovacode.InnovaCode.entities.Employee;
import com.innovacode.InnovaCode.entities.Enterprise;
import com.innovacode.InnovaCode.entities.Transaction;
import com.innovacode.InnovaCode.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.reactive.TransactionalOperator;

import java.util.List;
import java.util.Map;

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

    public Long countEmployees(){
        return this.repository.count();
    };

    public Employee createUser(Employee newEmployee){
        return this.repository.save(newEmployee);
    }
    public Employee findEmployeeByEmail(String email){
        return this.repository.findByEmail(email);
    }
    public Employee getOrCreateUser(Map<String, Object> claims) {
        String email = (String) claims.get("email");
        Employee employee = findEmployeeByEmail(email);
        if(employee == null){
            String name = (String) claims.get("name");
            String image = (String) claims.get("picture");
            String auth0Id = (String) claims.get("sub");

            Employee newEmployee = new Employee(email = email, image = image, auth0Id=auth0Id);
            return createUser(newEmployee);
        }
        return employee;
    }

}
