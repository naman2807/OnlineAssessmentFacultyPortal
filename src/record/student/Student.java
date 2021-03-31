package record.student;

import portalcredentialscreator.PortalCredentialCreator;
import record.password.Password;
import record.username.UserName;
import subjectandsubjectcode.Subject;
import subjectandsubjectcode.SubjectCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: record.student
 * Project Name: OnlineAssessmentFacultyPortal
 * Date: 28-03-2021
 */

public class Student implements Comparable<Student> {
    private String name;
    private int classRollNumber;
    private long universityRollNumber;
    private char section;
    private int currentYear;
    private String course;
    private UserName userName;
    private Password password;
    private Map<SubjectCode, Subject> subjectList;

    public Student() {
    }

    public Student(String name, byte classRollNumber, long universityRollNumber,
                   char section, byte currentYear, String course) {
        this.name = name;
        this.classRollNumber = classRollNumber;
        this.universityRollNumber = universityRollNumber;
        this.section = section;
        this.currentYear = currentYear;
        this.course = course;
        this.subjectList = new HashMap<SubjectCode, Subject>();
        this.userName = new UserName(PortalCredentialCreator.createUserNameForStudent(this));
        this.password = new Password(PortalCredentialCreator.createPassword());
    }

    public Student(String name, int classRollNumber, long universityRollNumber, char section, int currentYear,
                   String course, UserName userName, Password password) {
        this.name = name;
        this.classRollNumber = classRollNumber;
        this.universityRollNumber = universityRollNumber;
        this.section = section;
        this.currentYear = currentYear;
        this.course = course;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("%-30s%-30s%-30s%-20s%-20s%-20s%-20s%-20s", getName(), getClassRollNumber(), getUniversityRollNumber(),
                getSection(), getCurrentYear(), getCourse(), getUserName(), getPassword());
    }

    public String getName() {
        return name;
    }

    public UserName getUserName() {
        return userName;
    }

    public Password getPassword() {
        return password;
    }

    public int getClassRollNumber() {
        return classRollNumber;
    }

    public void setClassRollNumber(byte classRollNumber) {
        this.classRollNumber = classRollNumber;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public long getUniversityRollNumber() {
        return universityRollNumber;
    }

    public char getSection() {
        return section;
    }

    public void setSection(char section) {
        this.section = section;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public Map<SubjectCode, Subject> getSubjectList() {
        return subjectList;
    }

    public void addNewSubject(SubjectCode subjectCode, Subject subject) {
        subjectList.put(subjectCode, subject);
    }

    @Override
    public int compareTo(Student o) {
        return Long.compare(this.getUniversityRollNumber(), o.getUniversityRollNumber());
    }
}
