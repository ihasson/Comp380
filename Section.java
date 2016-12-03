/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg380;

import java.util.*;
import java.time.*;

public class Section extends Course { //extends added by MM

    int sectionID;
    String sectionName;
    String component;
    String gradingOption;
    String startDate;
    String endDate;
    String daysOfWeek;
    String startTime;
    String endTime;
    String location;
    ArrayList<String[]> notes;
    String instructor;
    Section next;

    int overlaps, day;
    LocalTime eTime;
    LocalTime sTime;
    boolean collides;

    public Section() {

    }

    /*   public Section() {

     this.sectionID = 0;
     this.sectionName = "";
     this.component = "";
     this.gradingOption = "";
     this.startDate = "";
     this.endDate = "";
     this.daysOfWeek = "";
     this.startTime = "";
     this.endTime = "";
     this.location = "";
     this.notes = null;
     this.instructor = "";
     this.next = null;
     }*/
    public Section(int sectionID, String daysOfWeek, LocalTime startTime, LocalTime endTime, String sectionName, int units, int courseID, int day) {

        this.sectionID = sectionID;
        this.courseName = sectionName;
        this.daysOfWeek = daysOfWeek;
        this.sTime = startTime;
        this.eTime = endTime;
        this.units = units;
        this.courseID = courseID;
        this.day = day;

    }

    /*   public Section(int sectionID, String sectionName, String component, String gradingOption, String startDate,
     String endDate, String daysOfWeek, String startTime, String endTime, String location,
     ArrayList<String[]> notes, String instructor, Section next) {

     this.sectionID = sectionID;
     this.sectionName = sectionName;
     this.component = component;
     this.gradingOption = gradingOption;
     this.startDate = startDate;
     this.endDate = endDate;
     this.daysOfWeek = daysOfWeek;
     this.startTime = startTime;
     this.endTime = endTime;
     this.location = location;
     this.notes = notes;
     this.instructor = instructor;
     this.next = next;
     }*/
    public void setSectionID(int sectionID) {
        this.sectionID = sectionID;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public void setGradingOption(String gradingOption) {
        this.gradingOption = gradingOption;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setDaysOfWeek(String daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setNotes(ArrayList<String[]> notes) {
        this.notes = notes;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setNext(Section next) {
        this.next = next;
    }

    public int getSectionID() {
        return this.sectionID;
    }

    public String getSectionName() {
        return this.sectionName;
    }

    public String getComponent() {
        return this.component;
    }

    public String getGradingOption() {
        return this.gradingOption;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public String getDaysOfWeek() {
        return this.daysOfWeek;
    }

    public LocalTime getStartTime() {
        return this.sTime;
    }

    public LocalTime getEndTime() {
        return this.eTime;
    }

    public String getLocation() {
        return this.location;
    }

    public ArrayList<String[]> getNotes() {
        return this.notes;
    }

    public String getInstructor() {
        return this.instructor;
    }

    public Section getNext() {
        return this.next;
    }

    public int getDay() {
        return day;
    }
    public Section getSection(Section s, int cid){
        if (s.getCourseID() == cid){
            return s;
        }
        else{
            return null;
        }
    }

    public boolean collides(Section e) {
        return (getDay() == e.getDay() && (getStartTime().compareTo(e.getEndTime()) < 0) && (e.getStartTime().compareTo(getEndTime()) < 0));
    }

}
