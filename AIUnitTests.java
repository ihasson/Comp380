import java.util.*;
import java.io.*;

class AIUnitTests {
    public static void main(String[] argsv){
        AIAI ai = new AIAI();
        LinkedHashMap<String, Course> cTab = new LinkedHashMap<>();
        ArrayList<Course> clist = new ArrayList<>();

        Course comp380 = new Course("COMP 380/L",3, 9);
        comp380.addPreRequisite("COMP 282");
        comp380.addPreRequisite("PHIL 230");
        cTab.put(comp380.getName(), comp380);

        Course phil230 = new Course("PHIL 230",3, 9);
        cTab.put(phil230.getName(), phil230);
        
        Course comp282 = new Course("COMP 282",3, 9);
        comp282.addPreRequisite("COMP 182/L");
        comp282.addPreRequisite("MATH 150A");
        cTab.put(comp282.getName(), comp282);
        
        Course math150a = new Course("MATH 150A",3, 9);
        cTab.put(math150a.getName(), math150a);
        
        Course comp182 = new Course("COMP 182/L",3, 9);
        comp182.addPreRequisite("COMP 110/L");
        comp182.addPreRequisite("MATH 150A");
        cTab.put(comp182.getName(), comp182);
        
        Course comp110 = new Course("COMP 110/L",3, 9);
        comp110.addPreRequisite("MATH 150A");
        cTab.put(comp110.getName(), comp110);
        
        for(String s: cTab.keySet()){
            Course c = cTab.get(s);
            clist.add(c);
        }
        System.out.println("\nTest 1:");
        ai.topSortTest(clist);
        
        Course comp310 = new Course("COMP 310",3,9);
        comp310.addPreRequisite("MATH 326");
        cTab.put(comp310.getName(), comp310);
        clist.add(comp310);
        
        System.out.println("\nTest 2:");
        ai.topSortTest(clist);
    }
}

