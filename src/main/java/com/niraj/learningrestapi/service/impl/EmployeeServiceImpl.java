package com.niraj.learningrestapi.service.impl;

import com.niraj.learningrestapi.model.Employee;
import com.niraj.learningrestapi.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static List<Employee> list = new ArrayList<>();
    static{
        Employee e = new Employee(1L,"Niraj Khadka", 35L, "Kathmandu", "niraj.khadka.np@outlook.com", "Programming");
        list.add(e);
        Employee e1 = new Employee(2L,"Showraj Khadka", 30L, "Japan", "showraj@outlook.com", "QA");
        list.add(e1);
    }
    @Override
    public List<Employee> getEmployees() {
        return list;
    }
}
