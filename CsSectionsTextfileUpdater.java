/****************************************************************************************
Name of Module:	CsSectionsTextFileUpdater.java
 
Purpose: To update the number of open seats inside an old text file that has been organized.
		 A new text file manually created using jQuery to scrape the following information
		 contains the updated open seats numbers has no organization. Line by line both 
		 files are scanned and matches made get written to a newly updated 
		 and organized text file.

		*Special Note: this file needed to be hand made from complications I encountered
		when I had attempted to do this purely using jQuery in order to save time and
		is used as a template.
		

Inputs:  1. Old text file of an older list of courses available for computer science classes for the spring 2017 
		 that has been structured to label the course names.	
		
		The old text file is organized.
		------------------------------------------------------
		
		COMP 105BAS - COMP PROGRM/BASIC ( LAB  1 Unit )
		15631 LAB JD1600A Fr 11:00am-01:45pm Staff 13
		
		COMP 108 - COMP SCI ORIENTATION ( LEC  3 Units )
		15532 LEC JD1600 TuTh 09:30am-10:45am Hsu,Wen Chin 22
		16116 LEC JD1107 TuTh 03:30pm-04:45pm Hsu,Wen Chin 21
		------------------------------------------------------
		 
		 2. Update text file of an newer list of courses with the updated open seats numbers w/o 
		 being organized by course names.
		 
		-------------------------------------------------------
		15631 LAB JD1600A Fr 11:00am-01:45pm Staff 3
		15532 LEC JD1600 TuTh 09:30am-10:45am Hsu,Wen Chin 2
		16116 LEC JD1107 TuTh 03:30pm-04:45pm Hsu,Wen Chin 7
		------------------------------------------------------
		 
		 
		 

Outputs: 1. A list exactly like the Old text file with the open seats numbers updated.

Submodules: n/a

Author: Michael Harootoonyan

Date:   Nov 23, 2016

Reviewer:   
Date:       


Revision History:
            Programmer:
            Date:
            Description of Change:
            Reviewer:
            Date of Review:

****************************************************************************************/
package research;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CsSectionsTextfileUpdater {
	

	/**
	 * 
	 * @param oldFileName
	 * @param updateFileName can not be oldFileName
	 * @param newFileName can be oldFileName because it gets overwritten, can not be updateFileName.
	 */
	public CsSectionsTextfileUpdater(String oldFileName, String updateFileName, String newFileName){
        /* This will reference one section_line at a time */
        String section_line    = null;
        String seats_open_line = null;
        
        try 
        {
        	/*	PrintWriter write to text files in UTF-8 encoding. 	*/
        	PrintWriter writer = new PrintWriter(newFileName, "UTF-8");
        	
        	
        	
	        /* 	FileReader reads text files in the default encoding.	*/
	        FileReader sectionFileReader = new FileReader(oldFileName);
	        FileReader seatsOpenReader= new FileReader(updateFileName);
	
	        /*	 Always wrap FileReader in BufferedReader.				*/
	        BufferedReader sectionsBufferedReader = new BufferedReader(sectionFileReader);
	        BufferedReader seatsOpenBufferedReader = new BufferedReader(seatsOpenReader);
	        
	       
	        
	        /*	 While reading the lines of the open seats text file    */
	        while((section_line = sectionsBufferedReader.readLine()) != null) {
	        	
	        	if(section_line.contains("COMP"))
	        	{
	        		//System.out.println(section_line);
	        		writer.println(section_line);
	        	}
	        	else if (!section_line.isEmpty()){
	        		
	        		while((seats_open_line = seatsOpenBufferedReader.readLine()) !=null)
	        		{
	        			if(seats_open_line.contains(section_line))
	        			{
	        				//System.out.println(seats_open_line+"\n"+section_line);
	        				writer.println(seats_open_line);
	        				
	        				break;
	        			}
	        		}
	        	}
	        	else
	        		writer.println();//System.out.println();

			    
        	}
	        
	        
	        /*	Always close files.										*/
	        sectionsBufferedReader.close();
	        seatsOpenBufferedReader.close();
	        writer.close();
    	}
        catch(FileNotFoundException ex) {ex.printStackTrace();}
        catch(IOException ex) {ex.printStackTrace();}


	}





}

