/*

Name of Module: PlannerUnit

Purpose:    Creates the data structure to hold planner information for a
            specific semester + year combination (e.g. Fall 2017)

Inputs:     String Semester, Int Year
            Used to ensure courses are stored in the proper unit; if no
            unit exists, a new one is created

Outputs:    PlannerUnit plannerUnit
            a planner unit for a LinkedUnit which is, in turn, for a Planner

Submodules: None


Author:     Andrea Lee
Date:       11/13/16

Reviewer:   ???
Date:       ???


Revision History:
            Programmer:
            Date:
            Description of Change:
            Reviewer:
            Date of Review:

*/


//package planner;
import java.util.*;

public class PlannerUnit {
    // attributes stored in the class
    private String semester;
    private int year;
    private int maxUnits;
    private double difficultyRating;
    private LinkedList<Course> allCourses;
    // For the purposes of the demo, all references to the Course class
    // will be commented out.
    
    private PlannerUnit prev;
    private PlannerUnit next;
    
    // constructor
    public PlannerUnit(String s, int n) {
        semester = s;
        year = n;
        maxUnits = 13;
        difficultyRating = 0;
        //allCourses = new LinkedList();
    }
    
    // getters and setters
    public String getSemester() {
        return semester;
    }
    
    public int getYear() {
        return year;
    }
    
    public int getMaxUnits() {
        return maxUnits;
    }
    
    public double getDifficultyRating() {
        return difficultyRating;
    }
    
    
    public LinkedList getAllCourses() {
        return allCourses;
    }
    
    
    public PlannerUnit getPrev() {
        return prev;
    }
    
    public PlannerUnit getNext() {
        return next;
    }
    
    public void setSemester(String n) {
        semester = n;
    }
    
    public void setYear(int n) {
        year = n;
    }
    
    public void setMaxUnits(int n) {
        maxUnits = n;
    }
    
    public void setDifficultyRating(double n) {
        difficultyRating = n;
    }
    
    /*
    public void setAllCourses(LinkedList n) {
        allCourses = n;
    }
    */

    public void setPrev(PlannerUnit n) {
        prev = n;
    }
    
    public void setNext(PlannerUnit n) {
        next = n;
    }
    
    // functions
    // adds, removes, or swaps a course within the unit
    /*
    public void addCourse(Course n) {
        allCourses.addLast(n);
        difficultyRating += n.calculateDifficultyRating(n.getName());
    }
    
    public void removeCourse (Course n) {
        allCourses.remove(allCourses.indexOf(n));
        difficultyRating -= n.calculateDifficultyRating(n.getName());
    }
    
    public void swapCourses (Course add, Course delete) {
        allCourses.remove(allCourses.indexOf(delete));
        allCourses.addLast(add);
        difficultyRating += add.calculateDifficultyRating(add.getName());
        difficultyRating -=
                delete.calculateDifficultyRating(delete.getName());
    }
    */
    
    // provides a sorting value, with a smaller number indicating an
    // earlier sort
    public int sortValue() {
        int value;
        value = year*4;
        
        if(semester.equals("SPRING"))
            value = value+0;
        else if (semester.equals("SUMMER"))
            value = value+1;
        else if (semester.equals("FALL"))
            value = value+2;
        else
            value = value+3;
        
        return value;
    }
    
}
