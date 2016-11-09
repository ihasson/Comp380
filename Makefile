JCC = javac
#JFLAG = 

#default: 

Course.class: Course.java
	$(JCC) Course.java

format: 
	uncrustify -c uncrustify.cfg Course.java --no-backup

clean:
	$(RM) *.class
