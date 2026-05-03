import Entities.University;
import Services.UniversityService;

public class Main {
    public static void main(String[] args) {
        University data = new University();
        UniversityService controller = new UniversityService(data);
        controller.startSystem();
    }
}