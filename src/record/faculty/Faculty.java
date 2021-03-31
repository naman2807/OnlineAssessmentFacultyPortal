package record.faculty;

import portalcredentialscreator.PortalCredentialCreator;
import record.password.Password;
import record.username.UserName;

import java.util.Objects;
import java.util.Random;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: record.faculty
 * Project Name: OnlineAssessmentFacultyPortal
 * Date: 28-03-2021
 */

public class Faculty implements Comparable<Faculty> {
    private String name;
    private int id;
    private UserName userName;
    private Password password;

    public Faculty(String name) {
        this.name = name;
        this.id = generateId();
        this.userName = new UserName(PortalCredentialCreator.createUserNameForFaculty(this));
        this.password = new Password(PortalCredentialCreator.createPassword());
    }

    public UserName getUserName() {
        return userName;
    }

    public void setUserName(UserName userName) {
        this.userName = userName;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Faculty o) {
        return Integer.compare(id, o.getId());
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return id == faculty.id && Objects.equals(name, faculty.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    /**
     * @return id of faculty
     */
    public int generateId() {
        return new Random().nextInt(100);
    }
}
