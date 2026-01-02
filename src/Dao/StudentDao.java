package Dao;

import Dto.StudentDto;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDao {

    public static boolean addStudent(StudentDto dto) {
        String sql = "INSERT INTO student VALUES (?, ?, ?)";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, dto.getId());
            pst.setString(2, dto.getName());
            pst.setInt(3, dto.getGrade());
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Add student error: " + e.getMessage());
            return false;
        }
    }

     public static void viewAllStudents() {
        String sql = "SELECT * FROM student";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            System.out.println("ID | Name | Grade");
            System.out.println("------------------");

            boolean hasData = false;
            while (rs.next()) {
                System.out.println(
                        rs.getString(1) + " | " +
                                rs.getString(2) + " | " +
                                rs.getInt(3)
                );
                hasData = true;
            }

            if (!hasData) {
                System.out.println("No students found.");
            }

        } catch (Exception e) {
            System.out.println("View all students error: " + e.getMessage());
        }
    }

    public static void search(String id) {
        String sql = "SELECT * FROM student WHERE id=?";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println(
                        rs.getString(1) + " | " +
                                rs.getString(2) + " | " +
                                rs.getInt(3)
                );
            } else {
                System.out.println("Student not found!");
            }

        } catch (Exception e) {
            System.out.println("Search student error: " + e.getMessage());
        }
    }
}
