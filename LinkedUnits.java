/*******************************************************************************

Name of Module: LinkedUnits

Purpose:    Creates the data structure to hold the entirety of a planner's
            planner units

Inputs:     None

Outputs:    LinkedUnits linkedUnits
            a structure that links a planner's individual units together

Submodules: None


Author:     Andrea Lee
Date:       11/13/16

Reviewer:   ???
Date:       ???


Revision History:
            Programmer:
            Date:
            Description of Change:
            Reviewer:
            Date of Review:

*******************************************************************************/


package planner;


public class LinkedUnits {
    // attributes stored in the class
    private PlannerUnit head;
    private int llSize;
    
    // constructor
    public void LinkedUnits() {
        head = null;
        llSize = 0;
    } // end LinkedList constructor
    
    // getters and setters
    public PlannerUnit getHead() {
        return head;
    } // end getHead
    
    // functions
    // inserts Node at the beginning of the list
    public void insertAtHead(String semseter, int year) {
        PlannerUnit n = new PlannerUnit(semseter, year);
        
        n.setNext(head);
        head = n;
        
        llSize++;
    } // end insertAtHead
    
    // inserts Node at the end of the list
    public void insertAtTail(String semseter, int year) {
        PlannerUnit n = new PlannerUnit(semseter, year);
        PlannerUnit runner = head;
        
        if (head == null)
            head = n;
        else {
            while (runner.getNext() != null)
                runner = runner.getNext();

            runner.setNext(n);
        }
        
        llSize++;
    } // end insertAtTail
    
    // inserts Node at the provided index
    public void insert(String semseter, int year, int index) {
        PlannerUnit n = new PlannerUnit(semseter, year);
        PlannerUnit runner = head;
        int count = 0;
        
        if (index == 0) { // insertAtHead
            n.setNext(head);
            head = n;
        }
        else if (index < 0 || index > llSize-1)
            return;
        else if (index == llSize) { // insertAtTail
            while (runner.getNext() != null)
                runner = runner.getNext();

            runner.setNext(n);
        }
        else { // insertAtIndex
            while (count < index-1) {
                runner = runner.getNext();
                count++;
            }
            
            n.setNext(runner.getNext());
            runner.setNext(n);
        }
        
        llSize++;
    } // end insert
    
    // deletes Node at the beginning of the list
    public void deleteAtHead() {
        if (head != null) {
            head = head.getNext();
            llSize--;
        }
    } // end deleteAtHead
    
    // deletes Node at the end of the list
    public void deleteAtTail() {
        PlannerUnit runner = head;
        
        if (head == null)
            return;
        else if (head.getNext() == null)
            head = null;
        else {
            while (runner.getNext().getNext() != null)
                runner = runner.getNext();
            
            runner.setNext(null);
        }
        
        llSize--;
    } // end deleteAtTail
    
    // deletes Node at the provided index
    public void delete(int index) {
        PlannerUnit runner = head;
        int count = 0;
        
        if (index < 0 || index > llSize-1)
            return;
        else if (index == 0) { // deleteAtHead
            if (head != null) {
                head = head.getNext();
            }
        }
        else if (index == llSize-1) { // deleteAtTail
            if (head == null)
                return;
            else if (head.getNext() == null)
                head = null;
            else {
                while (runner.getNext().getNext() != null)
                    runner = runner.getNext();

                runner.setNext(null);
            }
        }
        else { // deleteAtIndex
            while (count < index-1) {
                runner = runner.getNext();
                count++;
            }
            
            runner.setNext(runner.getNext().getNext());
        }
        
        llSize--;
    } // end delete
    
    // looks for and returns the index number of the given semester and year
    public int getIndex(String semester, int year) {
        PlannerUnit runner = head;
        
        if (head.getSemester() == semester && head.getYear() == year)
            return 0;
        else {
            for (int i = 0; i<llSize; i++) {
                if (runner.getSemester() == semester && head.getYear() == year)
                    return i;
                else
                    runner = runner.getNext();
            }

            return -1;
        }
    } // end getIndex
    
    // looks for and returns Node of the given position
    public PlannerUnit findByIndex(int index) {
        int curr = 0;
        PlannerUnit runner = head;
        
        if (index >= llSize)
            return null;
        
        while(curr < llSize && curr != index) {
            runner = runner.getNext();
            curr++;
        }
        
        return runner;
    }
    
    // swaps the attributes of two units without affecting their
    // predecessor and successor units
    public void swap (PlannerUnit a, PlannerUnit b) {
        String tempSemester;
        int tempYear;
        int tempMaxUnits;
        int tempDifficultyRating;
        
        tempSemester = a.getSemester();
        tempYear = a.getYear();
        tempMaxUnits = a.getMaxUnits();
        tempDifficultyRating = a.getDifficultyRating();
        
        a.setSemester(b.getSemester());
        a.setYear(b.getYear());
        a.setMaxUnits(b.getMaxUnits());
        a.setDifficultyRating(b.getDifficultyRating());
        
        b.setSemester(tempSemester);
        b.setYear(tempYear);
        b.setMaxUnits(tempMaxUnits);
        b.setDifficultyRating(tempDifficultyRating);
    //private Course[] allCourses;
    }
    
    // checks to see if the list is empty
    public boolean isEmpty() {
        return (head == null);
    } // end isEmpty
    
    // returns size of list
    public int size() {
        return llSize;
    } // end size
} // end LinkedList