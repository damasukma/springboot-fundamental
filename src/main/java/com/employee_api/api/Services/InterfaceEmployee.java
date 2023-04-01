package com.employee_api.api.Services;

import java.util.List;
import java.util.Optional;

import com.employee_api.api.Model.Employee;

public interface InterfaceEmployee {
    Optional<Employee> findById(int id);
    Employee save(Employee employee);
    List<Employee>getAllEmployee();
}