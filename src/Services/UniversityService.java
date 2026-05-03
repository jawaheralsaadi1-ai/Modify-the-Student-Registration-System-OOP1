package Services;

import Entities.University;
import Behaviours.UniversityInterface;
import java.util.Scanner;

public class UniversityService {
    // 1. Storage: This is where all our lists are kept
    private final University uni;

    // 2. Tools: We create our 4 specific logic tools here
    private final StudentService studentSrv;
    private final TeacherService teacherSrv;
    private final DepartmentService deptSrv;
    private final CourseService courseSrv;

    private final Scanner sc = new Scanner(System.in);

    // Constructor: When this service starts, it sets up our tools
    public UniversityService(University uni) {
        this.uni = uni;
        this.studentSrv = new StudentService(uni);
        this.teacherSrv = new TeacherService(uni);
        this.deptSrv = new DepartmentService(uni);
        this.courseSrv = new CourseService(uni);
    }

    // 3. The Master Switch: This picks which module to open
    public void startSystem() {
        while (true) {
            System.out.println("\n--- UNIVERSITY SYSTEM MAIN MENU ---");
            System.out.println("1. Students | 2. Teachers | 3. Departments | 4. Courses | 0. Exit");
            String choice = sc.nextLine();

            if (choice.equals("0")) break; // Exit and close

            // We use the UniversityInterface to treat all services the same way
            UniversityInterface activeModule = null;

            // Route the user to the right tool
            switch (choice) {
                case "1" -> activeModule = (UniversityInterface) studentSrv;
                case "2" -> activeModule = teacherSrv;
                case "3" -> activeModule = deptSrv;
                case "4" -> activeModule = courseSrv;
                default -> System.out.println(" Choice not found, try again.");
            }

            // If a valid module was chosen, show the Add/Update/Delete options
            if (activeModule != null) {
                runModuleActions(activeModule);
            }
        }
    }

    // 4. Shared Menu: This works for ANY module because they all follow the same Interface
    private void runModuleActions(UniversityInterface module) {
        System.out.println("1.Add | 2.Update | 3.Delete | 4.Search | 5.List All");
        String action = sc.nextLine();

        // The 'module' variable triggers the logic for the specific service
        switch (action) {
            case "1" -> module.add();
            case "2" -> module.update();
            case "3" -> module.delete();
            case "4" -> module.displayByName();
            case "5" -> module.displayAll();
            default -> System.out.println(" Action canceled.");
        }
    }
}