/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author harde
 */

public class CourseHours {

    public static void main(String[] args) {

        //14 records 
        String[] records = {
            "Professor Isaac Newton Physics 6",
            "TA Marie Curie Physics 6",
            "Professor Isaac Newton Calculus 4",
            "Student Amy Adams Calculus 4",
            "Student Will Smith Calculus 4",
            "Student Brad Pitt Physics 6",
            "Student Will Smith Physics 6",
            "Professor Dmitri Mendeleev Chemistry 6",
            "TA Carl Gauss Calculus 4",
            "Student Amy Adams Economics 3",
            "Professor Adam Smith Economics 3",
            "TA Marie Curie Chemistry 6",
            "Student Brad Pitt Chemistry 6",
            "Student Will Smith Chemistry 6"
        };

        //an array of person objects
        Person[] people = new Person[records.length];

        // Create the objects from the records
        for (int i = 0; i < records.length; i++) {

            String[] data = records[i].split(" ");

            String title = data[0];
            String firstName = data[1];
            String lastName = data[2];
            String courseName = data[3];
            int courseHours = Integer.parseInt(data[4]);

            if (title.equals("Professor")) {
                people[i] = new Professor(firstName, lastName, courseName, courseHours);
            }
            else if (title.equals("TA")) {
                people[i] = new TA(firstName, lastName, courseName, courseHours);
            }
            else {
                people[i] = new Student(firstName, lastName, courseName, courseHours);
            }
        }

        //arrays to store each person one time and their total hours
        Person[] uniquePeople = new Person[records.length];
        int[] totalHours = new int[records.length];

        int count = 0;

        //checks for duplicate people
        for (int i = 0; i < people.length; i++) {

            boolean found = false;

            for (int j = 0; j < count; j++) {

                if (uniquePeople[j].getFirstName().equals(people[i].getFirstName())
                        && uniquePeople[j].getLastName().equals(people[i].getLastName())
                        && uniquePeople[j].getTitle().equals(people[i].getTitle())) {

                    totalHours[j] = totalHours[j]
                            + people[i].getParticipatingHours(people[i].getCourseHours());

                    found = true;
                    break;
                }
            }

            //adds a new person if they aren't already there
            if (!found) {
                uniquePeople[count] = people[i];

                totalHours[count] =
                        people[i].getParticipatingHours(people[i].getCourseHours());

                count++;
            }
        }

        //print each person once
        for (int i = 0; i < count; i++) {
            System.out.println(
                    uniquePeople[i].getTitle() + " "
                    + uniquePeople[i].getFirstName() + " "
                    + uniquePeople[i].getLastName() + " "
                    + totalHours[i]
            );
        }
    }
}
