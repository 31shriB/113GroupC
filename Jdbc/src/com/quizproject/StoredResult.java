package com.quizproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StoredResult {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/quizdb?characterEncoding=utf8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root123";

    private int id;
    private int questionId;
    private int userAnswer;

    public StoredResult(int id, int questionId, int userAnswer) {
        this.id = id;
        this.questionId = questionId;
        this.userAnswer = userAnswer;
    }

    public int getId() {
        return id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public int getUserAnswer() {
        return userAnswer;
    }

    public static void quizAnswer(Scanner scanner, int id, int questionId) {
        System.out.print("Your Answer: ");
        int userAnswer = scanner.nextInt();
        System.out.println();

        // Store the user answer in the database
        storeUserAnswer(id, questionId, userAnswer);
    }

    private static void storeUserAnswer(int id, int questionId, int userAnswer) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            System.out.println("Database connection established.");

            // Prepare the SQL statement to insert the user answer
            String sql = "INSERT INTO user_answers (id, question_id, selected_option) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.setInt(2, questionId);
                statement.setInt(3, userAnswer);

                // Execute the SQL statement
                int rowsInserted = statement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("User answer stored successfully.");
                } else {
                    System.out.println("Failed to store user answer.");
                }
            } catch (SQLException e) {
                System.out.println("Error executing the SQL statement: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}