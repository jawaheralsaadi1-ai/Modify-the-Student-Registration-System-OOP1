package Services;

import Entities.Student;
import Entities.University;
import Behaviours.UniversityInterface;
import java.util.Scanner;

public class StudentService implements UniversityInterface {
    private final University uni; // This is our storage box (the database)
    private final Scanner sc = new Scanner(System.in); // To read what the user types

    public StudentService(University uni) {
        this.uni = uni;
    }

    @Override
    public void add() {
        System.out.print("Enter Student Name: ");
        Student s = new Student(); // Create a new empty student
        s.setName(sc.nextLine());  // Give the student a name from the keyboard
        uni.getStudents().add(s);  // Put the student into our list
        System.out.println(" Added! Student ID is: " + s.getId()); // The ID comes from ParentEntity
    }

    @Override
    public void update() {
        System.out.print("Enter Student ID to change: ");
        String searchId = sc.nextLine();
        // We look through the whole list to find the matching ID
        for (Student s : uni.getStudents()) {
            if (s.getId().equals(searchId)) {
                System.out.print("Enter New Name: ");
                s.setName(sc.nextLine()); // Update the name
                System.out.println(" Name updated successfully!");
                return; // Stop the loop once we are done
            }
        }
        System.out.println(" Could not find a student with that ID.");
    }

    @Override
    public void delete() {
        System.out.print("Enter Student ID to delete: ");
        String searchId = sc.nextLine();
        // removeIf is a simple way to find and delete an item at the same time
        boolean removed = uni.getStudents().removeIf(s -> s.getId().equals(searchId));
        if (removed) System.out.println("🗑️ Student removed.");
        else System.out.println(" ID not found.");
    }

    @Override
    public void displayAll() {
        if (uni.getStudents().isEmpty()) {
            System.out.println("The list is currently empty.");
        } else {
            // Loop through and print every student in the list
            for (Student s : uni.getStudents()) {
                System.out.println("ID: " + s.getId() + " | Name: " + s.getName());
            }
        }
    }

    @Override
    public void displayByName() {
        System.out.print("Enter name to search: ");
        String searchName = sc.nextLine();
        for (Student s : uni.getStudents()) {
            // ignoreCase means it doesn't matter if you use CAPITAL letters or small letters
            if (s.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Match Found! ID: " + s.getId());
            }
        }
    }
}