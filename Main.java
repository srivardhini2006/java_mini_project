 import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Update Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    System.out.println("Exiting... Bye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    static void addStudent() {
        System.out.print("Enter student id: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        students.add(new Student(id, name));
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            System.out.println("ID: " + s.id + ", Name: " + s.name);
        }
    }

    static void deleteStudent() {
        if (students.isEmpty()) {
            System.out.println("No students to delete.");
            return;
        }

        System.out.print("Enter student id to delete: ");
        int id = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id == id) {
                students.remove(i);
                found = true;
                System.out.println("Student deleted successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    static void updateStudent() {
        if (students.isEmpty()) {
            System.out.println("No students to update.");
            return;
        }

        System.out.print("Enter student id to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        boolean found = false;

        for (Student s : students) {
            if (s.id == id) {
                System.out.print("Enter new name: ");
                String newName = sc.nextLine();
                s.name = newName;
                found = true;
                System.out.println("Student updated successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}