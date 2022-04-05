package id.ac.uin.student.controller;

import id.ac.uin.student.exception.StudentNotFoundException;
import id.ac.uin.student.entity.Student;
import id.ac.uin.student.service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentServices studentservices;

    @Autowired
    public StudentController(StudentServices studentservices){
        this.studentservices = studentservices;
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return studentservices.getAllStudent();
    }

    @GetMapping(value = "/{id}")
    public Student getStudentById(@PathVariable("id") @Min(1) Long id){
        Student std = studentservices.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with "+ id + " is Not Found!"));
        return std;
    }

    @PostMapping
    public Student addStudent(@Valid @RequestBody Student std) {
        return studentservices.save(std);
    }

    @PutMapping(value = "/{id}")
    public Student updateStudent(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody Student newStd){
        Student student =studentservices.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with " + id + "is Not Found!"));
        student.setFirstName(newStd.getFirstName());
        student.setLastName(newStd.getLastName());
        student.setEmail(newStd.getEmail());
        student.setPhoneNumber(newStd.getPhoneNumber());
        return studentservices.save(student);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteStudent(@PathVariable("id") @Min(1) Long id){
        Student std = studentservices.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with "+ id + "is Not Found!"));
        studentservices.deleteById(std.getId());
        return "Student with ID :" + id + " is deleted";
    }
}
