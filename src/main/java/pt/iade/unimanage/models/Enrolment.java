package pt.iade.unimanage.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Enrolment {
    @JsonIgnoreProperties({"enrolments"})
    private final Student student;
    @JsonIgnoreProperties({"enrolments"})
    private final Unit unit;
    private double grade;

    public Enrolment(Student student, Unit unit, double grade) {
        this.student = student;
        this.unit = unit;
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public Unit getUnit() {
        return unit;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

}
