package com.niraj.learningrestapi.service.impl;

import com.niraj.learningrestapi.model.Employee;
import com.niraj.learningrestapi.repository.EmployeeRepository;
import com.niraj.learningrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "name");
        return employeeRepository.findAll(pages).getContent();
    }

    /*
    @Override
    public List<Employee> getEmployeesByNameOrLocation(String name, String location) {
        return employeeRepository.getEmployeesByNameOrLocation(name, location);
    }

     */

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
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getByDepartmentName(String name) {
        return employeeRepository.getemployeesByDepartmentName(name);
    }

    /*
    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeesByNameContaining(String name) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return employeeRepository.findByNameContaining(name, sort);
    }

    @Override
    public List<Employee> getEmployeesByNameAndLocation(String name, String location) {

        return employeeRepository.findByNameAndLocation(name, location);
    }

    @Override
    public Integer deleteEmployeesByNameMyImpl(String name) {
        return employeeRepository.deleteEmployeeByNameMyImpl(name);
    }

     */
}
