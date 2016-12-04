/**
 * Author: Izzy Hasson
 */
import java.util.*;
/**
 * Provides a container for information on a course offered at CSUN.
 * <p>
 * <img src="doc-files/Course-1.png" alt="Class diagram">
 */
public class Course {
    private String subject; //don't need
    private String number; //don't need
    private Integer courseID; //don't need
    private String courseName; //NEED 
    private Boolean hasLab; //don't need
    private int units; //need
    private int difficulty; /* for the demo difficulty will just be an int */ 
    //need
    private ArrayList<String> preRequisites; //Need

    Course(String name, int unitAmount, int dif){
        difficulty = dif;
        courseName = name;
        units = unitAmount;
        preRequisites = new ArrayList<>();
    }
    
//    Course(String name, int unitAmount, int courseID) { //MM added 3rd arg
//        this.courseName = name;
//        this.units = unitAmount;
//        this.courseID = courseID;
//        preRequisites = new ArrayList<>(); //correction by MM for double declaration
//
    public void addPreRequisite(String course){
        preRequisites.add(course);
    }

    public Boolean preReqCheck(ArrayList<String> forgot){
        return true;
    }
    public int getDifficulty(){
        return difficulty;
    }
    public String getName(){
        return courseName;
    }
    //public ArrayList<String> givePreReqs(){
    public ArrayList<String> getPreRequisites(){
        return preRequisites;
    }
    public int getCourseID() { //MM
        return courseID;
    }
    
    public void setCourseID(int i){  //MM
        courseID = i;
    }

//    public ArrayList<Section> getCourseSelections(ArrayList<Course> courses, ArrayList<Section> sections){
//        ArrayList<Section> coursesections = new ArrayList<>();
//        for (int i = 0; i < courses.size(); i++){
//            int temp = courses.get(i).getCourseID();
//            for (int j = 0; j < sections.size(); j++){
//                if (sections.get(j).getCourseID() == temp){
//                    coursesections.add(sections.get(j));
//                }
//            }
//        }
//        return coursesections;
//    } 
//    
   
}
