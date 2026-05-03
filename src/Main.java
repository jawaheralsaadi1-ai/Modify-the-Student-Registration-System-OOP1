import Entities.University;
import Services.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        University myUni = new University();
        Scanner sc = new Scanner(System.in);

        StudentService studentSrv = new StudentService(myUni);
        TeacherService teacherSrv = new TeacherService(myUni);
        DepartmentService deptSrv = new DepartmentService(myUni);
        CourseService courseSrv = new CourseService(myUni);

        while (true) {
            System.out.println("\n1. Student | 2. Teacher | 3. Dept | 4. Course | 0. Exit");
            String cat = sc.nextLine();
            if (cat.equals("0")) break;

            var srv = switch (cat) {
                case "1" -> studentSrv;
                case "2" -> teacherSrv;
                case "3" -> deptSrv;
                case "4" -> courseSrv;
                default -> null;
            };

            if (srv != null) {
                System.out.println("1.Add | 2.Update | 3.Delete | 4.Search | 5.List");
                String act = sc.nextLine();
                switch (act) {
                    case "1" -> srv.add();
                    case "2" -> srv.update();
                    case "3" -> srv.delete();
                    case "4" -> srv.displayByName();
                    case "5" -> srv.displayAll();
                }
            }
        }
    }
}