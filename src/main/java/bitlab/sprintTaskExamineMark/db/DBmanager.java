package bitlab.sprintTaskExamineMark.db;

import bitlab.sprintTaskExamineMark.models.Student;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class DBmanager {
    @Getter
    static List<Student> students = new ArrayList<>();
    private static Long id = 10L;

    static{
        Student student = Student.builder().id(1L).name("Timur").surname("Batyrov").exam(77).build();
        Student student2 = Student.builder().id(2L).name("Dondo").surname("Kachkovich").exam(100).build();

        students.add(student);
        students.add(student2);
    }

    public static void addStudent(Student student){
        student.setId(id);
        id++;
        students.add(student);
    }

}
