import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty!");
                        break;
                    }

                    System.out.print("Enter roll number: ");
                    int rollNumber;
                    try {
                        rollNumber = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid roll number!");
                        break;
                    }

                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    if (grade.isEmpty()) {
                        System.out.println("Grade cannot be empty!");
                        break;
                    }

                    sms.addStudent(new Student(name, rollNumber, grade));
                    System.out.println("Student added successfully!");
                    break;

                case "2":
                    System.out.print("Enter roll number to remove: ");
                    try {
                        int removeRoll = Integer.parseInt(scanner.nextLine());
                        sms.removeStudent(removeRoll);
                        System.out.println("Student removed successfully!");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid roll number!");
                    }
                    break;

                case "3":
                    System.out.print("Enter roll number to search: ");
                    try {
                        int searchRoll = Integer.parseInt(scanner.nextLine());
                        Student found = sms.searchStudent(searchRoll);
                        if (found != null) {
                            System.out.println(found);
                        } else {
                            System.out.println("Student not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid roll number!");
                    }
                    break;

                case "4":
                    sms.displayAllStudents();
                    break;

                case "5":
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please select from 1 to 5.");
            }
        }
    }
}
