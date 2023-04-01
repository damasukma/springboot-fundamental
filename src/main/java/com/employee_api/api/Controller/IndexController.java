package com.employee_api.api.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee_api.api.Exceptions.EmployeeNotFoundException;
import com.employee_api.api.Model.Employee;
import com.employee_api.api.Services.EmployeeService;

@RestController
@RequestMapping("/api")
public class IndexController {
    EmployeeService employeeService;

    @Autowired
    public IndexController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public HashMap<String, List<Employee>> getEmployees(){
        HashMap map = new HashMap<String, List<Employee>>();
        List<Employee> data =  this.employeeService.getAllEmployee();
        map.put("data", data);
        return  map;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@Validated @RequestBody Employee employee)
    {
        return this.employeeService.save(employee);
        
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") @Min(1) int id)
    {
        Employee employee = this.employeeService.findById(id).orElseThrow(()->new EmployeeNotFoundException(id));
        return employee;
    }
}



