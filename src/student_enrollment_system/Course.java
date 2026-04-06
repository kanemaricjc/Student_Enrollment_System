/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student_enrollment_system;

/**
 *
 * @author Kane
 */
public class Course {
    
    private int courseid;
    private String coursename;
    private String coursedes;
    private int credits;

    public Course(int courseid, String coursename, String coursedes, int credits) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.coursedes = coursedes;
        this.credits = credits;
    }

    public Course(String coursename, String coursedes, int credits) {
        this.coursename = coursename;
        this.coursedes = coursedes;
        this.credits = credits;
    }
    
    
    
    public Course() {
        
    }

    public int getCourseid() {
        return courseid;
    }
    
    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursedes() {
        return coursedes;
    }

    public void setCoursedes(String coursedes) {
        this.coursedes = coursedes;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

}
