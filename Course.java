import java.util.LinkedHashSet;
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
    private ArrayList<String[]> Prerequisites;

    public Course(){
        ;
    }

    public Boolean preReqCheck(ArrayList<String[]>){
        ;
    }
    public ArrayList<String[]> givePreReqs(){
        ;
    }
