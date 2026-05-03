package Services;

import Entities.Department;
import Entities.University;
import Behaviours.UniversityInterface;
import java.util.Scanner;

public class DepartmentService implements UniversityInterface {
    private final University uni;
    private final Scanner sc = new Scanner(System.in);

    public DepartmentService(University uni) { this.uni = uni; }

    @Override
    public void add() {
        System.out.print("Enter Department Name: ");
        Department d = new Department();
        d.setName(sc.nextLine());
        uni.getDepartments().add(d); // Add to the specific Dept list
        System.out.println(" Department added. ID: " + d.getId());
    }

    @Override
    public void update() {
        System.out.print("Enter Department ID: ");
        String id = sc.nextLine();
        for (Department d : uni.getDepartments()) {
            if (d.getId().equals(id)) {
                System.out.print("New Dept Name: ");
                d.setName(sc.nextLine());
                System.out.println(" Updated!");
                return;
            }
        }
        System.out.println(" Department not found.");
    }

    @Override
    public void delete() {
        System.out.print("Enter ID: ");
        // We find the ID in the list and remove it
        boolean removed = uni.getDepartments().removeIf(d -> d.getId().equals(sc.nextLine()));
        System.out.println(removed ? "🗑️ Removed." : "Not found.");
    }

    @Override
    public void displayAll() {
        uni.getDepartments().forEach(d -> System.out.println("ID: " + d.getId() + " | Name: " + d.getName()));
    }

    @Override
    public void displayByName() {
        System.out.print("Search Department Name: ");
        String name = sc.nextLine();
        for (Department d : uni.getDepartments()) {
            if (d.getName().equalsIgnoreCase(name)) {
                System.out.println("Found ID: " + d.getId());
            }
        }
    }
}