package com.niraj.learningrestapi.service.impl;

import com.niraj.learningrestapi.model.Department;
import com.niraj.learningrestapi.repository.DepartmentRepository;
import com.niraj.learningrestapi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public List<Department> getDepartments(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Department findDepartmentById(Long id) {
        return null;
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department editDepartment(Department department) {
        return null;
    }

    @Override
    public void deleteDepartment(Long id) {

    }
}
