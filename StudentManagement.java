import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int studentId;
    private String studentName;
    private double studentMark;

    public Student(int studentId, String studentName, double studentMark) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentMark = studentMark;
    }

    public int getstudentId() {
        return studentId;
    }

    public void setstudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setstudentMark(double studentMark) {
        this.studentMark = studentMark;
    }

    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + studentName + ", Marks: " + studentMark;
    }
}

public class StudentManagement {

    private static ArrayList<Student> student = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        int option;
        while (true) {
            System.out.println("\n-----------------Student Manegement System-----------------");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter any option from 1 to 5: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice....");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Mark: ");
        double marks = sc.nextDouble();

        student.add(new Student(id, name, marks));
        System.out.println("Student added successfully.");
    }

    private static void viewStudent() {
        if (student.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }

        System.out.println(".......\nList of Students:.......");
        for (Student s : student) {
            System.out.println(s);
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : student) {
            if (s.getstudentId() == id) {
                System.out.print("Enter new name: ");
                String name = sc.nextLine();
                System.out.print("Enter new marks: ");
                double marks = sc.nextDouble();
                s.setstudentName(name);
                s.setstudentMark(marks);
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        for (int i = 0; i < student.size(); i++) {
            if (student.get(i).getstudentId() == id) {
                student.remove(i);
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }
}