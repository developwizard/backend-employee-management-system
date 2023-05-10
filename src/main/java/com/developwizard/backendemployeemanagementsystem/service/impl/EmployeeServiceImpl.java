package com.developwizard.backendemployeemanagementsystem.service.impl;

import com.developwizard.backendemployeemanagementsystem.entity.Employee;
import com.developwizard.backendemployeemanagementsystem.exception.ResourceNotFoundException;
import com.developwizard.backendemployeemanagementsystem.repository.EmployeeRepository;
import com.developwizard.backendemployeemanagementsystem.service.EmployeeService;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        val employeeFromDB = employeeRepository.findById(employee.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", employee.getId()));
        employeeFromDB.setFirstName(employee.getFirstName());
        employeeFromDB.setLastName(employee.getLastName());
        employeeFromDB.setEmailId(employee.getEmailId());
        return employeeRepository.save(employeeFromDB);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
