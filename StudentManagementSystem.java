import java.util.Scanner;

// Class to represent each student
class Student {
    int id;
    String name;
    double grade;
    Student next;

    // Constructor to initialize a student
    public Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.next = null;
    }
}

// Class to manage the linked list of students
class StudentList {
    private Student head;

    // Constructor to initialize an empty student list
    public StudentList() {
        this.head = null;
    }

    // Method to add a new student to the list
    public void addStudent(int id, String name, double grade) {
        Student newStudent = new Student(id, name, grade);
        if (head == null) {
            head = newStudent;
        } else {
            Student current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newStudent;
        }
        System.out.println("Student added successfully.");
    }

    // Method to display all students in the list
    public void displayStudents() {
        if (head == null) {
            System.out.println("No students in the list.");
        } else {
            Student current = head;
            System.out.println("List of Students:");
            while (current != null) {
                System.out.println("ID: " + current.id + ", Name: " + current.name + ", Grade: " + current.grade);
                current = current.next;
            }
        }
    }

    // Method to search for a student by ID
    public void searchStudent(int id) {
        Student current = head;
        while (current != null) {
            if (current.id == id) {
                System.out.println("Student found:");
                System.out.println("ID: " + current.id + ", Name: " + current.name + ", Grade: " + current.grade);
                return;
            }
            current = current.next;
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Method to delete a student by ID
    public void deleteStudent(int id) {
        if (head == null) {
            System.out.println("No students in the list.");
            return;
        }
        if (head.id == id) {
            head = head.next;
            System.out.println("Student with ID " + id + " deleted successfully.");
            return;
        }
        Student current = head;
        while (current.next != null) {
            if (current.next.id == id) {
                current.next = current.next.next;
                System.out.println("Student with ID " + id + " deleted successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Student with ID " + id + " not found.");
    }
}

// Main class to test the Student Management System
public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentList studentList = new StudentList();

        while (true) {
            System.out.println("\nWelcome to Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete Student by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline character
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Grade: ");
                    double grade = scanner.nextDouble();
                    studentList.addStudent(id, name, grade);
                    break;
                case 2:
                    studentList.displayStudents();
                    break;
                case 3:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = scanner.nextInt();
                    studentList.searchStudent(searchId);
                    break;
                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    studentList.deleteStudent(deleteId);
                    break;
                case 5:
                    System.out.println("Exiting Program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
