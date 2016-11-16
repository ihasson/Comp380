/* 
 * Izzy Hasson, other NAMES 
 */
import java.util.*;

/**
 * Some anonymous helper functions for AIAI.
 */
/*
 * Global Var Names
 *
 */ 
interface Ai {
    public Object funcName(LinkedList<Object> input);
}


/**
 * The actual AI Class. It figures things out and makes decisions.
 */
class AIAI {

    class CourseOrderPair implements Comparable{
        String s;
        int i;
        public void Pair(String string, int integer){
            s = string;
            i = integer;
        }
        public String getString(){
            return s;
        }
        public int getInt(){
            return i;
        }
        public int compareTo(CourseOrderPair p){
            return this.i - p.getInt();
        }
    }
    
    public static void permute(LinkedList lperm, LinkedList lx ) {   
        if(lx.size() == 0){
        } else {
            for(int i = 0; i< lx.size(); i++) {
                LinkedList newlx = new LinkedList();
                LinkedList newlperm = new LinkedList();
                newlperm.addAll(lperm);
                newlx.addAll(lx);
                newlperm.add(newlx.remove(i));
                permute(newlperm, newlx);
            }
       // } else {
       //     //String s = new String();
       //     for(int i = 0; i< lperm.size(); i++) {
       //         s = s + lperm.get(i) + "  ";
       //     }
       //     out.println(s);
        }
    } 
    
    /**
     * Finds the dependencies of a course using depth first search
     */
    public static ArrayList<Course> findDependencies(Course c) {
        LinkedHashSet<String, Pair> cList = 
            new LinkedHashMap<String, Pair>();
        int depth = 0;
        ArrayList<Course> courseList = new ArrayList<>();
        ArrayList<Pair> pairList= new ArrayList<>();
        findDependencies(c, cList, depth);
        pairList = clist.toArray();
        pairList.sort();
        for(Pair p : pairList){
            courseList.add(GCT.get(p.getName()));
        }
        return courseList;
    }
    private static void findDependencies(Course c, 
            LinkedHashSet<String,Pair> cList, int depth) {
        if(cList.containsKey(c.getName())){
            return;
        } else {
            depth++;
            Pair p = new Pair(c.getName, depth);
            cList.put(c.getName(), p);
            for(String s : c.getPreRequisites()) { 
                // if get PreRequisites doesn't return a String array then
                // need to change gthe above.
                if(!(cList.containsValue(s))){
                    findDependencies(globalCourseTable.get(s), cList, depth);
                    //need to know the name of the global Course Table
                }
            }
        }
    }
}

