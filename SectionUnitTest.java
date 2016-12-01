package Team6;
/****************************************************************************************
Name of Module:SectionUnitTest.java
 
Purpose:The SectionUnitTest object is used as a unit test to
Inputs:  n/a
Outputs: n/a
Submodules: SectionLinkedList.java, Section.java
Author: Michael Harootoonyan
Date:   Nov 23, 2016
****************************************************************************************/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SectionUnitTest {
	static String sectionName;
	static SectionLinkedList list;
	
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
		String  open_seats="";
		
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
						while( i < str.length() && !Character.isDigit(str.charAt(i)) ) 
						{
							instructor+= str.charAt(i);
							i++;
						}
						break;
				}
				
			} else
				permits--;
		}
		
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
		
		int strlength = str.length();
		
		
		if ( str.charAt(strlength-2) != ' ')
		{
			open_seats += str.charAt(strlength-2);
		}
		if ( str.charAt(strlength-1) != ' ')
		open_seats += str.charAt(strlength-1);

		
		section.setSectionID(Integer.parseInt(sectionID));			
		section.setComponent(component);
		section.setInstructor(instructor);
		section.setSeatsOpen(Integer.parseInt(open_seats));
		section.setStartTime(startTime);
		section.setEndTime(endTime);
		section.setLocation(location);
		section.setDaysOfWeek(daysOfWk);
		section.setSectionName(sectionName);
		
		
		
		
		list.addSection(section);
    	}
	}

	public static void main(String[] args) {
		
		String[] notess = {"Wait list is not available for this corequisite course"};
		ArrayList<String[]> notes = new ArrayList<String[]>();
		notes.add(notess);
		
		
		 list = new SectionLinkedList();
		
	// The name of the file to open.
        String fileName = "spring_2017_cs_sections.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null) {
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
		
        
        list.printSections();
		
		
		

		

	}

}
