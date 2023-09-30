package com.niraj.learningrestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Employee {

    private Long id;
    private String name;
    //@JsonIgnore // to ignore the name value pair so it gets hidden in json response.
    private Long age;
    private String location;
    private String email;
    private String department;
}
