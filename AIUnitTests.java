import java.util.*;
import java.io.*;

class AIUnitTest {
    public static void main(String[] argsv){
        AIAI ai = new AIAI();
        LinkedHashMap<String, Course> cTab = new LinkedHashMap<>();
        ArrayList<Course> clist = new ArrayList<>();
        Course a = new Course("COMP 380/L",3, 9);
        a.addPreRequisite("COMP 282");
        a.addPreRequisite("PHIL 230");
        cTab.put(a.getName(), a);

        Course a1 = new Course("PHIL 230",3, 9);
        cTab.put(a1.getName(), a1);
        
        Course a2 = new Course("COMP 282",3, 9);
        a2.addPreRequisite("COMP 182/L");
        a2.addPreRequisite("MATH 150A");
        cTab.put(a2.getName(), a2);
        
        Course a3 = new Course("MATH 150A",3, 9);
        cTab.put(a3.getName(), a3);
        
        Course a4 = new Course("COMP 182/L",3, 9);
        a4.addPreRequisite("COMP 110/L");
        a4.addPreRequisite("MATH 150A");
        cTab.put(a4.getName(), a4);
        
        Course a5 = new Course("COMP 110/L",3, 9);
        a5.addPreRequisite("MATH 150A");
        cTab.put(a5.getName(), a5);
        
        for(String s: cTab.keySet()){
            Course c = cTab.get(s);
            clist.add(c);
        }        
        ai.topSortTest(clist);
    }
}

