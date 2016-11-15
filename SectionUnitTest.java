/****************************************************************************************
Name of Module:SectionLinkedList.java
 
Purpose:The SectionUnitTest object is used as a unit test to
Inputs:  n/a
Outputs: n/a
Submodules: SectionLinkedList.java, Section.java
Author: Michael Harootoonyan
Date:   Nov 11, 2016
****************************************************************************************/
import java.util.ArrayList;

public class SectionUnitTest {
	
	

	public static void main(String[] args) {
		
		String[] notess = {"Wait list is not available for this corequisite course"};
		ArrayList<String[]> notes = new ArrayList();
		notes.add(notess);
		
		
		
		
		/*  TESTING OF THE CONSTRUCTOR*/
		Section firstClass = new Section(19378,"COMP 256","LEC","GRD","startdate","enddate","TR","2:00pm","3:15pm",
				"JD3520",notes,"Lorentz Richard J.",null);
		
		
		
		Section secondClass = new Section();
		
		/*	TESTING OF THE SETTER METHODS*/
		secondClass.setSectionID(19379);
		secondClass.setSectionName("COMP 256");
		secondClass.setComponent("LAB");
		secondClass.setGradingOption("GRD");
		secondClass.setStartDate("startdate");
		secondClass.setEndDate("enddate");
		secondClass.setDaysOfWeek("TR");
		secondClass.setStartTime("3:30");
		secondClass.setEndTime("4:45");
		secondClass.setLocation("JD3520");
		secondClass.setNotes(notes);
		secondClass.setInstructor("Lorentz Richard J.");
		
		
		
		SectionLinkedList mikes_class_schedule = new SectionLinkedList();
		
		mikes_class_schedule.addSection(firstClass);
		mikes_class_schedule.addSection(secondClass);
		
		
		mikes_class_schedule.printSections();

		

	}

}
