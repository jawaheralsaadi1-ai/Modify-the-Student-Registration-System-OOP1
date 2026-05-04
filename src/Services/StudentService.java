package Services;

import Behaviours.UniversityInterface; // Import the interface
import Entities.Student;
import Entities.University;
import java.util.Scanner;

// ADD THE 'implements' KEYWORD HERE
public class StudentService implements UniversityInterface {
    private final University uni;// Access to our storage
    private final Scanner sc = new Scanner(System.in);

    public StudentService(University uni) {
        this.uni = uni;
    }
//1. ADD: Create a new student and save them
    @Override // Tells Java this is an interface requirement
    public void add() {
        System.out.println("\n--- Add New Student ---");
        Student s = new Student();
        System.out.print("Enter Student Name: ");
        //Student s = new Student();
        s.setName(sc.nextLine());
        // Add Email
       // System.out.print("Enter Email: ");
       // String email = sc.nextLine();
         // Validation
       // if (!email.contains("@")) {
         //   System.out.println(" Invalid email. Student not added.");
         //   return;}
        //s.setEmail(email);
        uni.getStudents().add(s);// Save into the list
        System.out.println(" Student added successfully!");
    }
// 2. UPDATE: Find a student by ID and change their name
    @Override
    public void update() {
        System.out.print("Enter Student ID to update: ");
        String searchId = sc.nextLine();

        for (Student s : uni.getStudents()) {
            if (s.getId().equals(searchId)) {
                System.out.print("Enter New Name: ");
                s.setName(sc.nextLine());
                System.out.println(" Name updated!");
                return;
            }
        }
        System.out.println(" Student not found.");
    }
// 3. DELETE: Remove a student from the list
    @Override
    public void delete() {
        System.out.print("Enter Student ID to delete: ");
        String searchId = sc.nextLine();
        boolean removed = uni.getStudents().removeIf(s -> s.getId().equals(searchId));

        if (removed) System.out.println("🗑️ Student removed.");
        else System.out.println(" ID not found.");
    }
// 4. DISPLAY ALL: Show every student in the list
    @Override
    public void displayAll() {
        if (uni.getStudents().isEmpty()) {
            System.out.println("The list is currently empty.");
        } else {
            for (Student s : uni.getStudents()) {
                System.out.println("ID: " + s.getId() + " | Name: " + s.getName());
            }
        }
    }
// 5. SEARCH BY NAME: Find students with a specific name
    @Override
    public void displayByName() {
        System.out.print("Enter name to search for: ");
        String searchName = sc.nextLine();
        for (Student s : uni.getStudents()) {
            if (s.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Match Found! ID: " + s.getId());
            }
        }
    }
}