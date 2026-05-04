package Services;

import Behaviours.UniversityInterface; // Import the interface
import Entities.Student;
import Entities.University;
import java.util.Scanner;
import java.time.LocalDateTime;// ADD NEW Required for Audit Logging
/**
 * STUDENT SERVICE
 * Manages the "Rules" of the university for Student records.
 */
// ADD THE 'implements' KEYWORD HERE
public class StudentService implements UniversityInterface {
    private final University uni;// Access to our storage
    private final Scanner sc = new Scanner(System.in);

    public StudentService(University uni) {
        this.uni = uni;
    }

//1. ADD: Create a new student and save them
  // Tells Java this is an interface requirement

    // 1. ADD: improve to include Email and Phone
        @Override
        public void add() {
            System.out.println("\n--- [ACTION] Add New Student ---");
            Student s = new Student();

            System.out.print("Enter Name: ");
            s.setName(sc.nextLine());

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            // Basic Validation check
            if (email.isEmpty() || !email.contains("@")) {
                System.out.println(" HTTP 400: Invalid email. Student not added.");
                return;
            }
            s.setEmail(email);

            System.out.print("Enter Phone: ");
            s.setPhone(sc.nextLine());

            uni.getStudents().add(s);
            System.out.println(" Status 201: Student added successfully! ID: " + s.getId());
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