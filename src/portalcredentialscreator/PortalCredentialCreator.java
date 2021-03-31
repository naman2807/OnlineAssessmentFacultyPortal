package portalcredentialscreator;

import record.faculty.Faculty;
import record.student.Student;

import java.util.Random;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: portalcredentialscreator
 * Project Name: OnlineAssessmentFacultyPortal
 * Date: 28-03-2021
 */

public class PortalCredentialCreator {

    /**
     * This method is used to create password.
     *
     * @return password
     */
    public static String createPassword() {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < getPasswordLength(); i++) {
            password.append(getCharacter());
        }
        return password.toString();
    }

    /**
     * This method return the maximum length of password.
     *
     * @return password length
     */
    private static int getPasswordLength() {
        return (new Random().nextInt(21) + 8) % 20;
    }

    /**
     * This method converts the character of password to string.
     *
     * @return character of password in string format.
     */
    private static String getCharacter() {
        return String.valueOf(getRandomCharacter());
    }

    /**
     * This method generates character of password.
     *
     * @return character of password
     */
    private static char getRandomCharacter() {
        return (char) new Random().nextInt(Character.MAX_VALUE);
    }

    /**
     * This method generates username of student.
     *
     * @param student
     * @return student username
     */
    public static String createUserNameForStudent(Student student) {
        return String.format("%d_%d_%s", student.getClassRollNumber(), student.getCurrentYear(),
                student.getName());
    }

    /**
     * This method generates username of faculty.
     *
     * @param faculty
     * @return faculty username
     */
    public static String createUserNameForFaculty(Faculty faculty) {
        return String.format("%d_%s", faculty.getId(), faculty.getName());
    }
}
