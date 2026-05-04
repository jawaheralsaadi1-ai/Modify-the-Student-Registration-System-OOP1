package Services;

import Entities.Teacher;
import Entities.University;
import Behaviours.UniversityInterface;
import java.util.Scanner;
import java.time.LocalDateTime;// ADD NEW Required for Audit Logging

/*
 * Teacher SERVICE
 * Manages the "Rules" of the university for Teacher records.
 */

//// ADD THE 'implements' KEYWORD HERE
public class TeacherService implements UniversityInterface {
    private final University uni; // This is our storage box (the data warehouse)
    private final Scanner sc = new Scanner(System.in); // To read what the user types

    public TeacherService(University uni) {
        this.uni = uni;
    }

    @Override
    public void add() {
        System.out.print("\\n--- [ACTION] Register New Teacher --- ");
        Teacher t = new Teacher(); // Create a new Teacher object (it gets a UUID automatically)
        System.out.print("Enter Faculty Name: ");
        t.setName(sc.nextLine());  // Set the name from user input

        System.out.print("Enter Official Email: ");
        String email = sc.nextLine();
        if (!email.contains("@")) {
            System.out.println(" HTTP 400: Invalid email format.");
            return;
        }
        t.setEmail(email);
        System.out.print("Enter Phone Number: ");
        t.setPhone(sc.nextLine());

        uni.getTeachers().add(t);  // Save the teacher into our university list
        System.out.println(" Status 201: Teacher registered with ID: " + t.getId());
    }

    @Override
    public void update() {
        System.out.print("Enter Teacher ID to change: ");
        String id = sc.nextLine();
        // We loop through the list to find the teacher with this matching ID
        for (Teacher t : uni.getTeachers()) {
            if (t.getId().equals(id)) {
                System.out.print("Enter New Name: ");
                t.setName(sc.nextLine()); // Change the name
                System.out.println(" Updated successfully!");
                return; // Stop once we find and update the teacher
            }
        }
        System.out.println(" Teacher ID not found.");
    }

    @Override
    public void delete() {
        System.out.print("Enter Teacher ID to delete: ");
        String id = sc.nextLine();
        // removeIf is a simple way to find the ID and delete it in one step
        boolean removed = uni.getTeachers().removeIf(t -> t.getId().equals(id));
        System.out.println(removed ? " Teacher removed." : " ID not found.");
    }

    @Override
    public void displayAll() {
        if (uni.getTeachers().isEmpty()) {
            System.out.println("No teachers registered yet.");
        } else {
            // Loop and print every teacher's unique ID and Name
            for (Teacher t : uni.getTeachers()) {
                System.out.println("ID: " + t.getId() + " | Name: " + t.getName());
            }
        }
    }

    @Override
    public void displayByName() {
        System.out.print("Enter Teacher Name to search: ");
        String name = sc.nextLine();
        for (Teacher t : uni.getTeachers()) {
            // equalsIgnoreCase ignores Capital letters during the search
            if (t.getName().equalsIgnoreCase(name)) {
                System.out.println("Match found! ID: " + t.getId());
            }
        }
    }
}