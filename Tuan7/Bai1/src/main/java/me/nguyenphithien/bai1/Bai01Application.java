package me.nguyenphithien.bai1;

import me.nguyenphithien.bai1.daos.EmployeeDAO;
import me.nguyenphithien.bai1.entities.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Bai01Application {
    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Bai01Application.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        System.out.println(dataSource.getConnection());
    }
    @Bean
    public CommandLineRunner run(EmployeeDAO employeeDAO) {
        return (args) -> {
            System.out.println("Creating employees");
            employeeDAO.save(new Employee(1, "Admin", "Phi Thien"));
            employeeDAO.save(new Employee(2, "Tester", "Quynh Nhu"));
            employeeDAO.save(new Employee(3, "User", "Peter Griffin"));
            System.out.println("\nFind all employees:");
            employeeDAO.findAll().forEach(System.out::println);
            System.out.println("\nGet employee with id 2:");
            System.out.println(employeeDAO.getById(2));
            System.out.println("\nUpdating employee with id 1...");
            Employee empToUpdate = employeeDAO.getById(1);
            if (empToUpdate != null) {
                empToUpdate.setName("John Doe Updated");
                employeeDAO.update(empToUpdate);
            }
            System.out.println("Find all employees after update:");
            employeeDAO.findAll().forEach(System.out::println);
            System.out.println("\nDeleting employee with id 3...");
            employeeDAO.deleteById(3);
            System.out.println("Find all employees after deletion:");
            employeeDAO.findAll().forEach(System.out::println);
        };
    }
}
