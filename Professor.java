//Extends all common data from Person class into Student, Professor, and TA class
public class Professor extends Person {

	//Professor constructor for Person super class variables
	public Professor(String firstName, String lastName, String courseName, int courseHours) {
		super(firstName, lastName, courseName, courseHours);
	}

	/*This override function returns lecture hours*/
	@Override
	public int getParticipatingHours(int courseHours) {
		//Lab hours is 2 if course is more than 4 hours, otherwise 1
		int labHours = (courseHours > 4) ? 2 : 1;
		int lectureHours = courseHours - labHours;

		return lectureHours;
	}

	@Override
	public String getTitle() {
		//Returns the title of the Class
		return "Professor";
	}

}