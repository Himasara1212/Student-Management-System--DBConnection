import Dao.StudentDao;
import Dao.TeacherDao;
import Dao.SubjectDao;
import Dto.StudentDto;
import Dto.TeacherDto;
import Dto.SubjectDto;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static String userName = "admin";
    static String password = "1234";
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        if (login()) {
            welcome();
            mainMenu();
        } else {
            System.out.println("Invalid Username or Password");
        }
    }

    private static boolean login() {
        System.out.print("Enter Username: ");
        String u = input.nextLine();
        System.out.print("Enter Password: ");
        String p = input.nextLine();
        return u.equals(userName) && p.equals(password);
    }

    private static void welcome() {
        System.out.println("\n+------------------------------------------+");
        System.out.println("|         Student Management System        |");
        System.out.println("+------------------------------------------+\n");
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("""
                    1. Manage Students
                    2. Manage Teachers
                    3. Manage Subjects
                    4. Exit
                    """);
            System.out.print("Enter Choice: ");
            int c = input.nextInt();
            input.nextLine();

            switch (c) {
                case 1 -> studentMenu();
                case 2 -> teacherMenu();
                case 3 -> subjectMenu();
                case 4 -> { System.out.println("Exit.."); return; }
                default -> System.out.println("Invalid Choice");
            }
        }
    }

    private static void studentMenu() {
        while (true) {
            System.out.println("""
                    1. Add Student
                    2. View All Students
                    4. Exit
                    """);
            System.out.print("Choice: ");
            int c = input.nextInt();
            input.nextLine();

            switch (c) {
                case 1 -> {
                    String id = "S" + new Random().nextInt(99999);
                    System.out.print("Enter Name: ");
                    String name = input.nextLine();
                    System.out.print("Enter Grade: ");
                    int grade = input.nextInt();
                    input.nextLine();
                    StudentDao.addStudent(new StudentDto(id, name, grade));
                }
                case 2 -> StudentDao.viewAllStudents();
                case 4 -> { return; }
                default -> System.out.println("Invalid Choice");
            }
        }
    }

    private static void teacherMenu() {
        while (true) {
            System.out.println("""
                    1. Add Teacher
                    2. View All Teachers
                    4. Exit
                    """);
            System.out.print("Choice: ");
            int c = input.nextInt();
            input.nextLine();

            switch (c) {
                case 1 -> {
                    String id = "T" + new Random().nextInt(99999);
                    System.out.print("Enter Name: ");
                    String name = input.nextLine();
                    System.out.print("Enter Subject: ");
                    String subject = input.nextLine();
                    TeacherDao.addTeacher(new TeacherDto(id, name, subject));
                }
                case 2 -> TeacherDao.viewAllTeachers();
                case 4 -> { return; }
                default -> System.out.println("Invalid Choice");
            }
        }
    }

    private static void subjectMenu() {
        while (true) {
            System.out.println("""
                    1. Add Subject
                    2. View All Subjects
                    4. Exit
                    """);
            System.out.print("Choice: ");
            int c = input.nextInt();
            input.nextLine();

            switch (c) {
                case 1 -> {
                    String id = "Sub" + new Random().nextInt(99999);
                    System.out.print("Enter Subject Name: ");
                    String name = input.nextLine();
                    SubjectDao.addSubject(new SubjectDto(id, name));
                }
                case 2 -> SubjectDao.viewAllSubjects();
                case 4 -> { return; }
                default -> System.out.println("Invalid Choice");
            }
        }
    }
}
