package Services;

import Entities.Department;
import Entities.University;
import Behaviours.DepartmentInterface;
import java.util.Scanner;

public class DepartmentService implements DepartmentInterface {
    private final University uni;
    private final Scanner sc = new Scanner(System.in);

    public DepartmentService(University uni) { this.uni = uni; }

    @Override
    public void add() {
        System.out.print("Enter Department Name: ");
        Department d = new Department();
        d.setName(sc.nextLine());
        // ID is automatically generated as a UUID string in ParentEntity
        uni.getDepartments().add(d);
        System.out.println("✅ Department Added. ID: " + d.getId());
    }

    @Override
    public void update() {
        System.out.print("Enter UUID to Update: ");
        String id = sc.nextLine(); // Change from int to String
        uni.getDepartments().stream().filter(d -> d.getId().equals(id)).findFirst()
                .ifPresentOrElse(d -> {
                    System.out.print("New Name: ");
                    d.setName(sc.nextLine());
                    System.out.println("✅ Updated.");
                }, () -> System.out.println("❌ Not Found."));
    }

    @Override
    public void delete() {
        System.out.print("Enter UUID to Delete: ");
        String id = sc.nextLine(); // Change from int to String
        boolean removed = uni.getDepartments().removeIf(d -> d.getId().equals(id));
        if (removed) System.out.println("🗑️ Deleted.");
        else System.out.println("❌ Not Found.");
    }

    @Override
    public void displayAll() {
        if (uni.getDepartments().isEmpty()) System.out.println("List is empty.");
        uni.getDepartments().forEach(d -> System.out.println("[" + d.getId() + "] " + d.getName()));
    }

    @Override
    public void displayByName() {
        System.out.print("Search Name: ");
        String name = sc.nextLine();
        uni.getDepartments().stream().filter(d -> d.getName().equalsIgnoreCase(name))
                .forEach(d -> System.out.println("[" + d.getId() + "] " + d.getName()));
    }
}