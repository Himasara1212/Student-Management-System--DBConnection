package Dao;

import Dto.TeacherDto;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TeacherDao {

    public static boolean addTeacher(TeacherDto teacher) {
        String sql = "INSERT INTO teacher(id, name, subject) VALUES(?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, teacher.getId());
            pst.setString(2, teacher.getName());
            pst.setString(3, teacher.getSubject());
            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error adding teacher: " + e.getMessage());
            return false;
        }
    }

    public static void viewAllTeachers() {
        String sql = "SELECT * FROM teacher";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            System.out.println("\nID | Name | Subject");
            System.out.println("-------------------");
            while (rs.next()) {
                System.out.println(rs.getString("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("subject"));
            }

        } catch (Exception e) {
            System.out.println("Error viewing teachers: " + e.getMessage());
        }
    }
}
