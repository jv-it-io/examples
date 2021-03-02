package be.jnn.training.pluralsight.resttemplate.controller;

import be.jnn.training.pluralsight.resttemplate.model.student.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> students = Arrays.asList(
            new Student(1, "Joseph Joestar"),
            new Student(2, "Josuke"),
            new Student(3, "Giorno")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer id){
        return students.stream()
                .filter(student -> id.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + id + " doesn't exist"));
    }
}
