package com.niraj.learningrestapi.service;

import com.niraj.learningrestapi.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getEmployees(int pageNumber, int pageSize);

    public List<Employee> getEmployeesByNameOrLocation(String name, String location);
    public Employee findEmployeeById(Long id);
    public Employee createEmployee(Employee employee);
    public Employee editEmployee(Employee employee);

    void deleteEmployee(Long id);

    public List<Employee> getEmployeesByName(String name);
    public List<Employee> getEmployeesByNameContaining(String name);

    public List<Employee> getEmployeesByNameAndLocation(String name, String location);
}
