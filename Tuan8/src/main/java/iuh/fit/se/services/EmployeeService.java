package iuh.fit.se.services;

import iuh.fit.se.entities.Employee;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);
    List<Employee> getAll();
    Employee getById(int id);
    void delete(int id);
}

