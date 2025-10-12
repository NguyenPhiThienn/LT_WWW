package me.nguyenphithien.bai2.annotationconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("fit.iuh.Bai2.annotationconfig")
public class AppAnnotation {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppAnnotation.class);
        Employee emp = context.getBean(Employee.class);
        emp.showInfo();
    }
}
