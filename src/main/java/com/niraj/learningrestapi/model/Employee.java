package com.niraj.learningrestapi.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
    @NotBlank(message = "Name should not be null!!!")
    @Column(name="name")
    private String name;
    //@JsonIgnore // to ignore the name value pair so it gets hidden in json response.
    @Column(name="age")
    private Long age = 0L;
    @NotEmpty(message = "Location should not be null!!!")
    @Column(name="location")
    private String location;
    @NotEmpty
    @Email(message = "Please input the valid email address!!")
    @Column(name="email")
    private String email;
    @NotEmpty(message = "Department should not be null!!!")
    @Column(name="department")
    private String department;
    @CreationTimestamp
    @Column(name="created_at", nullable = false, updatable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Column(name="updated_at", nullable = true, updatable = true)
    private Date updatedAt;
}
