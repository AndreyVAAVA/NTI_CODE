import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class CourseGroup {
    @SerializedName("contact")
    private Contact contact;
    @SerializedName("student")
    private Student student;
    @SerializedName("coursePassing")
    private CoursePassing coursePassing;
    @SerializedName("lessonsPassing")
    private ArrayList<LessonsPassing> lessonsPassing;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public CoursePassing getCoursePassing() {
        return coursePassing;
    }

    public void setCoursePassing(CoursePassing coursePassing) {
        this.coursePassing = coursePassing;
    }

    public ArrayList<LessonsPassing> getLessonsPassing() {
        return lessonsPassing;
    }

    public void setLessonsPassing(ArrayList<LessonsPassing> lessonsPassing) {
        this.lessonsPassing = lessonsPassing;
    }
}

class Contact {
    private long id;
    private String firstName;
    private String lastName;
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class Student {
    private long id;
    private String status;
    @SerializedName("registeredAt")
    private RegisteredAt registeredAt;
    @SerializedName("lastActivityAt")
    private LastActivityAt lastActivityAt;
    @SerializedName("data")
    private Data data;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RegisteredAt getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(RegisteredAt registeredAt) {
        this.registeredAt = registeredAt;
    }

    public LastActivityAt getLastActivityAt() {
        return lastActivityAt;
    }

    public void setLastActivityAt(LastActivityAt lastActivityAt) {
        this.lastActivityAt = lastActivityAt;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}

class RegisteredAt {
    private String date;
    private int timezone_type;
    private String timezone;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTimezone_type() {
        return timezone_type;
    }

    public void setTimezone_type(int timezone_type) {
        this.timezone_type = timezone_type;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}

class LastActivityAt extends RegisteredAt{}

class Data extends RegisteredAt {}

class CoursePassing {
    private String status;
    private long passingProgress;
    private long averageScore;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getPassingProgress() {
        return passingProgress;
    }

    public void setPassingProgress(long passingProgress) {
        this.passingProgress = passingProgress;
    }

    public long getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(long averageScore) {
        this.averageScore = averageScore;
    }
}

class LessonsPassing {
    private long id;
    private String name;
    private String type;
    private Data date;
    private long score;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Data getDate() {
        return date;
    }

    public void setDate(Data date) {
        this.date = date;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
}