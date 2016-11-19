import java.util.*;
/**
 * Provides a container for information on a course offered at CSUN.
 */
class Course {
    private String subject;
    private String number;
    private Integer courseID;
    private String couseName;
    private Boolean hasLab;
    private int units;
    private int difficulty; /* for the demo difficulty will just be an int */ 
    private ArrayList<String[]> prerequisites;

    public Course(){
        ;
    }

    public Boolean preReqCheck(ArrayList<String[]> arr){
        ;
    }
    public ArrayList<String[]> getPrerequisites(){
        ;
    }
}
