package Services;

import Entities.Department;// This must match  with your folder name

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DepartmentService  {
    // Using a List to store departments in memory
    private List<Department> departments = new ArrayList<>();

    // 1. Add Department
    public void addDepartment(String name) {
        Department newDept = new Department(UUID.randomUUID(), name);
        departments.add(newDept);
        System.out.println("Department added successfully!");
    }

    // 2. Update Department
    public void updateDepartment(UUID id, String newName) {
        for (Department dept : departments) {
            if (dept.getId().equals(id)) {
                dept.setName(newName);
                return;
            }
        }
    }

    // 3. Delete Department
    public void deleteDepartment(UUID id) {
        departments.removeIf(dept -> dept.getId().equals(id));
    }

    // 4. Display by Name
    public void displayByName(String name) {
        for (Department dept : departments) {
            if (dept.getName().equalsIgnoreCase(name)) {
                System.out.println(dept);
            }
        }
    }

    // 5. Display All
    public void displayAll() {
        for (Department dept : departments) {
            System.out.println("ID: " + dept.getId() + " | Name: " + dept.getName());
        }
    }
}