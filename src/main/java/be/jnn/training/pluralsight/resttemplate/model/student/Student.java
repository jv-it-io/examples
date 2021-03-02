package be.jnn.training.pluralsight.resttemplate.model.student;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("student")
public class Student {

    private final Integer studentId;
    private final String studentName;


    public Student(Integer studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }
}
