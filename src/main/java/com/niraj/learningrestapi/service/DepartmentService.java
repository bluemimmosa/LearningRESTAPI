package com.niraj.learningrestapi.service;

import com.niraj.learningrestapi.model.Department;
import com.niraj.learningrestapi.model.Employee;

import java.util.List;

public interface DepartmentService {
    public List<Department> getDepartments(int pageNumber, int pageSize);
    public Department findDepartmentById(Long id);
    public Department createDepartment(Department department);
    public Department editDepartment(Department department);

    void deleteDepartment(Long id);
}
