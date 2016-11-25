/**
 * Name of Module: Student
 * 
 * Purpose: creates an object that holds all the relevant data of the student,
 * 			including the students schedule and planer.
 * 
 *  Inputs: ?
 *  
 *  Output: ?
 *  
 *  submodule: none;
 *  
 *  Author: Sina Eradat
 *  Date:	11/22/16
 *  
 *  Revision History:
            Programmer:
            Date:
            Description of Change:
            Reviewer:
            Date of Review:
 */
import java.util.ArrayList;

public class Student {
	
//variables:
	private String studentId;
	private String firstName;
	private String lastName;
	private String studentMonthOfAdmit;
	private Major studentMajor;
	private Schedule currentSchedule;
	private Planner studentPlaner;
	private ArrayList<Course> studentTransscript;
	private char middleInitial;
	private int studentYearOfAdmit;
	
//Constructors:
	
	public Student(){
		this.studentId = "";
		this.firstName = "";
		this.lastName = "";
		this.middleInitial = ' ';
		this.studentMonthOfAdmit = "";
		this.studentYearOfAdmit = 0;
		this.studentTransscript = new ArrayList<Course>();
	}//end
	
	public Student(String sId, String sFirstName, String sLastName, char sInit){
		this.studentId = sId;
		this.firstName = sFirstName;
		this.lastName = sLastName;
		this.middleInitial = sInit;
		this.studentTransscript = new ArrayList<Course>();
		this.studentMonthOfAdmit = "not set";
		this.studentYearOfAdmit = 0;
	}//end
	
//public Methods:
	
	/*
	 * adds a course to the list.
	 */
	public void updatTransscript(Course input){
		this.studentTransscript.add(input);
	}//end 
	
	/*
	 * returns a course from the list at
	 * the given index i.
	 */
	public Course getCorsefromTransscript(int i){
		return this.studentTransscript.get(i);
	}//end
	
	/*
	 * returns a boolean if the given course 
	 * has been taken.
	 */
	public boolean courseTaken(Course input){
		if(this.studentTransscript.contains(input)){
			return true;
		}//end if
		return false;
	}//end 
	
	/*
	 * returns the list as an array of courses
	 */
	public Course[] courseLodeout(){
		return (Course[]) this.studentTransscript.toArray();
	}//end
	
//Get and Set methods:

	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStudentMonthOfAdmit() {
		return studentMonthOfAdmit;
	}
	public void setStudentMonthOfAdmit(String studentMonthOfAdmit) {
		this.studentMonthOfAdmit = studentMonthOfAdmit;
	}
	public Major getStudentMajor() {
		return studentMajor;
	}
	public void setStudentMajor(Major studentMajor) {
		this.studentMajor = studentMajor;
	}
	public Schedule getCurrentSchedule() {
		return currentSchedule;
	}
	public void setCurrentSchedule(Schedule currentSchedule) {
		this.currentSchedule = currentSchedule;
	}
	public Planner getStudentPlaner() {
		return studentPlaner;
	}
	public void setStudentPlaner(Planner studentPlaner) {
		this.studentPlaner = studentPlaner;
	}
	public char getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(char middleInitial) {
		this.middleInitial = middleInitial;
	}
	public int getStudentYearOfAdmit() {
		return studentYearOfAdmit;
	}
	public void setStudentYearOfAdmit(int studentYearOfAdmit) {
		this.studentYearOfAdmit = studentYearOfAdmit;
	}
	
//Override Methods: 

	public String toString(){
		return "Student: " + this.studentId + " " + this.firstName + " " + this.lastName + " " + this.middleInitial;
	}//end
}//end Student class
