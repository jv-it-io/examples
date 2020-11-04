package be.jnn.training.pluralsight.solid.singleresponsibility.service;

import be.jnn.training.pluralsight.solid.singleresponsibility.model.Employee;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class EmployeeService {

    private final EmployeeFileSerializer employeeFileSerializer;

    public EmployeeService(EmployeeFileSerializer employeeFileSerializer) {
        this.employeeFileSerializer = employeeFileSerializer;
    }

    public void save(Employee employee) throws IOException {

        String serialize = employeeFileSerializer.serialize(employee);

        Path path = Paths.get(employee.getFullName().replace(" ", "_") + ".rec");
        Files.write(path, serialize.getBytes());

        System.out.println("Saved employee " + employee.toString());

    }


}
