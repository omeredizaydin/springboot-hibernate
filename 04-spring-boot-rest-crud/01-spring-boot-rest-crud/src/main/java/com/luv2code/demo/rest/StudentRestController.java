package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentRestController {

  private List<Student> theStudents;

  // define @PostConstructor to load the student data... only once
  @PostConstruct
  public void loadData() {
    theStudents = new ArrayList<Student>();

    theStudents.add(new Student("Davut Can", "Aydin"));
    theStudents.add(new Student("Tupac", "Shakur"));
    theStudents.add(new Student("Maide", "Aydin"));
  }

  @GetMapping("/students")
  public List<Student> students() {
    return theStudents;
  }

  // define endpoint or "/students/{studentId}" - return student at index

  @GetMapping("/students/{studentId}")
  public Student getStudent(@PathVariable int studentId) {
    if (studentId >= theStudents.size() || studentId < 0) {
      throw new StudentNotFoundException("Student id not found - " + studentId);
    }
    return theStudents.get(studentId);
  }


}



