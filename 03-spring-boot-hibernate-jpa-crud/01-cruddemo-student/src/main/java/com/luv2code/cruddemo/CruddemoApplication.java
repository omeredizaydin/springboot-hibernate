package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.dao.StudentDAOImpl;
import com.luv2code.cruddemo.entity.Student;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {


  public static void main(String[] args) {
    SpringApplication.run(CruddemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
    return runner -> {
      //createStudent(studentDAO);
      createMultipleStudents(studentDAO);
      //readStudent(studentDAO);
      //queryForStudents(studentDAO);
      //queryForStudentsLastName(studentDAO);
      //updateStudent(studentDAO);
      //deleteStudent(studentDAO);
      //deleteAll(studentDAO);

    };

  }

  private void deleteAll(StudentDAO studentDAO) {
    System.out.println("### Deleting all students ###");
    int numRowsDeleted = studentDAO.deleteAll();
    System.out.println("### Affected rows: "+numRowsDeleted);
  }

  private void deleteStudent(StudentDAO studentDAO) {
    int studentId = 5;
    studentDAO.delete(studentId);
  }

  private void updateStudent(StudentDAO studentDAO) {
    //retrieve student based on the id : primary key
    int studentId = 4;
    System.out.println("Getting student with id: " + studentId);
    Student myStudent = studentDAO.findById(studentId);
    // change last name
    System.out.println("### Updating student ###");
    myStudent.setLastName("Kelkit Aydin");

    // update the student
    studentDAO.update(myStudent);

    //display the updated student
    System.out.println("### Updated student ###");
    System.out.println(myStudent);
  }

  private void queryForStudentsLastName(StudentDAO studentDAO) {
    List<Student> lastName = studentDAO.findByLastName("Aydin");

    for (Student student : lastName) {
      System.out.println(student);

    }
  }

  private void queryForStudents(StudentDAO studentDAO) {

    List<Student> all = studentDAO.findAll();

    for (Student student : all) {
      System.out.println(student);

    }

  }

  private void createMultipleStudents(StudentDAO studentDAO) {
    ArrayList<Student> students = new ArrayList<>();

    // create 3 students

    students.add(new Student("Davut", "Aydin", "davutcan@hkk.com"));
    students.add(new Student("Cemal", "Aydin", "cemal@gmail.com"));
    students.add(new Student("Beyza", "Kelkit", "beyza@tcdmimarlik.com"));

    // save the student object
    System.out.println("### Saving the students ### ");

    for (Student student : students) {
      studentDAO.save(student);
    }

  }

  private void createStudent(StudentDAO studentDAO) {

    System.out.println("### Creating new student object ###");
    Student tempStudent = new Student("Omer", "Aydin", "omer@cross4cloud.com");
    System.out.println("### Saving the student ###");
    studentDAO.save(tempStudent);
    System.out.println("Saved student. Generated id: " + tempStudent.getId());
  }

  private void readStudent(StudentDAO studentDAO) {
    System.out.println("### Creating new student object ###");
    Student tempStudent = new Student("Maide", "Aydin", "maideaydin@gmail.com");

    studentDAO.save(tempStudent);

    int theId = tempStudent.getId();
    System.out.println("### saved student. Generated id; " + theId);

    System.out.println("### Retrieving student with id; " + theId);
    Student myStudent = studentDAO.findById(tempStudent.getId());

    System.out.println("### Found the student: " + myStudent);


  }
}
