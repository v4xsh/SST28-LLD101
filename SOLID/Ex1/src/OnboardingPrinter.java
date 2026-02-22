import java.util.List;

public class OnboardingPrinter {
    public void printInput(String rawInput) {
        System.out.println("INPUT: " + rawInput);
    }

    public void printErrors(List<String> errors) {
        System.out.println("ERROR: cannot register");
        for (String e : errors)
            System.out.println("- " + e);
    }

    public void printSuccess(StudentRecord rec, int totalStudents) {
        System.out.println("OK: created student " + rec.id);
        System.out.println("Saved. Total students: " + totalStudents);
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
}
