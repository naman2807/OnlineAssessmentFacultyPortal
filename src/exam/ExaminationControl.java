package exam;

import onlineserver.OnlineConnectionServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: exam
 * Project Name: OnlineAssessmentFacultyPortal
 * Date: 30-03-2021
 */

public final class ExaminationControl {
    private static final Scanner scanner = new Scanner(System.in);

    private ExaminationControl() {
    }

    /**
     * @return ExaminationControl instance
     */
    public static ExaminationControl getInstance() {
        return new ExaminationControl();
    }

    /**
     * This method starts the exam and communicate between student and invigilator.
     *
     * @param input
     * @param output
     * @param studentResponse
     * @param activate
     */
    public void startExam(BufferedReader input, PrintWriter output, String studentResponse, boolean activate) {
        try {
            studentResponse = input.readLine();
            System.out.println(studentResponse + " is active to give exam.");
            instruct(input, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is extension of above method.
     */
    private void instruct(BufferedReader input, PrintWriter output) {
        System.out.println("Ask him to press 1 to start exam.\n" +
                "Press enter to send message");
        String response = scanner.nextLine();
        if (response.equals("")) {
            output.println("Press 1 to start the exam.");
            OnlineConnectionServer.receiveMessageFromStudent(input);
            askVivaQuestion(output);
            OnlineConnectionServer.receiveMessageFromStudent(input);
            OnlineConnectionServer.receiveMessageFromStudent(input);
        } else {
            System.err.println("Invalid Input.");
            instruct(input, output);
        }

    }

    /**
     * This method ends the exam.
     */
    public void endExam() {
        System.out.println("Thank You! Meet you soon");
        System.exit(0);
    }

    /**
     * This method send the alert message to student about the viva.
     *
     * @param output
     */
    private void askVivaQuestion(PrintWriter output) {
        try {
            Thread.sleep(3000L);
            OnlineConnectionServer.sendMessageToStudent(output, "You will be getting 1 question for " +
                    "viva within 5 seconds. Press 2 to take your viva question.");
        } catch (InterruptedException e) {
            System.err.println("Error occurred");
            e.printStackTrace();
        }
    }

}
