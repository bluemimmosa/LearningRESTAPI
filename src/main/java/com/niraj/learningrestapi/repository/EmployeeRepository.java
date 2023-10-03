package com.niraj.learningrestapi.repository;

import com.niraj.learningrestapi.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    public List<Employee> findByName(String name);
    //findByFiledName()

    //SELECT * FROM table WHERE name="niraj" AND location="NEPAL";
    public List<Employee> findByNameAndLocation(String name, String location);

    //SELECT * FROM table WHERE name LIKE %ram%;
    public List<Employee> findByNameContaining(String name, Sort sort);

    //JPQL query
    @Query("FROM Employee WHERE name = :name OR location = :location")
    public List<Employee> getEmployeesByNameOrLocation(String name, String location);
}
