package com.niraj.learningrestapi.controller;

import com.niraj.learningrestapi.model.Employee;
import com.niraj.learningrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    /*
    //used for reading application.properties key value pairs.
    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/version")
    public String getAppDetails(){
        return "The app anme is "+appName+" and the version is "+appVersion;
    }
    */
    @GetMapping("/all")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") Long id){
        return employeeService.findEmployeeById(id);
    }

    @DeleteMapping("/delete")
    public void deleteEmployee(@RequestParam("id") Long id){
        employeeService.deleteEmployee(id);

    }


    @PutMapping("/edit/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        System.out.println("Updating the employee data for the id: "+id);
        employee.setId(id);
        return employeeService.editEmployee(employee);
    }
    @PostMapping("/add")
    public Employee saveEmployee(@Valid @RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }
}
