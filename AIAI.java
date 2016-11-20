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
public class GLOBAL{
    public static HashMap<String,Course> courseTable = new HashMap<>();
}
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
// I haven't decided whether this will be included  in the final program.    
//    public /*static*/ void permute(LinkedList lperm, LinkedList lx ) {   
//        if(lx.size() == 0){
//        } else {
//            for(int i = 0; i< lx.size(); i++) {
//                LinkedList newlx = new LinkedList();
//                LinkedList newlperm = new LinkedList();
//                newlperm.addAll(lperm);
//                newlx.addAll(lx);
//                newlperm.add(newlx.remove(i));
//                permute(newlperm, newlx);
//            }
//       // } else {
//       //     //String s = new String();
//       //     for(int i = 0; i< lperm.size(); i++) {
//       //         s = s + lperm.get(i) + "  ";
//       //     }
//       //     out.println(s);
//        }
//    } 
    /**
     * This determines what courses are needed and puts them into an ordered
     * list so that 
     */
    // Later need to check for type consistency and used correct method names
    public /*static*/ /*Planner*/ void  generatePlanner(Student student){
    /* Step 1: find all needed courses */
        //Planner plan = new Planner();
        Major maj = student.getMajor();
        ArrayList<Course> majorReqs = maj.getMajorRequirements();
        majorReqs = findDependencies(majorReqs);
        majorReqs = removeCoursesTaken(majorReqs,student.getCoursesTaken);
        
    /* Step : Topological Sort */
        ArrayList<COP> tentativePlan = topologicalSort(majorReqs);
    /* Step : transform the tentative plan into a firm plan */

    /* Step : Massage data into output format. */
        //return plan;
    }
    private /*static*/ ArrayList<COP> topologicalSort(ArrayList<Course> list){
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
    public /*static*/ ArrayList<Course> findDependencies(Course c) {
        LinkedHashMap<String, COP> cList = 
            new LinkedHashMap<String, COP>();
        int depth = 0; // turns out keeping track of depth is pointless.
        ArrayList<Course> courseList = new ArrayList<>();
        ArrayList<COP> pairList= new ArrayList<>();
        findDependencies(c, cList, depth);
        //pairList = clist.toArray();
        //pairList.sort();
        for(COP p : pairList){
            courseList.add(gCT.get(p.getString()));
        }
        return courseList;
    }
    /*
     * Also finds dependencies but from an array of courses.
     * Note that it returns an array of COP because I need the ordering.
     */
    public /*static*/ ArrayList<COP> findDependencies(
                        ArrayList<Course> courseList) {
        ArrayList<COP> solution = new ArrayList<>();
        LinkedHashMap<String,COP> cList = new LinkedHashMap<>();
        for(Course c: courseList) {
            findDependencies(c, cList, 0);
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
            LinkedHashMap<String,COP> cList, int depth) {
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
                    findDependencies(GLOBAL.courseTable.get(s), cList, depth);
                    //need to know the name of the global Course Table
                }
            }
        }
    }
}

