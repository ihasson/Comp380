import java.util.LinkedHashSet;

class Course {
    private String subject;    
    private String number;    
    private Integer courseID;
    private String couseName; 
    private Boolean hasLab;
    private int units;
    
    private ArrayList<String[]> Prerequisites;
    
    private Difficulty estimatedDifficulty = new Difficulty(units);
    private Difficulty actualDifficulty = new Difficulty(units);

    public Course(){;}
    
    public Boolean preReqCheck(ArrayList<String[]>){;}
    public ArrayList<String[]> givePreReqs(){;}
}

class Difficulty{
    LinkedHashSet<String, int>  gradeDist;
/*
    int letterA;
    int aMinus;
    int bPlus;
    int letterB;
    int bMinus;
    int cPlus;
    int letterC;
    int cMinus;
    int dPlus;
    int letterD;
    int dMinus;
    int fPlus;   //does this even exist?
    int letterF;
*/  
    int units;

    public Difficulty(){
        gradeDist = new LinkedHashSet<String,int>();
    }
    public addGrades(){;}
    public average(){
        float gradeVal = 4.0;
    } 

