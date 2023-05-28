package com.quizproject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String city;
    private String email;
    private String mobileNumber;

    public Student(int id, String firstName, String lastName, String username, String password, String city, String email, String mobileNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.city = city;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public static Student registerStudent(Scanner scanner) {
        System.out.println("Enter the first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter the last name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter the username:");
        String username = scanner.nextLine();

        System.out.println("Enter the password:");
        String password = scanner.nextLine();

        System.out.println("Enter the city:");
        String city = scanner.nextLine();

        System.out.println("Enter the email:");
        String email = scanner.nextLine();

        System.out.println("Enter the mobile number:");
        String mobileNumber = scanner.nextLine();

        // Create a new Student object
        return new Student(0, firstName, lastName, username, password, city, email, mobileNumber);
    }

    public static Student login(Scanner scanner) {
        System.out.println("Enter the username:");
        String username = scanner.nextLine();

        System.out.println("Enter the password:");
        String password = scanner.nextLine();

        // Check the database for the username and password
        // Return the Student object if authenticated, otherwise return null
        return null;
    }
}