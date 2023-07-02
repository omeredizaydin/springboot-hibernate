package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO {
  private EntityManager entityManager;

  @Autowired
  public StudentDAOImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public void save(Student student) {
    entityManager.persist(student);

  }

  @Override
  public Student findById(Integer id) {
    return entityManager.find(Student.class, id);
  }

  @Override
  public List<Student> findAll() {
    //create query
    TypedQuery<Student> selectFromStudent =
        entityManager.createQuery("FROM Student", Student.class);

    List<Student> resultList = selectFromStudent.getResultList();

    // return query results
    return resultList;
  }

  @Override
  public List<Student> findByLastName(String lastName) {

    TypedQuery<Student> theQuery =
        entityManager.createQuery("FROM Student where lastName=:theData", Student.class);
    theQuery.setParameter("theData", lastName);
    List<Student> resultList = theQuery.getResultList();

    return resultList;
  }

  @Override
  @Transactional
  public void update(Student student) {
    entityManager.merge(student);
  }

  @Override
  @Transactional
  public void delete(Integer id) {
    Student theStudent = entityManager.find(Student.class, id);
    entityManager.remove(theStudent);
  }

  @Override
  @Transactional
  public int deleteAll() {
    int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
    return numRowsDeleted;
  }
}
