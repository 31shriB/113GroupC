package com.quizproject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.Scanner;

import com.quizproject.DBConnection;

class Question {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/quizdb?characterEncoding=utf8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root123";

    private int id;
    private String question;
    private List<String> options;
    private int answer;

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getAnswer() {
        return answer;
    }
   
    public static void displayQuestions() {
        List<Question> questions = new ArrayList<>();

        // Establish a database connection
        try {
        	Connection con=DBConnection.getCon();
            // Retrieve questions from the database
            String selectQuery = "SELECT * FROM java_quiz";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);

            Scanner scanner = new Scanner(System.in);
 		   int id = 1;
            int score =0;
            // Display each question and get the user's answer
            while (resultSet.next()) {
                int questionId = resultSet.getInt("question_id");
                String questionText = resultSet.getString("question_text");
                String optionA = resultSet.getString("option_a");
                String optionB = resultSet.getString("option_b");
                String optionC = resultSet.getString("option_c");
                String optionD = resultSet.getString("option_d");
                String correctAnswer = resultSet.getString("correct_answer");

                System.out.println("Question " + questionId + ": " + questionText);
                System.out.println("1. " + optionA);
                System.out.println("2. " + optionB);
                System.out.println("3. " + optionC);
                System.out.println("4. " + optionD);
                StoredResult.quizAnswer(scanner, id, questionId);
                System.out.println();
                System.out.print("Your Answer: ");
                String userAnswer = scanner.nextLine();
                System.out.println();
                // Check if the user's answer is correct
                if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                    score++;
                }
            }
             
            // Display the final score
            System.out.println("Quiz Result :");
            System.out.println("Your Score: " + score);
        System.out.println();
            resultSet.close();
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        

    }
}