package com.luv2code.springboot.cruddemo.service.Impl;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeDAO employeeDAO;
  @Autowired
  public EmployeeServiceImpl(EmployeeDAO employeeDAO){
    this.employeeDAO = employeeDAO;
  }
  @Override
  public List<Employee> findAll() {
    return employeeDAO.findAll();
  }

  @Override
  public Employee getEmployeeById(Integer id) {
    return employeeDAO.getEmployeeById(id);
  }

  @Transactional
  @Override
  public Employee save(Employee employee) {
    Employee save = employeeDAO.save(employee);
    return save;
  }
  @Transactional
  @Override
  public void delete(int id) {
    employeeDAO.delete(id);
  }
}
