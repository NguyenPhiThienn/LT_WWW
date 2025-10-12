package me.nguyenphithien.bai2.annotationconfig;

import org.springframework.stereotype.Component;

@Component
public class Address {
    private String city = "Ha Noi";
    private String state = "Ba Dinh";
    private String country = "Vietnam";

    @Override
    public String toString() {
        return city + ", " + state + ", " + country;
    }
}
