package be.jnn.training.pluralsight.solid.singleresponsibility.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Employee {

    private String firstName;
    private String monthlyIncome;
    private String email;
    private String lastName;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    //Not conform for SRP
    // ---> seperate part of the code in others classes
    //Mathod is Not in the good class --> employeeService
    //Create a serializer file class for employee -->
    //Create a loging class -->
    public static void save(Employee employee) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("#### EMPLOYEE RECORD ####");
            sb.append(System.lineSeparator());
            sb.append("NAME: ");
            sb.append(employee.firstName + " " + employee.lastName);
            sb.append(System.lineSeparator());
            sb.append("POSITION:");
            sb.append(employee.getClass().getTypeName());
            sb.append(System.lineSeparator());
            sb.append("EMAIL:");
            sb.append(employee.email);
            sb.append(System.lineSeparator());
            sb.append("Monthly WAGE:");
            sb.append(employee.monthlyIncome);
            sb.append(System.lineSeparator());

            Path path = Paths.get(employee.getFullName().replace(" ", "_") + ".rec");
            Files.write(path, sb.toString().getBytes());

            System.out.println("Saved employee " + employee.toString());
        } catch (IOException e) {
            System.out.println("" + e.getMessage());
        }
    }
}
