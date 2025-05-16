import java.util.*;

class Course {
    String courseCode;
    String courseName;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }
}

class Student {
    String name;
    String program;
    int semester;
    Map<Course, Integer> courseMarks;

    public Student(String name, String program, int semester) {
        this.name = name;
        this.program = program;
        this.semester = semester;
        this.courseMarks = new HashMap<>();
    }

    public void registerCourse(Course course, int marks) {
        courseMarks.put(course, marks);
    }

    public void printDetails() {
        System.out.println("Student: " + name);
        System.out.println("Program: " + program);
        System.out.println("Semester: " + semester);
        System.out.println("Registered Courses:");
        for (Course c : courseMarks.keySet()) {
            System.out.println("- " + c.courseName);
        }
    }

    public void printLowMarks() {
        for (Map.Entry<Course, Integer> entry : courseMarks.entrySet()) {
            if (entry.getValue() < 40) {
                System.out.println(name + " scored " + entry.getValue() + " in " + entry.getKey().courseName);
            }
        }
    }
}

public class University {
    public static void main(String[] args) {
        Course math = new Course("MTH101", "Mathematics");
        Course cs = new Course("CSE101", "Computer Science");

        Student s1 = new Student("Alice", "BSc Computer Science", 2);
        Student s2 = new Student("Bob", "BSc Mathematics", 1);

        s1.registerCourse(math, 35);
        s1.registerCourse(cs, 75);

        s2.registerCourse(math, 38);
        s2.registerCourse(cs, 90);

        System.out.println("\n=== Student Details ===");
        s1.printDetails();
        s2.printDetails();

        System.out.println("\n=== Students with Marks < 40 ===");
        s1.printLowMarks();
        s2.printLowMarks();
    }
}