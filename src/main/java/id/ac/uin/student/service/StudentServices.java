package id.ac.uin.student.service;

import id.ac.uin.student.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentServices {
    List<Student> getAllStudent();

    Optional<Student> findById(Long id);

    Optional<Student> findByEmail(String email);

    Student save(Student newStd);

    void deleteById(Long id);
}
