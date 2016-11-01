JCC = javac
#JFLAG = 

#default: 

Course.class: Course.java
	$(JCC) Course.java

clean:
	$(RM) *.class
