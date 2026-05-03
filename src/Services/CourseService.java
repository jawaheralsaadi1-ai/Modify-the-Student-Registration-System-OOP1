package Services;

import Entities.Course;
import Entities.University;
import Behaviours.UniversityInterface;
import java.util.Scanner;

public class CourseService implements UniversityInterface {
    private final University uni;
    private final Scanner sc = new Scanner(System.in);

    public CourseService(University uni) { this.uni = uni; }

    @Override
    public void add() {
        System.out.print("Enter Course Name: ");
        Course c = new Course();
        c.setName(sc.nextLine());
        uni.getCourses().add(c); // Save to the course list
        System.out.println("✅ Course added. ID: " + c.getId());
    }

    @Override
    public void update() {
        System.out.print("Enter Course ID: ");
        String id = sc.nextLine();
        for (Course c : uni.getCourses()) {
            if (c.getId().equals(id)) {
                System.out.print("New Course Name: ");
                c.setName(sc.nextLine());
                System.out.println(" Course updated!");
                return;
            }
        }
        System.out.println("Course not found.");
    }

    @Override
    public void delete() {
        System.out.print("Enter Course ID: ");
        boolean removed = uni.getCourses().removeIf(c -> c.getId().equals(sc.nextLine()));
        System.out.println(removed ? " Deleted." : " Not found.");
    }

    @Override
    public void displayAll() {
        if (uni.getCourses().isEmpty()) System.out.println("No courses available.");
        for (Course c : uni.getCourses()) {
            System.out.println("ID: " + c.getId() + " | Name: " + c.getName());
        }
    }

    @Override
    public void displayByName() {
        System.out.print("Enter course name to search: ");
        String name = sc.nextLine();
        for (Course c : uni.getCourses()) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println("Match ID: " + c.getId());
            }
        }
    }
}