/*

Name of Module: Planner

Purpose:    Creates the data structure to store a student's planner information,
            with courses logged for each term they enroll in.

Inputs:     None

Outputs:    Planner planner
            a planner for a student

Submodules: PlannerUnits
            composed of courses


Author:     Andrea Lee
Date:       11/13/16

Reviewer:   ???
Date:       ???


Revision History:
            Programmer:
            Date:
            Description of Change:
            Reviewer:
            Date of Review:

*/


//package planner;
import java.io.*;
import java.util.*;


public class Planner {
    // attributes stored in the class
    private LinkedList<PlannerUnit> allUnits;
    private String goalGraduationSemester;
    private int goalGraduationYear;
    
    // constructor
    public Planner() {
        allUnits = new LinkedList();
        goalGraduationSemester = "FALL";
        //goalGraduationYear = student.getStudentYearOfAdmittance() + 4;
        // For the purposes of the demo, all references to the Student class
        // will be commented out.
    }
    
    public Planner(int yrOfAdmittance) {
        allUnits = new LinkedList();
        goalGraduationSemester = "FALL";
        goalGraduationYear = yrOfAdmittance + 4;
    }
    
    // getters and setters
    public LinkedList getAllUnits() {
        return allUnits;
    }
    
    public String getGoalGraduationSemester() {
        return goalGraduationSemester;
    }
    
    public int getGoalGraduationYear() {
        return goalGraduationYear;
    }
    
    public void setAllUnits(LinkedList n) {
        allUnits = n;
    }
    
    public void setGoalGraduationSemester(String n) {
        goalGraduationSemester = n;
    }
    
    public void setGoalGraduationYear(int n) {
        goalGraduationYear = n;
    }
    
    // functions
    
    // returns the number of units currently in the planner
    public int numUnits() {
        return allUnits.size();
    }
    
    public void addUnit(String semester, int year) {
        PlannerUnit temp = new PlannerUnit (semester, year);
        this.allUnits.add(temp);
    }
    
    // ensures PlannerUnits are stored chronologically so that the earliest
    // information available is quickly accessed
    public void orderChornologically() {
        boolean sorted = false;
        
        for(int pass = 1; (pass<allUnits.size()) && !sorted; ++pass) {
            sorted = true; // assume sorted
            for(int index = 0; index<allUnits.size()-pass; ++index) {
                int nextIndex = index+1;
                if(allUnits.get(index).sortValue() >
                        allUnits.get(nextIndex).sortValue()) {
                    // if former is greater than latter, exchange items
                    PlannerUnit temp = allUnits.get(index);
                    
                    allUnits.get(index).
                            setSemester(allUnits.get(nextIndex).getSemester());
                    allUnits.get(index).
                            setYear(allUnits.get(nextIndex).getYear());
                    allUnits.get(index).
                            setMaxUnits(allUnits.get(nextIndex).getMaxUnits());
                    allUnits.get(index).
                            setDifficultyRating(allUnits.get(nextIndex).
                                    getDifficultyRating());
                    
                    allUnits.get(nextIndex).setSemester(temp.getSemester());
                    allUnits.get(nextIndex).setYear(temp.getYear());
                    allUnits.get(nextIndex).setMaxUnits(temp.getMaxUnits());
                    allUnits.get(nextIndex).
                            setDifficultyRating(temp.getDifficultyRating());

                    sorted = false; // signal exchange
                } // end if
            } // end for
        } // end for
    } // end orderChronologically
    
    // calculates the difficulty of a course
    public double calculateDifficultyRating(String cID) throws IOException {
        String ID;
        String courseID;
        String semester;
        String year;
        String hoursPerWeek;
        String grade;
        
        int totalHours = 0;
        int countHours = 0;
        double avgHours = 0;
        
        double totalGrade = 0;
        int countGrade = 0;
        double avgGrade = 0;
        
        // reads the hoursSurveyData text file to record total hours estimated
        // as well as the number of data points
        // ultimately used to calculate the average, using total/count
        File hoursFile = new File("C:\\1hoursSurveyData.txt");
        Scanner hoursInput = new Scanner(hoursFile);

        while (hoursInput.hasNextLine()) {
            ID = hoursInput.next();
            courseID = hoursInput.next();
            semester = hoursInput.next();
            year = hoursInput.next();
            hoursPerWeek = hoursInput.next();
            // a number of these variables aren't used in this code; however,
            // they have been kept for use in the future (e.g. filtering
            // to only take data from the past 3 years, or something of
            // that nature)
            
            if (cID.equals(courseID))
            {
                countHours++;
                totalHours = totalHours + Integer.parseInt(hoursPerWeek);
            }
        }
        
        hoursInput.close();
        
        // reads the gradeDistribution text file to record total grade points
        // with an A being 4.00, a B being 3.00, and so forth
        // as well as the number of data points
        // ultimately used to calculate the average, using total/count
        File gradeFile = new File("C:\\1gradeDistribution.txt");
        Scanner gradeInput = new Scanner(gradeFile);

        while (gradeInput.hasNextLine()) {
            ID = gradeInput.next();
            courseID = gradeInput.next();
            semester = gradeInput.next();
            year = gradeInput.next();
            grade = gradeInput.next();
            
            if (cID.equals(courseID))
            {
                countGrade++;
                
                if(grade.equals("A+")) {
                    totalGrade = totalGrade + 4.33;
                }
                else if(grade.equals("A")) {
                    totalGrade = totalGrade + 4.00;
                }
                else if(grade.equals("A-")) {
                    totalGrade = totalGrade + 3.67;
                }
                else if(grade.equals("B+")) {
                    totalGrade = totalGrade + 3.33;
                }
                else if(grade.equals("B")) {
                    totalGrade = totalGrade + 3.00;
                }
                else if(grade.equals("B-")) {
                    totalGrade = totalGrade + 2.67;
                }
                else if(grade.equals("C+")) {
                    totalGrade = totalGrade + 2.33;
                }
                else if(grade.equals("C")) {
                    totalGrade = totalGrade + 2.00;
                }
                else if(grade.equals("C-")) {
                    totalGrade = totalGrade + 1.67;
                }
                else if(grade.equals("D+")) {
                    totalGrade = totalGrade + 1.33;
                }
                else if(grade.equals("D")) {
                    totalGrade = totalGrade + 1.00;
                }
                else if(grade.equals("D-")) {
                    totalGrade = totalGrade + 0.67;
                }
                else {
                    totalGrade = totalGrade + 0.00;
                } // end if
            } // end if
        } // end while
        
        gradeInput.close();
        
        // the average is calculated; assumptions are made if no data was
        // available, with average hours defaulting to the course's unit
        // count, and average grade defaulting to a C, or 2.00
        if (totalHours > 0) {
            avgHours = totalHours/(countHours*1.0);
        }
        else {
            //avgHours = course.getUnit(cID);
            avgHours = 3;
        }
        
        if (totalGrade > 0) {
            avgGrade = totalGrade/(countGrade*1.0);
        }
        else {
            avgGrade = 2.00;
        }
        
        return avgHours/avgGrade;
    } // end calculateDifficultyRating

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) throws IOException {
        // TODO code application logic here

    
//    } // end main
    
}
