package database;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: database
 * Project Name: OnlineAssessmentFacultyPortal
 * Date: 28-03-2021
 */

public final class SQlQueries {
    private static final String FACULTY_TABLE = "faculty";
    private static final String FACULTY_NAME = "name";
    private static final String FACULTY_ID = "id";
    private static final String FACULTY_USERNAME = "username";
    private static final String FACULTY_PASSWORD = "password";
    private static final String QUESTION_BANK_TABLE = "questionbank";
    private static final String QUESTION_SERIAL_NUMBER = "serial_number";
    private static final String QUESTION = "question";
    private static final String VIVA_QUESTION_TABLE = "vivaquestion";
    private static final String VIVA_QUESTION_SERIAL_NUMBER = "s_no";
    private static final String VIVA_QUESTION = "question";
    private static final String STUDENT_TABLE = "students";

    /**
     * @return SQL query to add new question.
     */
    public static String addNewQuestionQuery() {
        return "INSERT INTO " + QUESTION_BANK_TABLE + "(" + QUESTION + ")" + " VALUES(?)";
    }

    /**
     * @return SQL query to add new viva question.
     */
    public static String addNewVivaQuestionQuery() {
        return "INSERT INTO " + VIVA_QUESTION_TABLE + "(" + VIVA_QUESTION + ")" + " VALUES(?)";

    }

    /**
     * @return SQL query to find faculty
     */
    public static String findFacultyQuery() {
        return "SELECT * FROM " + FACULTY_TABLE + " WHERE " + FACULTY_ID +
                " = ?";
    }

    /**
     * @return SQL query to show all students record.
     */
    public static String showStudentRecordQuery() {
        return "SELECT * FROM " + STUDENT_TABLE;
    }

    /**
     * @return SQL query to show all questions from question bank.
     */
    public static String showAllQuestionFromQuestionBankQuery() {
        return "SELECT * FROM " + QUESTION_BANK_TABLE;
    }

    /**
     * @return SQL query to show all viva questions.
     */
    public static String showAllVivaQuestionQuery() {
        return "SELECT * FROM " + VIVA_QUESTION_TABLE;
    }
}
