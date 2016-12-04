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
import java.util.LinkedList;

public class Student {
	
//variables:
	private String studentId;
	private String firstName;
	private String lastName;
	private String studentMonthOfAdmit;
	private Major studentMajor;
	private Schedule currentSchedule;
	private Planner studentPlaner;
	private LinkedList<Course> studentTranscript;
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
		this.studentTranscript = new LinkedList<Course>();
	}//end
	
	public Student(String sId, String sFirstName, String sLastName, char sInit){
		this.studentId = sId;
		this.firstName = sFirstName;
		this.lastName = sLastName;
		this.middleInitial = sInit;
		this.studentTranscript = new LinkedList<Course>();
		this.studentMonthOfAdmit = "not set";
		this.studentYearOfAdmit = 0;
	}//end
	
//public Methods:
	
	/**
	 * adds a course to the list of 
	 * student transcript.
	 * @param Course
	 * @return void
	 */
	public void updatTranscript(Course input){
		this.studentTranscript.add(input);
	}//end 
	
	/**
	 * returns a course from the list at
	 * the given index i.
	 * @param Integer
	 * @return Course at index i
	 */
	public Course getCoursefromTranscript(int i){
		return this.studentTranscript.get(i);
	}//end
	
	/**
	 * Finds and returns the course from
	 * the student transcripts
	 * @param Course
	 * @return Course
	 */
	public Course getCorsefromTranscript(Course i){
		return this.studentTranscript.get(this.studentTranscript.indexOf((Course)i));
	}//end
	
	/**
	 * returns a boolean if the given course 
	 * has been taken.
	 * @param Course
	 * @return boolean
	 */
	public boolean coursesTaken(Course input){
		if(this.studentTranscript.contains(input)){
			return true;
		}//end if
		return false;
	}//end 
	
	/**
	 * returns true if the student has taken
	 * and passed a course.
	 * @param Course
	 * @return boolean
	 */
	public boolean coursesPassed(Course input){
		if(this.coursesTaken(input)){
			if(this.getCorsefromTranscript(input).coursePassed()){
				return true;
			}//end pass check
		}//end if
		return false;
	}//end
	
	/**
	 * returns the list as an array of courses.
	 * @param void
	 * @return Course[]
	 * 
	 */
	public Course[] courseLodeout(){
		return (Course[]) this.studentTranscript.toArray();
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
