/* 
 * Izzy Hasson, other NAMES 
 */
import java.util.*;
import java.util.HashMap;
/*
 * Global Var Names
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
        String s; //maybe change to Course
        int i;
        public void COP(String string, int integer){
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
        public int compareTo(COP p){
            return this.i - p.getInt();
        }
    }
// I haven't decided whether this will be included  in the final program.    
//    public static void permute(LinkedList lperm, LinkedList lx ) {   
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

    public static Planner generatePlanner(Student student){
    /* Step 1: find all needed courses */
    /* Step 2: Topological Sort */
    /* Step 3: Massage data into output format. */
    }
    private static ArrayList<COP> topologicalSort(ArrayList<Courses> list){
        J
    }
    private static void topoSort(){
    
    /**
     * Finds the dependencies of a course using depth first search
     */
    public static ArrayList<Course> findDependencies(Course c) {
        LinkedHashMap<String, COP> cList = 
            new LinkedHashMap<String, COP>();
        int depth = 0; // turns out keeping track of depth is pointless.
        ArrayList<Course> courseList = new ArrayList<>();
        ArrayList<COP> pairList= new ArrayList<>();
        findDependencies(c, cList, depth);
        pairList = clist.toArray();
        pairList.sort();
        for(COP p : pairList){
            courseList.add(GCT.get(p.getName()));
        }
        return courseList;
    }
    /*
     * Also finds dependencies but from an array of courses.
     * Note that it returns an array of COP because I need the ordering.
     */
    public static ArrayList<COP> findDependencies(
                        ArrayList<Course> courseList) {
        LinkedHashMap<String,COP> cList = new LinkedHashMap<>();
        for(Course c: courseList) {
            findDependencies(c, cList, 0);
        }
        return cList;
    }
    /*
     * A helper to the other methods of the same name.
     */
    private static void findDependencies(Course c, 
            LinkedHashMap<String,COP> cList, int depth) {
        if(cList.containsKey(c.getName())){
            return;
        } else {
            depth++;
            COP p = new COP(c.getName, depth);
            cList.put(c.getName(), p);
            for(String s : c.getPreRequisites()) { 
                // if get PreRequisites doesn't return a String array then
                // need to change above.
                if(!(cList.containsKey(s))){
                    findDependencies(globalCourseTable.get(s), cList, depth);
                    //need to know the name of the global Course Table
                }
            }
        }
    }
}

