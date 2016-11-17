import java.util.ArrayList;

/**
 * Gives Prerequsites To A Class
 */
public class Course {
    
    public String[][] givePreReqs(String sectionName){
    	
    	/*	HARD CODED FROM MAJOR DIAGRAM DO NOT MODIFY*/

		String [] coursesAvailable = {"Comp 108", "Comp 110","Comp 122", "Comp 182", "Comp 282", "Comp 380"};
		
				
		String [][] comp108 = new String[3][1];
		comp108[0][0] = "";			// NO G.E.s required.
		comp108[1][0] = "";			// NO Math Classes required.
		comp108[2][0] = "";			// NO Comp Classes required.
	
		String [][] comp110 = new String[3][1];
		comp110[0][0] = "";			// NO G.E.s required.
		comp110[1][0] = "Math 102";	//Math Classes required.
		comp110[2][0] = "Comp108";  // Comp Classes required.	
		
		/*		COMP 122 and 182 have the same prereqs		*/
		String [][] comp122 = new String[3][2];
		comp122[0][0] = "Freshman Composition";
		comp122[1][0] = "Math 102"; comp122[1][1] = "Math 104";
		comp122[2][0] = "Comp 108"; comp122[2][1] = "Comp 110";		
		
		String [][] comp182 = new String[3][2];
		comp182[0][0] = "Freshman Composition";
		comp182[1][0] = "Math 102";	comp182[1][1] = "Math 104";
		comp182[2][0] = "Comp 108";	comp182[2][1] = "Comp 110";
		
		
		String [][] comp282 = new String[3][3];
		comp282[0][0] = "Freshman Composition";
		comp282[1][0] = "Math 102";	comp282[1][1] = "Math 104"; comp282[1][2] = "Math 150A";
		comp282[2][0] = "Comp 108";	comp282[2][1] = "Comp 110"; comp282[2][2] = "Comp 182";

		String [][] comp380 = new String[3][4];
		comp380[0][0] = "Freshman Composition"; comp380[0][1] = "Oral Communication";
		comp380[1][0] = "Math 102";	comp380[1][1] = "Math 104"; comp380[1][2] = "Math 150A";
		comp380[2][0] = "Comp 108";	comp380[2][1] = "Comp 110"; comp380[2][2] = "Comp 182"; comp380[2][3] = "Comp 282";
				
		
		int i = 0;
		
		while( i < coursesAvailable.length)
		{
			if(sectionName == coursesAvailable[i])
			{
				
				switch(i)
				{
				 	case 0:
				 		return comp108;
				 	case 1:
				 		return comp110;
				 	case 2:
				 		return comp122;
				 	case 3:
				 		return comp182;
				 	case 4:
				 		return comp282;
				 	case 5:
				 		return comp380;
				}
			}
			i++;
		}
		//return no prerequisites by default should a course not be in coursesAvailable..
		return comp108;   
		
    }
    
    public void printPrereqs(String[][] p){
    	
    	System.out.print("GE's Required: ");
    	for (int i = 0; i < p[0].length; i++)
    	{
    		if(p[0][i]!=null)
    		System.out.print(p[0][i]+" ");
    		else
    			break;
    	}
    	System.out.println();
    	
    	System.out.print("Comp Sci's Required: ");
    	for (int i = 0; i < p[1].length; i++)
    	{
    		if(p[1][i]!=null)
    		System.out.print(p[1][i]+" ");
    		else
    			break;
    	}
    	System.out.println();
    	
    	System.out.print("Math Sci's Required: ");
    	for (int i = 0; i < p[0].length; i++)
    	{
    		if(p[2][i]!=null)
    		System.out.print(p[2][i]+" ");
    		else
    			break;
    	}
    }
    
 }
