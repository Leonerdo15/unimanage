package pt.iade.unimanage.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Teacher extends Person {
    private static int nextNumber = 0;
    private final int mecNumber;
    private ArrayList<Unit> units;

    public Teacher(String name, LocalDate birthDay, String email, char gender, int mecNumber) {
        super(name, birthDay, email, gender);
        this.mecNumber = mecNumber;
        units = new ArrayList<>();
        nextNumber++;
    }

    public static int getNextNumber() {
        return nextNumber;
    }

    public static void setNextNumber(int nextNumber) {
        Teacher.nextNumber = nextNumber;
    }

    public int getMecNumber() {
        return mecNumber;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void setUnits(ArrayList<Unit> units) {
        this.units = units;
    }

    @Override
    public String getReference() {
        return null;
    }
}
