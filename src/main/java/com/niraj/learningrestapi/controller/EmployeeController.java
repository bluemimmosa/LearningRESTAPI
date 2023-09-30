package com.niraj.learningrestapi.controller;

import com.niraj.learningrestapi.model.Employee;
import com.niraj.learningrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    //used for reading application.properties key value pairs.
    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/version")
    public String getAppDetails(){
        return "The app anme is "+appName+" and the version is "+appVersion;
    }
    @GetMapping("/all")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public String getEmployee(@PathVariable("id") Long id){
        return "fetching the employee details for the id "+id;
    }

    @DeleteMapping("/delete")
    public String deleteEmployee(@RequestParam("id") Long id){
        return "Succesffully deleted emplopyee with id "+id;
    }


    @PutMapping("/edit/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        System.out.println("Updating the employee data for the id: "+id);
        return employee;
    }
    @PostMapping("/add")
    public String saveEmployee(@RequestBody Employee employee){
        return "Saving the meplopyee details tot he databese. "+employee;
    }
}
