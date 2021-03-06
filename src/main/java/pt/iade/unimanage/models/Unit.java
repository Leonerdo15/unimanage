package pt.iade.unimanage.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

public class Unit {
    private static int nextId = 1;
    private final int id;
    private final String name;
    private final int credits;
    @JsonIgnoreProperties({"units"})
    private final ArrayList<Enrolment> enrolments;

    public Unit(String name, int credits) {
        this.id = nextId;
        this.name = name;
        this.credits = credits;
        enrolments = new ArrayList<>();
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public ArrayList<Enrolment> getEnrolments() {
        return enrolments;
    }
}
