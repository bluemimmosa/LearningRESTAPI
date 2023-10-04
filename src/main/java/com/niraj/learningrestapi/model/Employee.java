package com.niraj.learningrestapi.model;

import com.niraj.learningrestapi.request.EmployeeRequest;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.DefaultApplicationArguments;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Setter
@Getter
@ToString
@Entity
@Table(name="tbl_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @NotBlank(message = "Name should not be null!!!")
    @Column(name="name")
    private String name;
    @JoinColumn(name = "department_id")
    @OneToOne
    private Department department;

    public Employee(EmployeeRequest req){
        this.name = req.getName();
    }

    //@JsonIgnore // to ignore the name value pair so it gets hidden in json response.

}
