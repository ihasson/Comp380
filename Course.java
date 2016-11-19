import java.util.*;
/**
 * Provides a container for information on a course offered at CSUN.
 */
class Course {
    private String subject; //don't need
    private String number; //don't need
    private Integer courseID; //don't need
    private String couseName; //NEED 
    private Boolean hasLab; //don't need
    private int units; //need
    private int difficulty; /* for the demo difficulty will just be an int */ //need
    private ArrayList<String> Prerequisites; //Need

    public Course(){
        ;
    }

    public Boolean preReqCheck(ArrayList<String>){
        ;
    }
    public ArrayList<String> givePreReqs(){
        ;
    }
