package com.jdbcproject.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jdbcproject.demo.model.Student;
import com.jdbcproject.demo.service.StudentService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		Student s = context.getBean(Student.class);
		s.setMarks((78));
		s.setName("Hibbaan");
		s.setRollNo(101);
		StudentService service = context.getBean(StudentService.class);
		service.addStudent(s);
		List<Student> students = service.getStudents();
		System.out.println(students);
	}

}
