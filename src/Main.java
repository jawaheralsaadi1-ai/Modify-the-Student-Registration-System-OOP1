import Entities.University;
import Services.*;
import Behaviours.UniversityInterface; // You must import the Interface
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize Storage and Scanner
        University myUni = new University();
        Scanner sc = new Scanner(System.in);

        // 2. Initialize Services
        StudentService studentSrv = new StudentService(myUni);
        TeacherService teacherSrv = new TeacherService(myUni);
        DepartmentService deptSrv = new DepartmentService(myUni);
        CourseService courseSrv = new CourseService(myUni);

        while (true) {
            System.out.println("\n--- UNIVERSITY SYSTEM ---");
            System.out.println("1. Student | 2. Teacher | 3. Dept | 4. Course | 0. Exit");
            String cat = sc.nextLine();

            if (cat.equals("0")) break;

            //  Use the Interface type so Java sees the CRUD methods
            UniversityInterface activeSrv = (UniversityInterface) switch (cat) {
                case "1" -> studentSrv;
                case "2" -> teacherSrv;
                case "3" -> deptSrv;
                case "4" -> courseSrv;
                default -> null;
            };

            if (activeSrv != null) {
                System.out.println("1.Add | 2.Update | 3.Delete | 4.Search | 5.List");
                String act = sc.nextLine();

                switch (act) {
                    case "1" -> activeSrv.add();           // Fixed: Replaced .wait() with .add()
                    case "2" -> activeSrv.update();        // Now works because of UniversityInterface type
                    case "3" -> activeSrv.delete();
                    case "4" -> activeSrv.displayByName();
                    case "5" -> activeSrv.displayAll();
                    default -> System.out.println("Invalid Action");
                }
            } else {
                System.out.println("Invalid Category");
            }
        }
        System.out.println("System Closed.");
    }
}