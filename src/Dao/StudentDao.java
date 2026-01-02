package Dao;

import Dto.StudentDto;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private static final List<StudentDto> students = new ArrayList<>();

    public static boolean addStudent(StudentDto studentDto) {
        students.add(studentDto);
        return true; // success
    }

    public static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\nID | Name | Grade");
        System.out.println("------------------");
        for (StudentDto s : students) {
            System.out.println(s.getId() + " | " + s.getName() + " | " + s.getGrade());
        }
    }

    public static void search(String id) {
        boolean found = false;
        for (StudentDto s : students) {
            if (s.getId().equals(id)) {
                System.out.println(s.getId() + " | " + s.getName() + " | " + s.getGrade());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found!");
        }
    }
}
