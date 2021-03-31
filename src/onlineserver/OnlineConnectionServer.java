package onlineserver;

import exam.ExaminationControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: onlineserver
 * Project Name: OnlineAssessmentFacultyPortal
 * Date: 29-03-2021
 */

public class OnlineConnectionServer {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ExaminationControl examinationControl = ExaminationControl.getInstance();

    /**
     * This method activates the server and establishes the link between student and invigilator.
     *
     * @param activate
     */
    public static void activateServer(boolean activate) {
        if (activate) {
            try (ServerSocket serverSocket = new ServerSocket(5000)) {
                Socket socket = serverSocket.accept();
                System.out.println("Student Connected\n" + "*".repeat(100));
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                String studentResponse = null;
                examinationControl.startExam(input, output, studentResponse, activate);

            } catch (IOException e) {
                System.err.println("Server Problem");
                e.printStackTrace();
            }
        } else {
            examinationControl.endExam();
        }
    }

    /**
     * This method is used to receive message from student.
     *
     * @param input
     */
    public static void receiveMessageFromStudent(BufferedReader input) {
        try {
            String studentResponse = input.readLine();
            System.out.println(studentResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to send message to student.
     *
     * @param output
     * @param message
     */
    public static void sendMessageToStudent(PrintWriter output, String message) {
        output.println(message);
    }
}
