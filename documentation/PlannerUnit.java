/*******************************************************************************

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

*******************************************************************************/




public class PlannerUnit {
    // attributes stored in the class
    private String semester;
    private int year;
    private int maxUnits;
    private int difficultyRating;
    //private LinkedList<Course> allCourses;
    
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
    
    public int getDifficultyRating() {
        return difficultyRating;
    }
    
    /*
    public LinkedList getAllCourses() {
        return allCourses;
    }
    */
    
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
    
    public void setDifficultyRating(int n) {
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
    public void addCourse(int courseID) {
        allCourses.addLast(courseID);
    }
    
    public void removeCourse (int courseID) {
        allCourses.remove(allCourses.find(courseID));
    }
    
    public void swapCourses (int addCourseID, int deleteCourseID) {
        allCourses.remove(allCourses.find(deleteCourseID));
        allCourses.addLast(addCourseID);
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
