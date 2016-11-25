<?php
/****************************************************************************************
Name of Module:     DownloadOpenSeatsTxt.php
 
Purpose:    To collect updated open seats data for updating SPRING_2017_CS_SECTIONS.txt
       
		

Inputs:    Progammer must do the following:
          1. From csun.edu go to class search and select Computer Science.  
          2. Each class offered in the class search has to be manually clicked on in order for data to be loaded.
          3. After clicking on every class offered to see the available sections, using Google, right click, 
          inspect element, copy, and pasted into an html file named to_scrape.html.
		 

Outputs:    open_seats.txt is downloaded into your downloads folder.

Submodules: FileSaver.js, to_scrape.html

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
require_once("to_scrape.html");
?>

<script type = "text/javascript" src = "https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type = "text/javascript" src = "FileSaver.js"></script>
<script>
var class_names_counter = 0;
var sections_counter    = 0;
var class_names  = $("span.PABOLDTEXT#NR_SSS_SOC_NWRK_DESCR100_2\\$"+class_names_counter);
var section_nums = $("span.PSEDITBOX_DISPONLY#NR_SSS_SOC_NSEC_CLASS_NBR\\$"+sections_counter);
var components   = $("span.PSEDITBOX_DISPONLY#NR_SSS_SOC_NSEC_SSR_COMPONENT\\$"+ sections_counter);
var locations    = $("span#MAP\\$span\\$"+sections_counter+" a.PSHYPERLINK");
var daysOfWeek   = $("span.PSEDITBOX_DISPONLY#NR_SSS_SOC_NWRK_DESCR20\\$" + sections_counter);
var instructors  = $("#FACURL\\$span\\$"+sections_counter);
var times        = $("#NR_SSS_SOC_NSEC_DESCR25_2\\$"+sections_counter);
var seats_open   = $("span.PSEDITBOX_DISPONLY#NR_SSS_SOC_NSEC_CURAVAIL\\$" + sections_counter);
var content_to_write = "";

/*AS WE SCAN LOOKING FOR CLASS NAMES*/
while ( class_names[0]!=null) 
{
    console.log(class_names[0].innerText);

    while(section_nums[0]!=null) 
    {
        var str = section_nums[0].innerText + " " + components[0].innerText + " "+ locations[0].innerText + " " + 
        daysOfWeek[0].innerText + " " + times[0].innerText +" "+ instructors[0].innerText+" "+seats_open[0].innerText;
        /*          print a section in console.log        */
        console.log(str); 


        content_to_write += str+"\n";
        
        /*          Increment to next section      */
        sections_counter++;

        /*          Update section                */
        section_nums = $("span.PSEDITBOX_DISPONLY#NR_SSS_SOC_NSEC_CLASS_NBR\\$"     + sections_counter);
        components   = $("span.PSEDITBOX_DISPONLY#NR_SSS_SOC_NSEC_SSR_COMPONENT\\$" + sections_counter);
        locations    = $("span#MAP\\$span\\$"+sections_counter+" a.PSHYPERLINK");
        daysOfWeek   = $("span.PSEDITBOX_DISPONLY#NR_SSS_SOC_NWRK_DESCR20\\$"       + sections_counter);
        times        = $("#NR_SSS_SOC_NSEC_DESCR25_2\\$"                            + sections_counter);
        instructors  = $("#FACURL\\$span\\$"+sections_counter);
        seats_open   = $("span.PSEDITBOX_DISPONLY#NR_SSS_SOC_NSEC_CURAVAIL\\$"      + sections_counter);
    }

    /*          Increment to next class name      */
    class_names_counter++;

    /*          Update class name               */
    class_names = $("span.PABOLDTEXT#NR_SSS_SOC_NWRK_DESCR100_2\\$"+class_names_counter);
    
}

/*             Create File open_seats.txt      */
var file = new File([content_to_write], "open_seats.txt", {type: "text/plain;charset=utf-8"});


/*          Download the file to downloads folder.                */
saveAs(file);

           
</script>