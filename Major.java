package Builder;

/*
 * Jonathan Carrasco
 * COMP 380 - Software Engineering
 * MW: 2pm-4:15pm
 * Group 6
*/

/*
 * Resizable-array implementation of the List interface.
 */
import java.util.ArrayList;
//import Builder.Course;

/*
 * This class holds all the courses associated with a given major.
 * When the Major class is instantiated, it will contiain an ArrayList
 * of Courses (for this - using the Sections objects).
 * <p>
 * The methods for the Major class are:
 * addMajorReq
 * displayMajorReqs
 * 
 */
public class Major {

	private int majorID;//holds the id for a Major
	private String majorName;//holds the name of Major
	
	ArrayList <Course> majorReqs = //holds the required Courses
			new ArrayList <Course>();//for a Major
	
	/* 
	 * Major constructor
	 * 
	 * @param id MajorID
	 * @param major Major name
	 * @param courses ArrayList of the major requirement courses
	 * 
	 */
	Major(int id, String major, ArrayList<Course> courses){
		
		majorID = id;
		majorName = major;
		majorReqs = courses;
	}
	
	/*
	 * Adds a Course object to the requirements list of courses for a Major
	 * 
	 * @param course the Course object
	 * @return void
	 */
	private void addMajorReq(Course course){
		
		majorReqs.add(course);
		
	}
	
	/*
	 * Displays the ArrayList of Major required courses.
	 * 
	 * @param none
	 * @return void
	 */
	public void displayMajorReqs(){
		
		for(int index = 0; index < majorReqs.size(); index++){
			
			if(!majorReqs.isEmpty()){
				System.out.println(majorReqs.get(index));
			}
			else{
				System.out.println("There are no Courses for this Major");
			}
			
		}
	}
	
	public String getName(){
		return majorName;
	}
	
	public ArrayList<Course> getMajorReqs(){
		return majorReqs;
	}
}
