/****************************************************************************************
Name of Module:Section.java
 
Purpose:	Collects on the computer science classes offered at CSUN from a text file.

Inputs:  section ID, section name, component, grading option, start date, end date, 
		 days of week, start time, end time, location, notes, and instructor.

Outputs: section ID, section name, component, grading option, start date ,end date, 
		 days of week, start time, end time, location, notes, and instructor.

Submodules: n/a

Author: Michael Harootoonyan

Date:   Nov 17, 2016

Reviewer:   ???
Date:       ???


Revision History:
            Programmer:
            Date:
            Description of Change:
            Reviewer:
            Date of Review:

****************************************************************************************/
import java.io.*;

public class ScrapingFromText {
	static String sectionName;
	public static void getCSCourses(String str) {
		
    	if(str.contains("COMP"))
    	{
    		int index = 0;
            //System.out.println(str);
    		sectionName = "";
            while(str.charAt(index)!= '-')
            {
            	sectionName += str.charAt(index);
            	index++;
            }
            return;
    	} else if(str.contains("1")) {
		Section section   = new Section();
		String  sectionID ="";
		String  component ="";
		String  location  ="";
		String  daysOfWk  ="";
		String  time      ="";
		String  instructor="";
		
		int 	permits   = 5;
		
		for(int i = 0; i < str.length(); i++)
		{
			if( str.charAt(i) != ' ' )
			{
				switch(permits)
				{
					case 5: 
						sectionID += str.charAt(i);
						break;
					case 4:
						component += str.charAt(i);
						break;
					case 3:
						location  += str.charAt(i);
						break;
					case 2:
						daysOfWk  += str.charAt(i);
						break;
					case 1:
						time += str.charAt(i);
						break;
					case 0:
						instructor+= str.charAt(i);
						break;
				}
				
			} else
				permits--;
		}
		
		section.setSectionID(Integer.parseInt(sectionID));			
		section.setComponent(component);
		section.setInstructor(instructor);
		
		
		String startTime ="";
		String endTime   ="";
	
		int i = 0;
		while(time.charAt(i) != '-' )
		{
			startTime += time.charAt(i);
			i++;
		}
		i++;
		while(i < time.length() )
		{
			endTime += time.charAt(i);
			i++;
		}
		
			
		section.setStartTime(startTime);
		section.setEndTime(endTime);
		
		
		
		section.setLocation(location);
		section.setDaysOfWeek(daysOfWk);
		
		section.setSectionName(sectionName);
		
		
		
		
		SectionLinkedList list = new SectionLinkedList();
		list.addSection(section);
		
		list.printSections();
    	}
	}

	public static void main(String[] args) {
		
			//String  str       = "15522 LEC JD1105 TuTh 09:30am-10:45am Parker,Lucy";
			//getCSCourses(str);
			
			
		// The name of the file to open.
	        String fileName = "sections.txt";

	        // This will reference one line at a time
	        String line = null;

	        try {
	            // FileReader reads text files in the default encoding.
	            FileReader fileReader = 
	                new FileReader(fileName);

	            // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader = 
	                new BufferedReader(fileReader);

	            while((line = bufferedReader.readLine()) != null) {
//	            	if(line.contains("COMP"))
//	            	{
//		                System.out.println(line);
//
//	            	}
	            	//else if(line.contains("1"))
	        			getCSCourses(line);
	                
	            }   

	            // Always close files.
	            bufferedReader.close();         
	        }
	        catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" + 
	                fileName + "'");                
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + fileName + "'");                  
	            // Or we could just do this: 
	            // ex.printStackTrace();
	        }
	        
	    }
}
