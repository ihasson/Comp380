package team6;

/****************************************************************************************
Name of Module:SectionLinkedList.java
 
Purpose:The SectionLinkedList object is responsible for linking a list of sections and is used with SectionUnitTest.java to
confirm everything is working as expected.
Inputs:  Section Objects
Outputs: Prints Sections
Submodules: n/a
Author: Michael Harootoonyan
Date:   Nov 17, 2016

Reviewer:   Michael Harootoonyan
Date:       Nov 23, 2016


Revision History:
            Programmer: 	Michael Harootoonyan
            Date: 	Nov 23, 2016
            Description of Change: 	added integer seats_open to print
            Reviewer: 	Michael Harootoonyan
            Date of Review: 	Nov 23, 2016

****************************************************************************************/
import java.io.PrintWriter;

public class SectionLinkedList {

	private Section head;
	public int numberOfSections;
	
	SectionLinkedList()
	{
		head = null;
		numberOfSections = 0;
	}
	
	public Section fetchHead(){
		return head;
	}
	
	public void addSection(Section newSection){
		if(head != null)
		{
			newSection.setNext(head);
			head = newSection;
			
		} else
		{
			head = newSection;
		}
		
		numberOfSections++;
	}
	
	public void printSections()
	{
		Section temp = head;
		while(temp!=null)
		{
			System.out.println("Section ID:"+temp.getSectionID());
			System.out.println("Section Name:"+temp.getSectionName());
			System.out.println("Component:"+temp.getComponent());
			//System.out.println("Grading Option:"+temp.getGradingOption());
			//System.out.println("Start Date:"+temp.getStartDate());
			//System.out.println("End Date:"+temp.getEndDate());
			System.out.println("Days Of Week:"+temp.getDaysOfWeek());
			System.out.println("Start Time:"+temp.getStartTime());
			System.out.println("End Time:"+temp.getEndTime());
			System.out.println("Location:"+temp.getLocation());
			System.out.println("Instructor:"+temp.getInstructor());
			System.out.println("Open Seats:"+temp.getSeatsOpen());
			//System.out.print("Notes:");
			//for(int i = 0; i < temp.getNotes().get(0).length; i++)
				//System.out.println(temp.getNotes().get(0)[i]);
			
			temp = temp.getNext();
			System.out.println("\n");
			
		}
	}
	
	public void changeNumOfOpenSeats(int sectionId, int seatsOpen)
	{
		Section temp = head;
		while(temp!=null)
		{
			if(temp.getSectionID() == sectionId)
			{
				temp.setSeatsOpen(seatsOpen);

			}
			temp = temp.getNext();
			
		}
	}
	
	public void writeSectionsToTxt(String filename)
	{
		//Creating a text file (note that this will overwrite the file if it already exists):
			try{
			    PrintWriter writer = new PrintWriter(filename+".txt", "UTF-8");
			    Section temp = head;
			    while(temp!=null)
			    {
			    	writer.println("");
			    }
			    
			    writer.println("The first line");
			    
			    writer.close();
			} catch (Exception e) {
			   // do something
			}
	}
	
	
}
