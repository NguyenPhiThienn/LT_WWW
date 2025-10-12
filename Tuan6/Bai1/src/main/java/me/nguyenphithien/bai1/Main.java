package me.nguyenphithien.bai1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static ApplicationContext context;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("beans.xml");
        Student student1 = context.getBean("student1", Student.class);
        System.out.println(student1);
    }
}
