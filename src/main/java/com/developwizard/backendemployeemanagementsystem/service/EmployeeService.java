package com.developwizard.backendemployeemanagementsystem.service;

import com.developwizard.backendemployeemanagementsystem.entity.Employee;

import java.util.List;

public interface EmployeeService {
    /**
     * Retrieves all employees from DB
     *
     * @return Employee list
     */
    List<Employee> getAllEmployees();

    /**
     * Save employee into DB
     *
     * @param employee Employee
     * @return Saved Employee
     */
    Employee saveEmployee(Employee employee);

    /**
     * Retrieve employee by ID from DB
     *
     * @param id Employee ID
     * @return Employee
     */
    Employee findEmployeeById(Long id);
}
