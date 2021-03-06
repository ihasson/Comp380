/*
 */

import java.util.*;

public class Schedule {
    
    String semester;
    int year, totalunits, maxunits, totaldiff, numcourses;
    ArrayList<Section> schedule;

    public Schedule(String semester, int year) {
        schedule = new ArrayList<>();
        this.semester = semester;
        this.year = year;
    }

    public int getYear(){
        return year;
    }
    
    public int getTotalUnits(){
        return totalunits;
    }
    
    public int getMaxUnits(){
        return maxunits;
    }
    
    public int getTotalDiff(){
        return totaldiff;
       
    }
    
    public int getNumCourses(){
        return numcourses;
    }
    
    public String getSemester(){
        return semester;
    }
    
    public void setSemester(String semester){
        this.semester = semester;
    }
    
    public void setYear(int year){
        this.year = year;
    }
    
    public void setMaxUnits(int maxunits){
        this.maxunits = maxunits;
    }
    
    public void setTotalDiff(int totaldiff){
        this.totaldiff = totaldiff;
    }
    
    public void setNumCourses(int numcourses){
        this.numcourses = numcourses;
    }
    
    public void setTotalUnits(int totalunits){
        this.totalunits = totalunits;
    }
    
}//end class
