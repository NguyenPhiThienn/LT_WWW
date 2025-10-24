package fit.iuh.se.bai1.daos.impl;

import fit.iuh.se.bai1.daos.EmployeeDAO;
import fit.iuh.se.bai1.entities.Employee;

import javax.sql.DataSource;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private DataSource dataSource;

    public EmployeeDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        // Create table if not exists
        try (var conn = dataSource.getConnection();
             var stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS employee (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(255), " +
                    "role VARCHAR(255))";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE employee SET name = ?, role = ? WHERE id = ?";
        try (var conn = dataSource.getConnection();
             var ps = conn.prepareStatement(sql)) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getRole());
            ps.setInt(3, employee.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT id, name, role FROM employee";
        try (var conn = dataSource.getConnection();
             var ps = conn.prepareStatement(sql);
             var rs = ps.executeQuery()) {
            List<Employee> list = new java.util.ArrayList<>();
            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("role"),
                        rs.getString("name")
                );
                list.add(emp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return java.util.Collections.emptyList();
    }

    @Override
    public Employee getById(int id) {
        String sql = "SELECT id, name, role FROM employee WHERE id = ?";
        try (var conn = dataSource.getConnection();
             var ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (var rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Employee(
                            rs.getInt("id"),
                            rs.getString("role"),
                            rs.getString("name")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        try (var conn = dataSource.getConnection();
             var ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO employee (id, name, role) VALUES (?, ?, ?)";
        try (var conn = dataSource.getConnection();
             var ps = conn.prepareStatement(sql)) {
            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getRole());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
