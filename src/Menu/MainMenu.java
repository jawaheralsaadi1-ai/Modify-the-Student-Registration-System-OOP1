package Menu;

public class MainMenu implements MenuInterface {

    @Override
    public void showMenuHeader() {
        System.out.println("\n====================================");
        System.out.println("     UNIVERSITY MANAGEMENT SYSTEM    ");
        System.out.println("====================================");
    }

    @Override
    public void displayOptions() {
        System.out.println("1.  Manage Students");
        System.out.println("2.  Manage Teachers");
        System.out.println("3.  Manage Departments");
        System.out.println("4.  Manage Courses");
        System.out.println("0.  Exit System");
        System.out.print("\nSelect a category to continue: ");
    }
}