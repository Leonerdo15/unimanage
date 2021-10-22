package pt.iade.unimanage.models;

import java.time.LocalDate;

public class Teacher extends Person {
    private static int nextNumber = 0;
    private final int mecNumber;

    public Teacher(String name, LocalDate birthDay, String email, char gender, int mecNumber) {
        super(name, birthDay, email, gender);
        this.mecNumber = mecNumber;
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

    @Override
    public String getReference() {
        return null;
    }
}
