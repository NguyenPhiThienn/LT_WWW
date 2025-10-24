package fit.iuh.se.bai2.repositories;

import fit.iuh.se.bai2.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}