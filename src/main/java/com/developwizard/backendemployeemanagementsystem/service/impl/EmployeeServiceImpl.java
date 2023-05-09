package com.developwizard.backendemployeemanagementsystem.service.impl;

import com.developwizard.backendemployeemanagementsystem.entity.Employee;
import com.developwizard.backendemployeemanagementsystem.repository.EmployeeRepository;
import com.developwizard.backendemployeemanagementsystem.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
