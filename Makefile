JCC = javac
JFLAG = -g
AI = AIAI.java Course.java Planner.java Section.java Major.java \
	 Planner.java PlannerUnit.java Student.java 

UI = LeftPanel.java MainFrame.java Options.java RightPanel.java #App.java
	 
TEST = AIUnitTests.java  
OTHER = CsSectionsTextfileUpdater.java
#DATA = open_seats.txt spring_2017_cs_sections.txt cs_sections.txt \
		OutputForSectionUnitTest.txt

AIAI.class: AIAI.java Course.class Planner.class Section.class Major.class \
			Student.class
	$(JCC) AIAI.java

AIUnitTests.class: AIUnitTests.java AIAI.class 
	$(JCC) AIUnitTests.java

test-AI: AIUnitTests.class AIAI.class
	java AIUNitTests 

Course.class: Course.java
	$(JCC) Course.java

Section.class: Section.java Course.class
	$(JCC) Section.java

Planner.class: Planner.java
	$(JCC) Planner.java

Major.class: Major.java
	$(JCC) Major.java

Student.class: Student.java
	$(JCC) Student.java

UI.class: AIAI.class $(UI)
	$(JCC) UI.java

testcompile: $(AI) $(UI) $(TEST) $(OTHER) 
	$(JCC) $(TEST)

format: 
	uncrustify -c uncrustify.cfg Course.java --no-backup

docs:
	$(MAKE) -C documentation

clean:
	$(RM) *.class
