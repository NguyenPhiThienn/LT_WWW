package iuh.fit.se.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "EMPLOYEE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "First Name không được phép rỗng!")
    private String firstName;

    @NotEmpty(message = "Last Name không được phép rỗng!")
    private String lastName;

    @Email(message = "Email không hợp lệ!")
    @NotEmpty(message = "Email không được phép rỗng!")
    private String email;

    @NotNull(message = "Date of Birth không được phép rỗng!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;

    @NotNull(message = "Phone Number không được phép rỗng!")
    @Min(value = 100000000, message = "Số điện thoại không hợp lệ!")
    private Integer phone;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Gender không được phép rỗng!")
    private Gender gender;

    @NotEmpty(message = "Address không được phép rỗng!")
    private String address;
}
