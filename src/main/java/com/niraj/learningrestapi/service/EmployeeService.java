package com.niraj.learningrestapi.service;

import com.niraj.learningrestapi.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getEmployees();
    public Employee findEmployeeById(Long id);
    public Employee createEmployee(Employee employee);
    public Employee editEmployee(Employee employee);

    void deleteEmployee(Long id);
}
