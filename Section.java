/****************************************************************************************
Name of Module:Section.java
 
Purpose:This Section object is responsible for holding section information. It is a pure storage object that inherits from the Course object, and is utilized for display purposes.
The section object stores all necessary information about a class a student can take at CSUN.

Inputs:  section ID, section name, component, grading option, start date, end date, days of week, start time, end time, location, notes, seats open, and instructor.

Outputs: section ID, section name, component, grading option, start date ,end date, days of week, start time, end time, location, notes, seats open, and instructor.

Submodules: n/a

Author: Michael Harootoonyan
        Megan Meyers
Date:   Nov 11, 2016

Reviewer:   Michael Harootoonyan
Date:       Nov 23, 2016


Revision History:
            Programmer: 	Michael Harootoonyan
            Date: 	Nov 23, 2016
            Description of Change: 	added integer seats_open
            Reviewer: 	Michael Harootoonyan
            Date of Review: 	Nov 23, 2016

****************************************************************************************/
import java.util.*;
import java.time.*;

public class Section{ //extends added by MM

	private int sectionID;
	private String sectionName;
	private String component;
	private String gradingOption;
	private String startDate;
	private String endDate;
	private String daysOfWeek;
	private String startTime;
	private String endTime;
	private String location;
	private ArrayList<String[]> notes;
	private String instructor;
	private int seatsOpen;
	private Section next;

    int overlaps, day;
    LocalTime eTime;
    LocalTime sTime;
    boolean collides;
	
	public Section()
	{
		this.sectionID     = 0;
		this.sectionName   = "";
		this.component	   = "";
		this.gradingOption = "";
		this.startDate	   = "";
		this.endDate	   = "";
		this.daysOfWeek	   = "";
		this.startTime	   = "";
		this.endTime	   = "";
		this.location	   = "";
		this.notes	       = null;
		this.instructor	   = "";
		this.seatsOpen     = 0;
		this.next	   = null;
	}
	
	public Section (int sectionID, 
            String sectionName, 
            String component, String gradingOption, String startDate,
			String endDate, String daysOfWeek, 
            String startTime, String endTime, 
            String location, 
			ArrayList<String[]> notes, 
            String instructor, int seatsOpen, 
            Section next)
	{
		this.sectionID     = sectionID;
		this.sectionName   = sectionName;
		this.component	   = component;
		this.gradingOption = gradingOption;
		this.startDate	   = startDate;
		this.endDate	   = endDate;
		this.daysOfWeek	   = daysOfWeek;
		this.startTime	   = startTime;
		this.endTime	   = endTime;
		this.location	   = location;
		this.notes	   	   = notes;
		this.instructor	   = instructor;
		this.seatsOpen     = seatsOpen;
		this.next	   	   = next;
	}
	
	public void setSectionID(int sectionID){
		this.sectionID     = sectionID;
	}
	
	public void setSectionName(String sectionName){
		this.sectionName   = sectionName;
	}
	
	public void setComponent(String component){
		this.component     = component;
	}
	
	public void setGradingOption(String gradingOption){
		this.gradingOption = gradingOption;
	}

	public void setStartDate(String startDate){
		this.startDate    = startDate;
	}
	
	public void setEndDate(String endDate){
		this.endDate      = endDate;
	} 
	
	public void setDaysOfWeek(String daysOfWeek){
		this.daysOfWeek   = daysOfWeek;
	}
	
	public void setStartTime(String startTime){
		this.startTime    = startTime;
	}
	
	public void setEndTime(String endTime){
		this.endTime      = endTime;
	}
	
	public void setLocation(String location){
		this.location     = location;
	}
	
	public void setNotes(ArrayList<String[]> notes){
		this.notes        = notes;
	}
	
	public void setInstructor(String instructor){
		this.instructor   = instructor;
	}
	
	public void setSeatsOpen(int seatsOpen){
		this.seatsOpen = seatsOpen;
	}
	
	public void setNext(Section next){
		this.next         = next;
	}
	
	public int getSectionID(){
		return this.sectionID;
	}
	
	public String getSectionName(){
		return this.sectionName;
	}
	
	public String getComponent(){
		return this.component;
	}
	
	public String getGradingOption(){
		return this.gradingOption;
	}

	public String getStartDate(){
		return this.startDate;
	}
	
	public String getEndDate(){
		return this.endDate;
	}
	
	public String getDaysOfWeek(){
		return this.daysOfWeek;
	}
	
	public String getStartTime(){
		return this.startTime;
	}
	
	public String getEndTime(){
		return this.endTime;
	}
	
	public String getLocation(){
		return this.location;
	}
	
	public ArrayList<String[]> getNotes(){
		return this.notes;
	}
	
	public String getInstructor(){
		return this.instructor;
	}
	
	public int getSeatsOpen(){
		return this.seatsOpen;
	}
	
	public Section getNext()
	{
		return this.next;
	}
    public int getDay() {
        return day;
    }
    public boolean collides(Section e) {
        return (getDay() == e.getDay() && (getStartTime().compareTo(e.getEndTime()) < 0) && (e.getStartTime().compareTo(getEndTime()) < 0));
    }
	
}
