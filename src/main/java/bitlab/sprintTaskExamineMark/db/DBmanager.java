package bitlab.sprintTaskExamineMark.db;

import bitlab.sprintTaskExamineMark.models.Student;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class DBmanager {
    @Getter
    static List<Student> students = new ArrayList<>();
    private static Long id = 3L;

    static{
        Student student = Student.builder().id(1L).name("Timur").surname("Batyrov").exam(77).mark("A").build();
        Student student2 = Student.builder().id(2L).name("Dondo").surname("Kachkovich").exam(100).mark("A").build();

        students.add(student);
        students.add(student2);
    }

    public static void addStudent(Student student){
        student.setId(id);
        id++;
        if (student.getExam() >= 90){
            student.setMark("A");
        } else if (student.getExam() >= 75){
            student.setMark("B");
        } else if(student.getExam() >= 60){
            student.setMark("C");
        } else if(student.getExam() >= 50){
            student.setMark("D");
        } else {
            student.setMark("F");
        }
        students.add(student);
    }

}
