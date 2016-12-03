/*turn in to lingard
 */
package pkg380;

import java.util.*;

public class Schedule {

    String semester;
    int year, totalunits, maxunits, totaldiff, numcourses;
    ArrayList<Course> courses;
    ArrayList<Section> schedule, finalschedule;
    ArrayList<ArrayList<Section>> selections;

    public Schedule(String semester, int year) {
        courses = new ArrayList<>();
        schedule = new ArrayList<>();
        this.semester = semester;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public int getTotalUnits() {
        return totalunits;
    }

    public int getMaxUnits() {
        return maxunits;
    }

    public int getTotalDiff() {
        return totaldiff;

    }

    public int getNumCourses() {
        return numcourses;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMaxUnits(int maxunits) {
        this.maxunits = maxunits;
    }

    public void setTotalDiff(int totaldiff) {
        this.totaldiff = totaldiff;
    }

    public void setNumCourses(int numcourses) {
        this.numcourses = numcourses;
    }

    public void setTotalUnits(int totalunits) {
        this.totalunits = totalunits;
    }

    public void selections(ArrayList<Section> sections) { //creates a list of lists of sections separated by course
        ArrayList<Section> templist;
        selections = new ArrayList<>();
       
        for (int i = 0; i < courses.size(); i++) {
            templist = new ArrayList();
            
            int temp = courses.get(i).getCourseID();
            for (int j = 0; j < sections.size(); j++) {
                if (sections.get(j).getCourseID() == temp) {
                    templist.add(sections.get(j));
                }
           
            }
            selections.add(templist);
        }
        
    }

}//end class
