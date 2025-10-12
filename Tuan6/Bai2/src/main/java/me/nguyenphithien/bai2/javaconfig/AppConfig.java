package me.nguyenphithien.bai2.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Address address() {
        return new Address("Da Nang", "Hai Chau", "Vietnam");
    }

    @Bean
    public Employee employee() {
        return new Employee(301, "Pham Thi D", address());
    }
}
