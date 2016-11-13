JCC = javac
JFLAG = -g

#default: 
AIAI.class: AIAI.java
	$(JCC) AIAI.java

AIUnitTests.class: AIUnitTests.java AIAI.class 
	$(JCC) AIUnitTests.java

test-AI: AIUnitTests.class AIAI.class
	java AIUNitTests 

Course.class: Course.java
	$(JCC) Course.java

Section.class: Section.java Course.class
	$(JCC) Section.java

format: 
	uncrustify -c uncrustify.cfg Course.java --no-backup

clean:
	$(RM) *.class
