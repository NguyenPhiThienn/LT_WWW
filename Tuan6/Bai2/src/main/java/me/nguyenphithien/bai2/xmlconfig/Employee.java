package me.nguyenphithien.bai2.xmlconfig;

public class Employee {
    private int id;
    private String name;
    private Address address;

    public Employee() {}

    // Constructor injection
    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Setter injection
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAddress(Address address) { this.address = address; }

    public void showInfo() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Address: " + address);
    }
}
