package me.nguyenphithien.bai2.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppXML {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_bai2.xml");

        System.out.println("--- Setter Injection ---");
        Employee emp1 = (Employee) context.getBean("employeeSetter");
        emp1.showInfo();

        System.out.println("\n--- Constructor Injection ---");
        Employee emp2 = (Employee) context.getBean("employeeConstructor");
        emp2.showInfo();
    }
}
