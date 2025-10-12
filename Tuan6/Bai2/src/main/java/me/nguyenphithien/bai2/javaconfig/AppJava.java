package me.nguyenphithien.bai2.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppJava {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Employee emp = context.getBean(Employee.class);
        emp.showInfo();
    }
}
