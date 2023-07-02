package com.luv2code.springboot.cruddemo.dao.impl;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {
  private EntityManager entityManager;

  @Autowired
  public EmployeeDAOJPAImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Employee> findAll() {
    TypedQuery<Employee> fromEmployee = entityManager.createQuery("FROM Employee", Employee.class);
    List<Employee> resultList = fromEmployee.getResultList();
    return resultList;
  }

  @Override
  public Employee getEmployeeById(Integer id) {

    return entityManager.find(Employee.class,id);
  }

  @Override
  public Employee save(Employee employee) {
    Employee merge = entityManager.merge(employee);
    return merge;
  }

  @Override
  public void delete(int id) {
    Employee employee = entityManager.find(Employee.class, id);
    entityManager.remove(employee);
  }
}
