package me.nguyenphithien.bai2.annotationconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {
    private int id = 201;
    private String name = "Le Van C";

    @Autowired
    private Address address;

    public void showInfo() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Address: " + address);
    }
}
