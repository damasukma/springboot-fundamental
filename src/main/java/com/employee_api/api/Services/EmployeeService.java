package com.employee_api.api.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_api.api.Model.Employee;
import com.employee_api.api.Repositories.EmployeeRepository;

@Service
public class EmployeeService implements InterfaceEmployee{
    EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository emplRepo){
        this.employeeRepository = emplRepo;
    }

    @Override
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(int id)
    {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee){
        return this.employeeRepository.save(employee);
    }
}
