package pt.iade.unimanage.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student {
    private static int nextNumber = 0;
    private String name;
    private LocalDate birthDate;
    private String email;
    private char gender;
    private int number;
    private final ArrayList<Enrolment> enrolments;


    public Student(String name, LocalDate birthDate,
                   char gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.number = nextNumber;
        nextNumber++;
        email = "";
        enrolments = new ArrayList<>();
    }

    //public static int getNextNumber() { return nextNumber; }
    //public String getName() { return name; }
    //public void setName(String name) { this.name = name; }
    //public LocalDate getBirthDate() {
    //    return birthDate;
    //}
    public static void setNextNumber(int nextNumber) {
        Student.nextNumber = nextNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public ArrayList<Enrolment> getEnrolments() {
        return enrolments;
    }

    public void enroll(Enrolment enrolment) {
        enrolments.add(enrolment);
        enrolment.getUnit().getEnrolments().add(enrolment);
    }

    public Enrolment getEnrolmentByUnitId(int unitId) {
        return enrolments.get(unitId);
    }
}

