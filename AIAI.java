/* 
 * Izzy Hasson, other NAMES 
 */
import java.util.*;
import java.util.HashMap;
/*
 * Global Var Names
 * tempName for GlobalCourseTable = GCT;
 *
 */ 
/**
 * Some anonymous helper functions for AIAI.
 */
interface Ai {
    public Object funcName(LinkedList<Object> input);
}


/**
 * The actual AI Class. It figures things out and makes decisions.
 */
class AIAI {
/*
 * COP stands for Course Order Pair. It allows one to easily keep track of an 
 * integer to be temporarilly associated with a Cousrse.
 */
    class COP implements Comparable{
        private String s; //maybe change to Course
        private int i;
        COP(String string, int integer){
            s = string;
            i = integer;
        }
        public String getString(){
            return s;
        }
        public int getInt(){
            return i;
        }
        public void setInt(int a){
            i=a;
        }
        public int compareTo(Object o) throws ClassCastException{
            if(!(o instanceof COP)){
                throw new ClassCastException("object not COP");
            }
            int val = ((COP) o).getInt();
            return this.i - val;
        }
    }
    class CourseTable {
        private HashMap<String, Course>  gCT = new HashMap<>();
        CourseTable(ArrayList<Course> list){
            for(Course c : list){
                gCT.put(c.getName(), c);
            }
        }
        public Course get(String s){
            gCT.get(s);
        }
    }
    /**
     * This determines what courses are needed and puts them into an ordered
     * list so that 
     */
    // Later need to check for type consistency and used correct method names
    public /*static*/ /*Planner*/ void  generatePlanner(Student student, 
            CourseTable gCT){
    /* Step 1: find all needed courses */
        //Planner plan = new Planner();
        Major maj = student.getStudentMajor();
        ArrayList<Course> majorReqs = maj.getMajorReqs();
        ArrayList<COP> reqs = findDependencies(majorReqs, gCT);
        reqs = removeCoursesTaken(reqs,student.getCoursesTaken());
        
    /* Step : Topological Sort */
        ArrayList<COP> tentativePlan = topologicalSort(majorReqs, gCT);
    /* Step : transform the tentative plan into a firm plan */

    /* Step : Massage data into output format. */
        //return plan;
    }

    private /*static*/ ArrayList<COP> topologicalSort(ArrayList<Course> list,
            CourseTable gCT){
    /* Massage data into needed format. */
        LinkedHashMap<String,COP> graph = new LinkedHashMap<>();
        ArrayList<COP> solution = new ArrayList<>();       
        for(Course c : list){
            String s = c.getName();
            int num = 0;
            COP pair = new COP(s, num);
            graph.put(c.getName(), pair);
        }
        int i = 0;
        while(graph.size() != 0){
            ArrayList<COP> temp = new ArrayList<>();
    /* find nodes with no predessessor */
            graph.forEach((name, pair) -> { 
                Course  c = gCT.get(name);
                ArrayList<String> pReqs = c.getPreRequisites();
                for(String s : pReqs){
                    if(graph.containsKey(s)){
                        COP something  = graph.get(s);
                        something.setInt(something.getInt() + 1);
                    }
                }
            }); 
            /* number when the nodes were taken off the graph */
            /* if the node is not to be taken off the graph reset it */
            graph.forEach((name , pair) -> {
                if(pair.getInt() == 0){
                    pair.setInt(i);
                    temp.add(pair);
                } else {
                    pair.setInt(0);
                }
            });
            /* take nodes off graph and put them in solution set */
            for(COP pair : temp){
                graph.remove(pair.getString());
                solution.add(pair);
            }
            i++;
        }
        return solution;
    }
    
    /**
     * Finds the dependencies of a course using depth first search
     */
    public /*static*/ ArrayList<Course> findDependencies(Course c, 
            CourseTable gCT) {
        LinkedHashMap<String, COP> cList = 
            new LinkedHashMap<String, COP>();
        int depth = 0; // turns out keeping track of depth is pointless.
        ArrayList<Course> courseList = new ArrayList<>();
        ArrayList<COP> pairList= new ArrayList<>();
        findDependencies(c, cList, depth, gCT);
        //pairList = clist.toArray();
        //pairList.sort();
        for(COP p : pairList){
            courseList.add(gCT.get(p.getString())); //that damned coursetable
        }
        return courseList;
    }
    /*
     * Also finds dependencies but from an array of courses.
     * Note that it returns an array of COP because I need the ordering.
     */
    public /*static*/ ArrayList<COP> findDependencies(
                        ArrayList<Course> courseList, CourseTable gCT) {
        ArrayList<COP> solution = new ArrayList<>();
        LinkedHashMap<String,COP> cList = new LinkedHashMap<>();
        for(Course c: courseList) {
            findDependencies(c, cList, 0, gCT);
        }
        cList.forEach((s,elmt) -> {
            solution.add(elmt);
        });
        return solution;
    }
    /*
     * A helper to the other methods of the same name.
     */
    private /*static*/ void findDependencies(Course c, 
            LinkedHashMap<String,COP> cList, int depth, CourseTable gCT) {
        if(cList.containsKey(c.getName())){
            return;
        } else {
            depth++;
            COP p = new COP(c.getName(), depth);
            cList.put(c.getName(), p);
            for(String s : c.getPreRequisites()) { 
                // if get PreRequisites doesn't return a String array then
                // need to change above.
                if(!(cList.containsKey(s))){
                    findDependencies(gCT.get(s), cList, depth, gCT);
                    //need to know the name of the global Course Table
                }
            }
        }
    }
}

