package com.niraj.learningrestapi.controller;

import com.niraj.learningrestapi.model.Employee;
import com.niraj.learningrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return "The app name is "+appName+" and the version is "+appVersion;
    }
    */
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam("pagenumber") Integer pageNumber, @RequestParam("pagesize") Integer pagesize){
        return new ResponseEntity<List<Employee>>(employeeService.getEmployees(pageNumber, pagesize), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id){
        return new ResponseEntity<Employee>(employeeService.findEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping("/filterByName")
    public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam("name") String name){
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByName(name), HttpStatus.OK);
    }

    @GetMapping("/filterByNameContaining")
    public ResponseEntity<List<Employee>> getEmployeeByNameContaining(@RequestParam("name") String name){
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByNameContaining(name), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping("/filterByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeeByNameAndLocation(@RequestParam("name") String name, @RequestParam("location") String location){
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByNameAndLocation(name, location), HttpStatus.OK);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        System.out.println("Updating the employee data for the id: "+id);
        employee.setId(id);
        return new ResponseEntity<Employee>(employeeService.editEmployee(employee), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }
}
