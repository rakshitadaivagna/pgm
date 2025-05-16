import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class StudentApp {
    static class Student {
        private String name;
        private LocalDate dob;

        public Student(String name, String dobStr) {
            this.name = name;
            this.dob = parseDate(dobStr);
        }

        private LocalDate parseDate(String dobStr) {
            DateTimeFormatter[] formats = {
                DateTimeFormatter.ofPattern("dd-MM-yyyy"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd")
            };

            for (DateTimeFormatter fmt : formats) {
                try {
                    return LocalDate.parse(dobStr, fmt);
                } catch (Exception ignored) {}
            }

            throw new IllegalArgumentException("Invalid date format. Use DD-MM-YYYY or YYYY-MM-DD");
        }

        public int calculateAge() {
            return Period.between(dob, LocalDate.now()).getYears();
        }

        public void displayInfo() {
            System.out.println("Student Name: " + name);
            System.out.println("Student Age: " + calculateAge());
        }
    }
    static class StudentCourses {
        private final Map<Integer, Map<String, Integer>> semesterCourses = new HashMap<>();

        public void addSemesterCourses(int semester, Map<String, Integer> courses) {
            semesterCourses.put(semester, courses);
        }

        public void displayCourses() {
            for (Map.Entry<Integer, Map<String, Integer>> entry : semesterCourses.entrySet()) {
                System.out.println("\nSemester " + entry.getKey() + ":");
                for (Map.Entry<String, Integer> course : entry.getValue().entrySet()) {
                    System.out.println("  " + course.getKey() + ": " + course.getValue());
                }
            }
        }
    }
    public static void main(String[] args) {

        Student student = new Student("Alice", "2002-09-15");
        student.displayInfo();

        StudentCourses courses = new StudentCourses();

        Map<String, Integer> semester1 = new HashMap<>();
        semester1.put("Math", 85);
        semester1.put("Physics", 90);
        courses.addSemesterCourses(1, semester1);

        Map<String, Integer> semester2 = new HashMap<>();
        semester2.put("Chemistry", 88);
        semester2.put("Biology", 92);
        courses.addSemesterCourses(2, semester2);

        courses.displayCourses();
    }
}