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
      //createMultipleStudents(studentDAO);
      readStudent(studentDAO);

    };

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

  private void readStudent(StudentDAO studentDAO){
    System.out.println("### Creating new student object ###");
    Student tempStudent = new Student("Maide","Aydin","maideaydin@gmail.com");

    studentDAO.save(tempStudent);

    int theId = tempStudent.getId();
    System.out.println("### saved student. Generated id; "+theId);

    System.out.println("### Retrieving student with id; "+theId);
    Student myStudent = studentDAO.findById(tempStudent.getId());

    System.out.println("### Found the student: "+myStudent);


  }
}
