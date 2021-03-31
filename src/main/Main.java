package main;

import database.DataSource;
import database.DatabaseConnection;
import onlineserver.OnlineConnectionServer;

import java.util.Scanner;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: main
 * Project Name: OnlineAssessmentFacultyPortal
 * Date: 28-03-2021
 */

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        databaseConnect();
        validateInvigilator();
    }

    /**
     * This method connect to database.
     */
    private static void databaseConnect() {
        DatabaseConnection.connectToDatabase();
    }

    /**
     * This method is used to enter credentials of invigilator.
     */
    private static void validateInvigilator() {
        System.out.println("Enter Invigilator id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Invigilator username: ");
        String username = scanner.nextLine();
        System.out.println("Enter Invigilator Password: ");
        String password = scanner.nextLine();
        checkInvigilator(id, username, password);
    }

    /**
     * This method checks validity of invigilator.
     *
     * @param id
     * @param username
     * @param password
     */
    private static void checkInvigilator(int id, String username, String password) {
        if (DataSource.checkInvigilatorValidity(DatabaseConnection.getConnection(), id, username, password)) {
            System.out.println("Access Granted");
            instructions();
        } else {
            System.err.println("Access Denied. Check Your Id, Username and Password.");
            validateInvigilator();
        }
    }

    /**
     * This method print the instructions to be followed by invigilator.
     */
    private static void instructions() {
        System.out.println("*".repeat(100) + "\nPress 1 to start online exam.\n" +
                "Press 2 to add question to question bank for exam.\n" +
                "Press 3 to add viva questions.\n" +
                "Press 4 to show students record.\n" +
                "Press 5 to show all questions from question bank.\n" +
                "Press 6 to show all viva questions.\n" +
                "Press 7 to end exam.");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1 -> startOnlineExam();
            case 2 -> addQuestionToBank();
            case 3 -> addVivaQuestion();
            case 4 -> showStudentsRecord();
            case 5 -> showQuestionFromQuestionBank();
            case 6 -> showVivaQuestions();
            case 7 -> endExam();
            default -> System.err.println("Invalid Input");
        }
    }

    /**
     * This method starts the exam.
     */
    private static void startOnlineExam() {
        System.out.println("Examination Started!!\nPlease wait for student to attend the exam.");
        OnlineConnectionServer.activateServer(true);
    }

    /**
     * This method add question to question bank
     */
    private static void addQuestionToBank() {
        DataSource.addQuestionToQuestionBank(DatabaseConnection.getConnection());
        instructions();
    }

    /**
     * This method add viva question to database.
     */
    private static void addVivaQuestion() {
        DataSource.addVivaQuestion(DatabaseConnection.getConnection());
        instructions();
    }

    /**
     * This method is used to show record of all students.
     */
    private static void showStudentsRecord() {
        DataSource.showStudentsRecord(DatabaseConnection.getConnection());
        instructions();
    }

    /**
     * This method is used to show all questions from question bank from database.
     */
    private static void showQuestionFromQuestionBank() {
        DataSource.showAllQuestionsFromQuestionBank(DatabaseConnection.getConnection());
        instructions();
    }

    /**
     * This method is used to show all viva questions from databse.
     */
    private static void showVivaQuestions() {
        DataSource.showAllVivaQuestions(DatabaseConnection.getConnection());
        instructions();
    }

    /**
     * this method is used to terminate the exam.
     */
    private static void endExam() {
        OnlineConnectionServer.activateServer(false);
    }
}
