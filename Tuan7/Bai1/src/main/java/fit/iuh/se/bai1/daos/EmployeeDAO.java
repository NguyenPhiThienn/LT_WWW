package fit.iuh.se.bai1.daos;

import fit.iuh.se.bai1.entities.Employee;

import java.util.List;

public interface EmployeeDAO {
    public void update (Employee employee);
    public List<Employee> findAll ();
    public Employee getById (int id);
    public void deleteById (int id);
    public void save (Employee employee);
}
