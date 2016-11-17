/****************************************************************************************
Name of Module:SectionLinkedList.java
 
Purpose:The SectionLinkedList object is responsible for linking a list of sections and is used with SectionUnitTest.java to
confirm everything is working as expected.
Inputs:  Section Objects
Outputs: Prints Sections
Submodules: n/a
Author: Michael Harootoonyan
Date:   Nov 17, 2016
****************************************************************************************/
public class SectionLinkedList {

	private Section head;
	private int numberOfSections;
	
	SectionLinkedList()
	{
		head = null;
		numberOfSections = 0;
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
			//System.out.print("Notes:");
			//for(int i = 0; i < temp.getNotes().get(0).length; i++)
				//System.out.println(temp.getNotes().get(0)[i]);
			
			temp = temp.getNext();
			System.out.println("\n");
			
		}
	}
	
	
	
	
}

