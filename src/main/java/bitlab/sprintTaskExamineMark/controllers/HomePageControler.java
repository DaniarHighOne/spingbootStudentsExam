package bitlab.sprintTaskExamineMark.controllers;

import bitlab.sprintTaskExamineMark.db.DBmanager;
import bitlab.sprintTaskExamineMark.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/details/{id}")
    public String detailsPage(@PathVariable Long id, Model model){
        Student student = DBmanager.getStudentByid(id);
        model.addAttribute("student", student);
        return "details";
    }

    @PostMapping("/edit-student")
    public String editStudent(@RequestParam(name="student_id") Long id,
                              @RequestParam(name="student_name") String name,
                              @RequestParam(name="student_surname") String surname,
                              @RequestParam(name="student_exam") Integer exam)
    {
        DBmanager.editStudent(id, name,surname, exam);
        return "details";

    }

}
