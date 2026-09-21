//Extends all common data from Person class into Student class
public class Student extends Person {

	//firstName, lastName, courseName, courseHours is inherited from Person class
	public Student(String firstName, String lastName, String courseName, int courseHours) {
		super(firstName, lastName, courseName, courseHours);
	}

	//Override method for calculating totalHours
	@Override
	public int getParticipatingHours(int courseHours) {
		/*Utilizing labHours from TA to calculate total_hours*/
		int labHours = (courseHours > 4) ? 2 : 1;
		int totalHours = courseHours + labHours;
		return totalHours;
	}

	/*getTitle returns the title of Student*/
	@Override
	public String getTitle() {
		//Returns the title of Student
		return "Student";
	}

}