package com.niraj.learningrestapi.repository;

import com.niraj.learningrestapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    public List<Employee> findByName(String name);
    //findByFiledName()

    //SELECT * FROM table WHERE name="niraj" AND location="NEPAL";
    public List<Employee> findByNameAndLocation(String name, String location);
    public List<Employee> findByNameContaining(String name);
}
