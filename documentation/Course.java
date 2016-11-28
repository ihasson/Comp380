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

    public void addPreRequisite(String course){
        preRequisites.add(course);
    }

    public Boolean preReqCheck(ArrayList<String> forgot){
        return true;
    }

    public String getName(){
        return courseName;
    }
    //public ArrayList<String> givePreReqs(){
    public ArrayList<String> getPreRequisites(){
        return preRequisites;
    }
}
