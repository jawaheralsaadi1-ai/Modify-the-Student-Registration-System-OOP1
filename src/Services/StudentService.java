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
// 2. UPDATE: Modified for Name, Email, and Phone with Validation

    @Override

    public void update() {

        System.out.print("\n--- [ADMIN] Enter Student ID to Update: ");
        String searchId = sc.nextLine();
        for (Student s : uni.getStudents()) {

            if (s.getId().equals(searchId)) {
                System.out.println("Editing Profile: " + s.getName());
                System.out.print("Enter New Name: ");

                String newName = sc.nextLine();
                System.out.print("Enter New Email: ");
                String newEmail = sc.nextLine();

                System.out.print("Enter New Phone: ");
                String newPhone = sc.nextLine();

                // --- VALIDATION: Criterion #2 ---

                if (newName.trim().isEmpty() || !newEmail.contains("@")) {
                    System.out.println(" HTTP 400: Update Failed. Name and valid Email are required.");
                    return;
                }

             // --- DATA INTEGRITY: Update object fields ---
                s.setName(newName);
                s.setEmail(newEmail);
                s.setPhone(newPhone);
                // --- AUDIT LOGGING: Criterion #7 ---
                logAudit("UPDATE", searchId);
                System.out.println(" HTTP 200: Student record updated successfully.");
                return;
            }
        }
        System.out.println(" HTTP 404: Student not found.");
    }

    // 3. DELETE: Modified to include Auditing    @Override
    public void delete() {
        System.out.print("\n--- [ADMIN] Enter Student ID to Delete: ");
        String searchId = sc.nextLine();

        boolean removed = uni.getStudents().removeIf(s -> s.getId().equals(searchId));
        if (removed) {
            logAudit("DELETE", searchId);
            System.out.println(" HTTP 204!: Student removed.");

        } else {

            System.out.println("HTTP 404!: Student ID not found.");
        }
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
    /**
     * SINGLE DEFINITION: logAudit
     * Fixed the 'Ambiguous call' by keeping only this version.
     */
    private void logAudit(String action, String targetId) {
        String timestamp = LocalDateTime.now().toString();
        System.out.println("[AUDIT LOG] " + timestamp + " | Action: " + action + " | ID: " + targetId);
    }

}