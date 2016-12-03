/*
 TEST CLASS TEST CLASS TEST CLASS
 */
package pkg380;

import java.util.*;
import java.io.*;
import java.time.*;

public class ScheduleTest {

    Course c1, c2, c3, c4, c5;
    Planner planner;
    PlannerUnit plannerunit, plannerunit2, workingplannerunit;
    Schedule schedule;
    String thisone, fall, semester, spring, notify;
    int year, not;
    int k = 0;
    int count;
    ReadSections reader;
    HashMap<Integer, Section> fs, ss;
    ArrayList<Section> temp, temp1, temp2, finals, tmp;

    public static void main(String[] args) throws IOException {

        ScheduleTest main = new ScheduleTest();
        main.run();

    }

    //the following method is all testing
    public void run() throws IOException {

        //the following objects are all necessary for me to test my methods:
        c1 = new Course("name1", 3, 380);
        c2 = new Course("name2", 3, 500);
        c3 = new Course("name3", 3, 450);
        c4 = new Course("name4", 3, 600);
        c5 = new Course("name5", 3, 110);

        fs = new HashMap(30);
        

        planner = new Planner();

        plannerunit = new PlannerUnit(fall, 2016);
        plannerunit2 = new PlannerUnit(spring, 2017);

        plannerunit.allCourses.add(c1);
        plannerunit.allCourses.add(c2);
        plannerunit.allCourses.add(c3);
        plannerunit.allCourses.add(c4);

        plannerunit2.allCourses.add(c5);

        planner.allUnits.addFirst(plannerunit);
        planner.allUnits.add(plannerunit2);

        finals = new ArrayList();
        temp = new ArrayList();

        reader = new ReadSections();

        //this converts text file of sections to section objects in an arraylist<section>
        reader.getSections();

        //this tests my method for get courses from the planner's plannerunit. 
        getCourses("fall", 2016);
        /*    for (Course course : schedule.courses) {
         System.out.println("course name: " + course.getName());
         }*/
     
        //this tests my method for finding sections for those courses:
        courseToSection(schedule.courses, reader.listofsections);
        /*    for (int i = 0; i < schedule.schedule.size(); i++) {
         System.out.println("sections: " + schedule.schedule.get(i).getCourseID());
         }*/

        //this tests both my filters including notifying user if a filter removes all sections for a course
        noFridayFilter(schedule.courses, schedule.schedule);
        noEveningFilter(schedule.courses, schedule.schedule);
        for (int i = 0; i < schedule.schedule.size(); i++) {
            System.out.println("sections: " + schedule.schedule.get(i).getSectionID() + " CourseID: " + schedule.schedule.get(i).getCourseID() + " Days: " + schedule.schedule.get(i).getDaysOfWeek() + " Start time: " + schedule.schedule.get(i).getStartTime() + " Course name: " + schedule.schedule.get(i).getName());
        }

        //this tests my method for determining if two classes overlap in day/time:
        System.out.println(reader.listofsections.get(5).collides(reader.listofsections.get(6))); //should be true
        System.out.println(reader.listofsections.get(6).collides(reader.listofsections.get(7))); //should be false

        //      schedule.selections(schedule.schedule);
        //    System.out.println(schedule.selections.get(3).get(1).getSectionID());
        //      getSchedule(schedule.selections);
        //       for (int i = 0; i < temp2.size(); i++) {
        //           System.out.println("sections: " + temp2.get(i).getSectionID() + " CourseID: " + temp2.get(i).getCourseID() + " Days: " + temp2.get(i).getDaysOfWeek() + " Start time: " + temp2.get(i).getStartTime() + " Course name: " + temp2.get(i).getName());
        //    
        schedule.selections(schedule.schedule);
        //    System.out.println(schedule.selections.get(3).get(0).getDay());
//         System.out.println(schedule.selections.get(3).get(1).getDay());
        schedule(schedule.selections, schedule.schedule);

        for (int i = 0; i < finals.size(); i++) {
            System.out.println("sections: " + finals.get(i).getSectionID() + " CourseID: " + finals.get(i).getCourseID() + " Days: " + finals.get(i).getDaysOfWeek() + " Start time: " + finals.get(i).getStartTime() + " End time: " + finals.get(i).getEndTime() + " Course name: " + finals.get(i).getName());
        }

        for (int i = 0; i < tmp.size(); i++) {
            System.out.println(tmp.get(i).getCourseID());
        }
    }//end run

//takes the head plannerunit of the planner linked list and removes the courses in the plannerunit to the schedule.courses arraylist. 
    public void getCourses(String semester, int year) {
        schedule = new Schedule(semester, year);
        if (planner.allUnits.isEmpty()) {
            System.out.println("no plannerunit availble");
        } else {
            workingplannerunit = planner.allUnits.removeFirst();
        }
        if (workingplannerunit.allCourses.isEmpty()) {
            System.out.println("no courses in plannerunit");
        } else {
            for (int i = 0; i < workingplannerunit.allCourses.size(); i++) {
                schedule.courses.add(workingplannerunit.allCourses.get(i));
            }
        }
    }

