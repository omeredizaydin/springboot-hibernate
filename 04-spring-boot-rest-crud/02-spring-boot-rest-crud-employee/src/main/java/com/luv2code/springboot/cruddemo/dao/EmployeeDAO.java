package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
  List<Employee> findAll();
  Employee getEmployeeById(Integer id);
  Employee save(Employee employee);
  void delete(int id);

}
