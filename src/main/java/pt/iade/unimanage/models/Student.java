package pt.iade.unimanage.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student extends Person {
    private static int nextNumber = 1;
    private final ArrayList<Enrolment> enrolments;
    private int number = 0;


    public Student(String name, LocalDate birthDay, char gender) {
        super(name, birthDay, gender);
        number++;
        nextNumber++;
        enrolments = new ArrayList<>();
    }

    public static void setNextNumber(int nextNumber) {
        Student.nextNumber = nextNumber;
    }

    public ArrayList<Enrolment> getEnrolments() {
        return enrolments;
    }

    public void enroll(Enrolment enrolment) {
        enrolments.add(enrolment);
        enrolment.getUnit().getEnrolments().add(enrolment);
    }

    public Enrolment getEnrolmentByUnitId(int unitId) {
        Enrolment enrolment = null;
        for (int i = 0; i < enrolments.size(); i++) {
            if (enrolments.get(i).getUnit().getId() == unitId){
                enrolment = enrolments.get(i);
                break;
            }
        }
        return enrolment;
    }

    @Override
    public String getReference() {
        return null;
    }

    public int getNumber() {
        return number;
    }
}

