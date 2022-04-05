package id.ac.uin.student.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(name ="first_name")
    private String firstName;

    @NotEmpty
    @Column(name ="last_name")
    private String lastName;

    @NotNull(message = "please enter your birthdate")
    @Past(message = "Birth date should be lsee than current date!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;


    @NotEmpty
    @Column(name ="email", unique = true)
    private String email;

    @NotEmpty
    @Column(name ="phone_number", unique = true)
    private String phoneNumber;

    @NotEmpty
    @Column(name ="jurusan", unique = true)
    private String jurusan;
}
