package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class EmployeeRestController {

  private EmployeeService employeeService;
  @Autowired
  public EmployeeRestController(EmployeeService employeeService){
    this.employeeService = employeeService;
  }
  @GetMapping("/employees")
  public List<Employee> findAll(){
    return employeeService.findAll();
  }
  @GetMapping("/employees/{id}")
  public Employee findById(@PathVariable int id){
    return employeeService.getEmployeeById(id);
  }

  @PostMapping(path = "employees")
  public ResponseEntity<Employee> create(@RequestBody Employee newEmployee){
    Employee employee = employeeService.save(newEmployee);
    return new ResponseEntity<>(employee, HttpStatus.CREATED);
  }
 @DeleteMapping("employees/{id}")
  public String delete(@PathVariable Integer id){
    employeeService.delete(id);
    return "Employee deleted from database: "+id;
  }
  @PutMapping("/employees")
  public Employee updateEmployee(@RequestBody Employee employee){
    Employee emp = employeeService.save(employee);
    return emp;

  }

}
