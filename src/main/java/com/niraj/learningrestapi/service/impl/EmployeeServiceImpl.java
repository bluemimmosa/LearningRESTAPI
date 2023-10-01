package com.niraj.learningrestapi.service.impl;

import com.niraj.learningrestapi.model.Employee;
import com.niraj.learningrestapi.repository.EmployeeRepository;
import com.niraj.learningrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(Long id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        if(emp.isPresent()){
            return emp.get();
        }
        throw new RuntimeException("Couldnt find the emnployee for the id: "+id);

    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee editEmployee(Employee employee) {
        Employee emp = employeeRepository.findById(employee.getId()).get();
        emp.setName(employee.getName());
        emp.setAge(employee.getAge());
        emp.setDepartment(employee.getDepartment());
        emp.setEmail(employee.getEmail());
        emp.setLocation(employee.getLocation());

        return employeeRepository.save(emp);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
