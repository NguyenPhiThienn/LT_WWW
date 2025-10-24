package fit.iuh.se.bai2;

import java.util.List;

import fit.iuh.se.bai2.entities.Employee;
import fit.iuh.se.bai2.repositories.EmployeeRepository;
import fit.iuh.se.bai2.services.EmployeeService;
import fit.iuh.se.bai2.services.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Bai2Application {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(Bai2Application.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {

			EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository);

			// Tạo và thêm mới nhân viên
			Employee emp1 = new Employee(0, "Thiên", "nguyenphithien1@gmail.com");
			Employee emp2 = new Employee(1, "Thiên", "nguyenphithien2@gmail.com");
			Employee emp3 = new Employee(2, "Thiên", "nguyenphithien3@gmail.com");
			Employee emp4 = new Employee(3, "Thiên", "nguyenphithien4@gmail.com");

			Employee savedEmployee1 = employeeService.insert(emp1);
			Employee savedEmployee2 = employeeService.insert(emp2);
			Employee savedEmployee3 = employeeService.insert(emp3);
			Employee savedEmployee4 = employeeService.insert(emp4);

			System.out.println("✅ ĐÃ THÊM NHÂN VIÊN: " + savedEmployee1);

			// Lấy tất cả nhân viên
			System.out.println("\n--- DANH SÁCH TẤT CẢ NHÂN VIÊN ---");
			List<Employee> employees = employeeService.findAll();
			employees.forEach(System.out::println);

			// Tìm nhân viên theo ID
			System.out.println("\n--- TÌM NHÂN VIÊN CÓ ID: " + savedEmployee1.getEmployeeId() + " ---");
			Employee employee2 = employeeService.findById(savedEmployee1.getEmployeeId());
			System.out.println("👉 Đã tìm thấy nhân viên có ID: " + employee2.getEmployeeId());

			// Cập nhật thông tin nhân viên
			System.out.println("\n--- CẬP NHẬT NHÂN VIÊN CÓ ID: " + savedEmployee1.getEmployeeId() + " ---");
			savedEmployee1.setEmployeeRole("Vai trò mới");
			employeeService.insert(savedEmployee1); // hoặc employeeService.update(savedEmployee1) nếu có phương thức update
			System.out.println("✅ Đã cập nhật nhân viên ID: " + savedEmployee1.getEmployeeId());

			// Hiển thị lại danh sách sau khi cập nhật
			System.out.println("\n--- DANH SÁCH NHÂN VIÊN SAU KHI CẬP NHẬT ---");
			employeeService.findAll().forEach(System.out::println);

			// Xoá nhân viên
			System.out.println("\n--- XOÁ NHÂN VIÊN CÓ ID: " + savedEmployee1.getEmployeeId() + " ---");
			boolean isDeleted = employeeService.delete(savedEmployee1.getEmployeeId());
			System.out.println("🗑️ Đã xoá nhân viên: " + isDeleted);

			// Hiển thị lại danh sách sau khi xoá
			System.out.println("\n--- DANH SÁCH NHÂN VIÊN SAU KHI XOÁ ---");
			employeeService.findAll().forEach(System.out::println);
		};
	}
}
