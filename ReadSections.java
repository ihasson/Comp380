/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg380;

import java.io.*;
import java.util.*;
import java.time.LocalTime;
import java.time.format.*;

public class ReadSections extends Section {

    ArrayList<Section> listofsections;
    String sttime, entime;

  

    public void getSections() throws IOException {
        listofsections = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("k:mm"); //change the text file to 24 hour
        File file = new File("sections.txt");
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                courseID = input.nextInt();
                units = input.nextInt();
                sectionID = input.nextInt();
                daysOfWeek = input.next();  
                if (daysOfWeek.equalsIgnoreCase("MoWe")){
                    day = 2;
                }
                if( daysOfWeek.equalsIgnoreCase("TuTh")){
                    day = 3;
                }
                if (daysOfWeek.equalsIgnoreCase("Fr")){
                    day = 6;
                }
                sttime = input.next();
                sTime = LocalTime.parse(sttime, dtf);
                entime = input.next();
                eTime = LocalTime.parse(entime, dtf);
                courseName = input.next();
        //        System.out.println(courseID + " " + units + " " + sectionID);
                listofsections.add(new Section(sectionID, daysOfWeek, sTime, eTime, courseName, units, courseID, day));

            }
        }

    }
}
