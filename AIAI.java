/* 
 * Izzy Hasson, other NAMES 
 */
import java.util.Linked*;
import java.util.HashMap;
import java.util.Array*;
import java.util.Map;

//import Course;
//import Major;
//import Section;
//import Planner;
//import Schedule;
//import Student;
/**
 * Some anonymous helper functions for AIAI.
 */
/*
 * Global Var Names
 *
 * 
interface Ai {
    public Object funcName(LinkedList<Object> input);
}


/**
 * The actual AI Class. It figures things out and makes decisions.
 */
class AIAI {
    
    public static void permute(LinkedList lperm, LinkedList lx, ) {   
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
    public static LinkedList<Course> findDependencies(Course c) {
        LinkedHashMap<String, Course> cList = 
            new LinkedHashMap<String, Course>();
        findDependencies(c, cList);        
    }
    private static void findDependencies(Course c, 
                                    HashMap<String,Course> cList) {
        if(cList.containsKey(c.getName())){
            return;
        } else {
            cList.put(c.getName(), c);
            for(String s : c.getPreRequisites()) {
                if(!(cList.containsValue(s))){
                    findDependencies(globalCourseTable.get(s), cList);
                }
            }
        }
}

