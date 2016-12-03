package Builder;
/**
 * 
 * @author Jonathan Carrasco
 * 12/2/2016
 * COMP 380
 * 
 * This class is used to hold all pertinent information for a course section.
 * <p>
 * The values of a Section object are strings and are as follows:
 * course, className, type, units, section, location, days, startTime, endTime,
 * teacher, preReqs
 *
 */

public class Section {
	
	private String course;
	private String className;
	private String type;
	private String units;
	private String section;
	private String location;
	private String days;
	private String startTime;
	private String endTime;
	private String teacher;
	private String preReqs;


	/**
	 * Section class constructor.
	 * The constructor creates a Section object.
	 * The constructor has no parameters and is empty, making all values set to null.
	 */
	public Section(){
		//empty constructor... all values set to null
	}
	
	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getUnits() {
		return units;
	}


	public void setUnits(String units) {
		this.units = units;
	}


	public String getSection() {
		return section;
	}


	public void setSection(String section) {
		this.section = section;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getDays() {
		return days;
	}


	public void setDays(String days) {
		this.days = days;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public String getTeacher() {
		return teacher;
	}


	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	public void setPreReq(String preReq){
		this.preReqs = preReq;
	}
	
	public String getPreReq(){
		return preReqs;
	}
	

}
