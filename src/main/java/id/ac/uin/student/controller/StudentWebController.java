package id.ac.uin.student.controller;


import id.ac.uin.student.entity.Student;
import id.ac.uin.student.service.StudentServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class StudentWebController {
    private StudentServices studentServices;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("student", studentServices.getAllStudent());
        return "index";
    }

    @GetMapping(value = "/create")
    public String create1(Model model){
        model.addAttribute("student", new Student());
        return "formStudent";
    }

    @PostMapping(value = "/create")
    public String addStudent(Model model, Student student){
        model.addAttribute("student", studentServices.save(student));
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editForm(@PathVariable Long id, Model model){
        model.addAttribute("student", studentServices.findById(id));
        return "formStudent";
    }

    @GetMapping(value = "/hapus/{id}")
    public String hapusStudent(@PathVariable Long id){
        studentServices.deleteById((id));
        return "redirect:/";
    }
}