    public void addCourse(Course c) {
        schedule.courses.add(c);
    }

    public void deleteCourse(Course c) {
        schedule.courses.remove(c);
    }

    //finds the sections that match the courses from the plannerunit based on courseID (ie 380)
    public void courseToSection() {

        for (int i = 0; i < schedule.courses.size(); i++) {
            int t = schedule.courses.get(i).getCourseID();

            for (int j = 0; j < reader.listofsections.size(); j++) {
                if (reader.listofsections.get(j).getCourseID() == t) {
                }
            }
        }

    }//end courseToSection

    public void courseToSection(ArrayList<Course> c, ArrayList<Section> s) { //pass schedule.course & reader.list

        for (int i = 0; i < c.size(); i++) {
            int t = c.get(i).getCourseID();

            for (int j = 0; j < s.size(); j++) {
                if (s.get(j).getCourseID() == t) {
                    fs.put(s.get(j).getCourseID(), s.get(j));
                    schedule.schedule.add(s.get(j));
                }
            }
            if (!fs.containsKey(t)) {
                System.out.println("Sections not available for course: " + t + " this semester. ");
            }

        }
    }//end courseToSection

//Filters out all sections offered on Fridays and notifies user if all options for a course have been filtered out. These filter methods will attach to jcheckbox
    public void noFridayFilter(ArrayList<Course> c, ArrayList<Section> s) { //pass schedule.schedule and schedule.course
        ss = new HashMap(30);
        for (int i = 0; i < c.size(); i++) {
            int t = c.get(i).getCourseID();

            for (int j = 0; j < s.size(); j++) {
                if (s.get(j).getDay() == 6) {
                    fs.remove(s.get(j).getCourseID());

                    s.remove(j);
                } else {
                    ss.put(s.get(j).getCourseID(), s.get(j));
                }
            }
            if (!ss.containsKey(t)) {
                System.out.println("Your day filter has removed all options for course " + t);
            }
        }
    }

    //no classes after time set. currently set at 16:30
    public void noEveningFilter(ArrayList<Course> c, ArrayList<Section> s) {
        ss = new HashMap(30);
        LocalTime time = LocalTime.of(16, 30);
        for (int i = 0; i < c.size(); i++) {
            int t = c.get(i).getCourseID();

            for (int j = 0; j < s.size(); j++) {
                if (s.get(j).getStartTime().compareTo(time) > 0) {
                    fs.remove(s.get(j).getCourseID());
                    s.remove(j);
                } else {
                    ss.put(s.get(j).getCourseID(), s.get(j));
                }
            }
            if (!ss.containsKey(t)) {
                System.out.println("Your time filter has removed all options for course " + t);
            }
        }
    }


//   pulls one of each. use in worst case to rig. 
public void rigIt() {
        ArrayList<Section> temp4 = new ArrayList();

        for (int i = 0; i < schedule.courses.size(); i++) {

            int temp = schedule.courses.get(i).getCourseID();
            int counter = 0;
            for (int j = 0; j < schedule.schedule.size(); j++) {
                if (schedule.schedule.get(j).getCourseID() == temp && counter == 0) {
                    temp4.add(schedule.schedule.get(j));
                    counter++;

                }
            }

            for (int k = 0; k < temp4.size(); k++) {
                System.out.println(temp4.get(k).getCourseID());
            }
        }
    }

    //at this point fs has all remaining sections and 
    public void schedule(ArrayList<ArrayList<Section>> selections, ArrayList<Section> sch) {
        int id;
        Section x;
        Section y;

        int p = 0;
        int q = 0;
        tmp = new ArrayList<>();

        for (int i = 1; i < selections.size(); i++) {
            x = selections.get(p).get(q); //380A 0,0
            //       id = selections.get(i).get(n).getCourseID(); //id at 1,0 is 500 

            for (int j = 0; j < selections.get(i).size(); j++) { //run through 500's sections
                if (selections.get(i).isEmpty()) {
                    break;
                }
                y = selections.get(i).get(j); //assign each section 1,0 1,1 1,2... for compaison
                if (!x.collides(y)) {
                    ss.put(y.getCourseID(), y);
                    finals.add(y);
                } else {
                    tmp.add(selections.get(i).remove(j)); //take colliding classes out

                }

            }//inner

        }//outer

        finals.add(selections.get(p).get(q));

    }

}//end Class
