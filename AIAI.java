/**
 * Class: AIAI
 * 
 * @Author Izzy Hasson
 */

import java.util.*;

/**
 * The actual AI Class. It figures things out and makes decisions.
 * <p>
 * <img src="doc-files/AIAI-1.png" alt="topological sort">
 * <img src="doc-files/AIAI-2.png" alt="topological sort">  
 */
public class AIAI {

/**
 * COP stands for Course Order Pair. It allows one to easily keep track of an 
 * integer to be temporarilly associated with a Course.
 */
   protected class COP implements Comparable{
        private String s; //maybe change to Course
        private int i;
        public  COP(String string, int integer){
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
        public  int compareTo(Object o) throws ClassCastException{
            if(!(o instanceof COP)){
                throw new ClassCastException("object not COP");
            }
            int val = ((COP) o).getInt();
            return this.i - val;
        }
    }

/**
 * A simple inner class to make things easier and fake having
 * actual global variables.
 */
   protected class CourseTable {
        private HashMap<String, Course>  gCT = new HashMap<>();
        CourseTable(ArrayList<Course> list){
            for(Course c : list){
                gCT.put(c.getName(), c);
            }
        }
        public Course get(String s){
            return gCT.get(s);
        }
    }

/**
 * A constructor that does nothing so that you can call methods.
 */
    public AIAI(){
        ;
    }
//This is still a work in progress.
/**
 * This determines what courses are needed and puts them into a Planner. 
 * The difficulty when using this method has no reasonable limit.
 * <p>
 * @param   student The student information.
 * @param   gCT the Fake Global Course Table.
 * @return  Planner.
 */
    public Planner generatePlanner(Student student, CourseTable gCT){
        return generatePlanner(student, gCT, 9001);
    }
/**
 * This determines what courses are needed and puts them into a Planner. 
 * <p>
 * @param   student The student information.
 * @param   gCT the Fake Global Course Table.
 * @param   paramSource figure out limitations on how much work the student
 *          should do from this.
 * @return  Planner.
 */
    public Planner generatePlanner(Student student, CourseTable gCT, 
                    Planner paramSource){
        int defaultDifficulty = 48; // for now will not use.
        if(paramSource.numUnits() == 0){
            return generatePlanner(student, gCT, 9001);
        } else {
            //For now do the same thing either way.
            return generatePlanner(student, gCT, 9001);
        }
    }            
/**
 * This determines what courses are needed and puts them into a Planner. 
 * <p>
 * @param   student The student information.
 * @param   gCT the Fake Global Course Table.
 * @param   maxDifficulty takes as input maximum difficulty value.
 * @return      Planner.
 */
    public Planner generatePlanner(Student student, CourseTable gCT, 
                    int maxDifficulty){
        int semNumb = 0;
        Planner plan = new Planner();
        Major maj = student.getStudentMajor();
        ArrayList<Course> majorReqs = maj.getMajorReqs();
        ArrayList<Course> reqs = findDependencies(majorReqs, gCT);
        reqs = removeCoursesTaken(reqs,student);      
        return genPlan(reqs, gCT, semNumb, maxDifficulty, plan);
    }
    public Planner genPlan(ArrayList<Course> courses, CourseTable gCT,
                    int maxDifficulty, int semNumb, Planner plan){
        if(courses.isEmpty()){ 
            return plan;
        }else{            
            int curDifficulty = 0;
            ArrayList<COP> tentativePlan = topologicalSort(courses, gCT);
            String semester = new String("Semester " + semNumb);
            PlannerUnit curSem = new PlannerUnit(semester, maxDifficulty);
            ArrayList<Course> restOfCourses = new ArrayList<>();
            
            for(ListIterator<COP> li = tentativePlan.listIterator();
                    li.hasNext();){
                COP c = li.next();
                Course curCour = gCT.get(c.getString());
                
                if((c.getInt() == 0) && 
                        (curCour.getDifficulty() + curDifficulty <= 
                         maxDifficulty)){
                    LinkedList<Course> tlx = curSem.getAllCourses();
                    tlx.add(curCour);
                    li.remove();
                    curDifficulty += curCour.getDifficulty();
                } else {
                    restOfCourses.add(curCour);
                }                    
            }
            plan.addUnit(curSem);
            return genPlan(restOfCourses, gCT, 
                            maxDifficulty, semNumb++, plan);
        }           
    }

