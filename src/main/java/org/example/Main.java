package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6.  Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter City: ");
                    String city = sc.nextLine();

                    Student st = new Student(id, name, course, city);

                    StudentDAO.addStudent(st);

                    break;

                case 2:

                    StudentDAO.viewStudents();

                    break;

                case 3:

                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();

                    System.out.print("Enter New City: ");
                    String newCity = sc.nextLine();

                    Student updatedStudent =
                            new Student(updateId, newName, newCourse, newCity);

                    StudentDAO.updateStudent(updatedStudent);

                    break;

                case 4:

                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();

                    StudentDAO.deleteStudent(deleteId);

                    break;

                case 5:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();

                    StudentDAO.searchStudent(searchId);
                    break;

                case 6:
                    System.out.println("Thank You!");
                    return;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}
