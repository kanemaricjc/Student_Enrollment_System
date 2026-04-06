/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student_enrollment_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Kane
 */
public class EnrollmentDAO {
    
    public boolean addEnrollment(int studentId, int courseId) {
        // Updated column names to match hais.sql
        String sql = "INSERT INTO enrolled_subject (students_student_id, course_course_id, date) VALUES (?, ?, CURDATE())";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            int rowsAffected = stmt.executeUpdate();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ResultSet getAllEnrollments() {
        String sql = "SELECT e.enrollment_id, s.first_name, s.last_name, c.course_name, e.date as enrollment_date " +
                     "FROM enrolled_subject e " +
                     "JOIN students s ON e.students_student_id = s.student_id " +
                     "JOIN course c ON e.course_course_id = c.course_id";
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean deleteEnrollment(int enrollmentId) {
        String sql = "DELETE FROM enrolled_subject WHERE enrollment_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, enrollmentId);
            int rowsDeleted = stmt.executeUpdate();
            
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting enrollment: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
}
