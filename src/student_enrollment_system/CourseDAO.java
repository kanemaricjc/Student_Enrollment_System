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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kane
 */
public class CourseDAO {
    
    public boolean addCourse(Course course) {
    String sql = "INSERT INTO course (course_name, course_description, credits) VALUES (?, ?, ?)";
    try (Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, course.getCoursename());
        stmt.setString(2, course.getCoursedes());
        stmt.setInt(3, course.getCredits());
        
        int rowsAffected = stmt.executeUpdate();
        
        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    
    public List<Course> getAllCourses() {
    List<Course> courses = new ArrayList<>();
    String sql = "SELECT * FROM course";
    try (Connection conn = DBConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Course course = new Course();
            course.setCourseid(rs.getInt("course_id"));
            course.setCoursename(rs.getString("course_name"));
            course.setCoursedes(rs.getString("course_description"));
            course.setCredits(rs.getInt("credits"));
            courses.add(course);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return courses;
}
    
    public boolean updateCourse(Course course) {
        String sql = "UPDATE course SET course_name=?, course_description=?, credits=? WHERE course_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, course.getCoursename());
            stmt.setString(2, course.getCoursedes());
            stmt.setInt(3, course.getCredits());
            stmt.setInt(4, course.getCourseid());
            
            int rowsAffected = stmt.executeUpdate();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCourse(int courseid) {
        String sql = "DELETE FROM course WHERE course_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, courseid);
            int rowsAffected = stmt.executeUpdate();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }      
    
    
    
}
