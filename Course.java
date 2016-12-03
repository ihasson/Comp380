/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg380;

import java.util.*;

/**
 * Provides a container for information on a course offered at CSUN.
 */
public class Course {

    String subject; //don't need
    String number; //don't need
    int courseID; 
    String courseName; //NEED 
    Boolean hasLab; //don't need
    int units; //need
    int difficulty; /* for the demo difficulty will just be an int */
    
    //need

    ArrayList<String> preRequisites; //Need

    Course() { //added by MM for inheritance

    }

    Course(String name, int unitAmount, int courseID) { //MM added 3rd arg
        this.courseName = name;
        this.units = unitAmount;
        this.courseID = courseID;
        preRequisites = new ArrayList<>(); //correction by MM for double declaration
    }

    public void addPreRequisite(String course) {
        preRequisites.add(course);
    }

    public Boolean preReqCheck(ArrayList<String> forgot) {
        return true;
    }

    public String getName() {
        return courseName;
    }

    //public ArrayList<String> givePreReqs(){

    public ArrayList<String> getPreRequisites() {
        return preRequisites;
    }

    public int getCourseID() { //MM
        return courseID;
    }
    
    public void setCourseID(int i){  //MM
        courseID = i;
    }
    
       public ArrayList<Section> getCourseSelections(ArrayList<Course> courses, ArrayList<Section> sections){
        ArrayList<Section> coursesections = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++){
            int temp = courses.get(i).getCourseID();
            for (int j = 0; j < sections.size(); j++){
                if (sections.get(j).getCourseID() == temp){
                    coursesections.add(sections.get(j));
                }
            }
        }
        return coursesections;
    } 
    
   
}
