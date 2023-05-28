package com.quizproject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.Scanner;
public class QuizApplication {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/quizdb?characterEncoding=utf8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz Application!");

        while (true) {
            System.out.println("User Operations:");
            System.out.println("1. Student Registration");
            System.out.println("2. Student Login");
            System.out.println("3. Display the list of questions");
            System.out.println("4. Display Quiz result");
            System.out.println("Admin Operations:");
            System.out.println("5. Display all students' scores in ascending order");
            System.out.println("6. Fetch student score by student ID");
            System.out.println("7. Add a question with 4 options into the database");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Student student = Student.registerStudent(scanner);
                   
                    break;
                case 2:
                    Student loggedInStudent = Student.login(scanner);
                   
                    break;
                case 3:
                	  Question  question = new Question();
                	  question.displayQuestions();
                    break;
                case 4: 
                	
                	
                	
                    // Store the quiz result for the logged-in student into the database
                    // ...
                    break;
                case 5:
                     
                	
                    // Display the quiz result for the logged-in student
                    // ...
                    break;
                case 6:
                    // Display all students' scores in ascending order
                    // ...
                    break;
                case 7:
                    // Fetch and display a student's score by student ID
                    // ...
                    break;
                case 8:
                    // Add a question with 4 options into the database
                    // ...
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}