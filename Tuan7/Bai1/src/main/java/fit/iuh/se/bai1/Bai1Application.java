package fit.iuh.se.bai1;

import fit.iuh.se.bai1.daos.EmployeeDAO;
import fit.iuh.se.bai1.entities.Employee;
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
public class Bai1Application {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Bai1Application.class, args);

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		DataSource dataSource = context.getBean("dataSource", DataSource.class);

		System.out.println(dataSource.getConnection());
	}

	@Bean
	public CommandLineRunner run(EmployeeDAO employeeDAO) {
		return (args) -> {
			System.out.println("Đang tạo nhân viên...");
			employeeDAO.save(new Employee(1, "Admin", "Peter Griffin"));
			employeeDAO.save(new Employee(2, "User", "Glenn Quagmire"));
			employeeDAO.save(new Employee(3, "Tester", "Joe Swanson"));

			System.out.println("\nDanh sách tất cả nhân viên:");
			employeeDAO.findAll().forEach(System.out::println);

			System.out.println("\nLấy thông tin nhân viên có ID = 2:");
			System.out.println(employeeDAO.getById(2));

			System.out.println("\nCập nhật thông tin nhân viên có ID = 1...");
			Employee empToUpdate = employeeDAO.getById(1);
			if (empToUpdate != null) {
				empToUpdate.setName("Peter Griffin (Đã cập nhật)");
				employeeDAO.update(empToUpdate);
			}

			System.out.println("Danh sách nhân viên sau khi cập nhật:");
			employeeDAO.findAll().forEach(System.out::println);

			System.out.println("\nXoá nhân viên có ID = 3...");
			employeeDAO.deleteById(3);

			System.out.println("Danh sách nhân viên sau khi xoá:");
			employeeDAO.findAll().forEach(System.out::println);
		};
	}
}

