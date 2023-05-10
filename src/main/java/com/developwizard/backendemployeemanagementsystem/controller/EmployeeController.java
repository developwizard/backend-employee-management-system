package com.developwizard.backendemployeemanagementsystem.controller;

import com.developwizard.backendemployeemanagementsystem.entity.Employee;
import com.developwizard.backendemployeemanagementsystem.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Get all employees
     *
     * @return Employee list
     */
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /**
     * Create new employee
     *
     * @param employee Employee to save
     * @return Employee
     */
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    /**
     * Find employee by id
     *
     * @param id Employee ID
     * @return Employee
     */
    @GetMapping("{id}")
    public Employee findEmployeeById(@PathVariable Long id) {
        return employeeService.findEmployeeById(id);
    }

    /**
     * Update employee
     *
     * @param employee Employee to update
     * @return Updated employee
     */
    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    /**
     * Delete employee by ID
     *
     * @param id Employee ID
     */
    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }
}
