package be.jnn.training.pluralsight.solid.singleresponsibility.service;

import be.jnn.training.pluralsight.solid.singleresponsibility.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeFileSerializer {

    public String serialize(Employee employee){
        StringBuilder sb = new StringBuilder();
        sb.append("#### EMPLOYEE RECORD ####");
        sb.append(System.lineSeparator());
        sb.append("NAME: ");
        sb.append(employee.getFirstName() + " " + employee.getLastName());
        sb.append(System.lineSeparator());
        sb.append("POSITION:");
        sb.append(employee.getClass().getTypeName());
        sb.append(System.lineSeparator());
        sb.append("EMAIL:");
        sb.append(employee.getEmail());
        sb.append(System.lineSeparator());
        sb.append("Monthly WAGE:");
        sb.append(employee.getMonthlyIncome());
        sb.append(System.lineSeparator());

        return sb.toString();
    }
}
