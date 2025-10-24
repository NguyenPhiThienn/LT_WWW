package fit.iuh.se.bai2.services;

import fit.iuh.se.bai2.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee insert(Employee employee);
    public List<Employee> findAll();
    public Employee findById(int id);
    public boolean update(Employee employee);
    public boolean delete(int employeeId);
}