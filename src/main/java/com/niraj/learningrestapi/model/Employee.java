package com.niraj.learningrestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
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
    @Column(name="name")
    private String name;
    //@JsonIgnore // to ignore the name value pair so it gets hidden in json response.
    @Column(name="age")
    private Long age;
    @Column(name="location")
    private String location;
    @Column(name="email")
    private String email;
    @Column(name="department")
    private String department;
}
