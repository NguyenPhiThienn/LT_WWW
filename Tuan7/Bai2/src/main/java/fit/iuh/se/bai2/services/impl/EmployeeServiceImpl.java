package fit.iuh.se.bai2.services.impl;

import fit.iuh.se.bai2.entities.Employee;
import fit.iuh.se.bai2.repositories.EmployeeRepository;
import fit.iuh.se.bai2.services.EmployeeService;

import javax.sql.DataSource;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee insert(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public boolean update(Employee employee) {
        employeeRepository.save(employee);
        return true;
    }

    @Override
    public boolean delete(int employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);

        if (employee != null) {
            employeeRepository.delete(employee);
            return true;
        }

        return false;
    }
}