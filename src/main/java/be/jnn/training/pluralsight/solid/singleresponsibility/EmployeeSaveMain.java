package be.jnn.training.pluralsight.solid.singleresponsibility;

import be.jnn.training.pluralsight.solid.singleresponsibility.logging.ConsoleLogger;
import be.jnn.training.pluralsight.solid.singleresponsibility.model.Employee;
import be.jnn.training.pluralsight.solid.singleresponsibility.repository.EmployeeRepository;
import be.jnn.training.pluralsight.solid.singleresponsibility.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class EmployeeSaveMain {



    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(EmployeeSaveMain.class, args);
        EmployeeSaveMain application = context.getBean(EmployeeSaveMain.class);

        application.start(args);
    }
    @Autowired
    EmployeeRepository employeeRepository;

    private void startNotConformed(String[] args) {
        List<Employee> all = employeeRepository.findAll();
        all.stream()
                .forEach(employee -> employee.save(employee));


    }

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ConsoleLogger consoleLogger;

    //Conform for SRP
    private void start(String[] args) {
        List<Employee> all = employeeRepository.findAll();
        all.stream()
                .forEach(employee -> {
                    try {
                        employeeService.save(employee);
                        consoleLogger.writeInfo("Employee saved:! " + employee.toString());
                    } catch (IOException e) {
                        consoleLogger.writeError("Error saving employee", e);
                    }
                });
    }
}
