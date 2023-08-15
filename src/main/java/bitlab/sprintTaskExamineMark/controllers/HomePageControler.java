package bitlab.sprintTaskExamineMark.controllers;

import bitlab.sprintTaskExamineMark.db.DBmanager;
import bitlab.sprintTaskExamineMark.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class HomePageControler {
    @GetMapping("/")
    public String homaPage(Model model){
        List<Student> students = DBmanager.getStudents();
        model.addAttribute("students", students);
        return "main";
    }
    @GetMapping("/add-student")
    public String addStudentPage(){
        return "add-student";
    }

    @PostMapping("/add-student")
    public String addStudent(Student student){
        DBmanager.addStudent(student);
        return "redirect:/";
    }

}