    // need to make sure Sina tested his check course taken method properly
    // need to test this since it probably won't work as is. 
    private ArrayList<Course> removeCoursesTaken(ArrayList<Course> reqs,
                    Student stu) {   
        for(Course c : reqs){
            if(stu.courseTaken(c)){
                reqs.remove(c);
            }
        }
        return reqs;
    }
/**
 * <img src="doc-files/AIAI-2.png" alt="topological sort">
 */
/**
 * topologicalSort() sorts the courses of the course as follows:
 * Let the list of Courses passed to this method be a directed 
 * acyclic graph with each Course object in that list being a node.
 * Let the prerequisites of each course represesnt edges pointing from
 * the prerequisite to the node with the prerequisite but only if
 * said prerequisite is in the graph.
 * The following algorithm enumerates the number of edges pointing to 
 * each node. Then it removes all nodes with no antecedents from the 
 * graph.
 * The algorithm repeats until there are no more nodes in the graph.
 * 
 * @param list  The courses to be sorted by order the courses can be taken.
 * @param gCT   A master lookup table of courses.
 * @return      The courses each paired with a number indicating ordering.
 * @see         COP
 * <p>
 *
 * <img src="doc-files/AIAI-1.png" alt="topological sort">
 */
/* 
 * note that elements of prerequisite list represent edges pointing
 * AWAY from the prerequisite.
 */
    protected ArrayList<COP> topologicalSort(ArrayList<Course> list,
                    CourseTable gCT){
    /* 
     * Massage data into needed format. 
     */
        LinkedHashMap<String,COP> graph = new LinkedHashMap<>();
        ArrayList<COP> solution = new ArrayList<>();       
        for(Course c : list){
            String s = c.getName();
            int num = 0;
            COP pair = new COP(s, num);
            graph.put(c.getName(), pair);
        }
        int i = 0;
        while(graph.size() !=0){
            for(String nodeName: graph.keySet()){
                COP node = graph.get(nodeName);
                Course thisnode = gCT.get(nodeName);
                ArrayList<String> antecedents = thisnode.getPreRequisites();
                if(antecedents.size() > 0){
                    for(String pred : antecedents){
                        if(graph.containsKey(pred)){
                            node.setInt(1+ node.getInt());
                        }
                    }
                }
            }
            LinkedHashMap<String, COP> newgraph = new LinkedHashMap<>();
            for(String nodeName: graph.keySet()){
                COP node = graph.get(nodeName);
                if(node.getInt() == 0){
                    node.setInt(i);
                    solution.add(node);    
                }
                else{ 
                    node.setInt(0);
                    newgraph.put(nodeName, node);
                }
            }
            graph = newgraph;
            i++;
        }
        return solution;
    }
    
    /**
     * Finds the dependencies of a course using depth first search
     * @param c
     * @param gCT
     */
    public ArrayList<Course> findDependencies(Course c, CourseTable gCT) {
        LinkedHashMap<String, COP> cList = 
            new LinkedHashMap<String, COP>();
        int depth = 0; // turns out keeping track of depth is pointless.
        ArrayList<Course> courseList = new ArrayList<>();
        ArrayList<COP> pairList= new ArrayList<>();
        findDependencies(c, cList, depth, gCT);
        //pairList = clist.toArray(); //Can't remember what this line was for.
        //pairList.sort();            //Nor this.
        for(COP p : pairList){
            courseList.add(gCT.get(p.getString()));
        }
        return courseList;
    }

    /*
     * Probably will deprecate.
     * Also finds dependencies but from an array of courses.
     * Note that it returns an array of COP because I need the ordering.
     */
    private  ArrayList<Course> findDependencies(ArrayList<Course> courseList,
                    CourseTable gCT) {
        ArrayList<Course> solution = new ArrayList<>();
        LinkedHashMap<String,COP> cList = new LinkedHashMap<>();
        for(Course c: courseList) {
            findDependencies(c, cList, 0, gCT);
        }
        cList.forEach((s,elmt) -> {
            solution.add(gCT.get(elmt.getString()));
        });
        return solution;
    }
    
    /*
     * A helper to the other methods of the same name.
     */
    private void findDependencies(Course c, LinkedHashMap<String,COP> cList, 
                    int depth, CourseTable gCT) {
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
    
/**
 * This method exists for the sole purpose of testing topologicalSort().
 * It runs the method and prints the out put.
 */
    public void topSortTest(ArrayList<Course> list){
        CourseTable  gCT = new CourseTable(list);
        ArrayList<COP> solution = topologicalSort(list, gCT);
        for(COP c: solution){
            System.out.println(c.getString() + " semester "+ c.getInt());
        }
    }
}

