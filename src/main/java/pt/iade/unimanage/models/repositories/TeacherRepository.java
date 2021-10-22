package pt.iade.unimanage.models.repositories;

import pt.iade.unimanage.models.Teacher;
import pt.iade.unimanage.models.Unit;

import java.util.ArrayList;

public class TeacherRepository {
    private static final ArrayList<Teacher> teachers = new ArrayList<>();

    public static ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public static Teacher getTeacher(int mecNumber) {
        return teachers.get(mecNumber);
    }

    public static ArrayList<Unit> getUnits(int mecNumber){
        return teachers.get(mecNumber).getUnits();
    }

    public static boolean addUnitTeacher(int mecNumber, Unit unit){
        return teachers.get(mecNumber).getUnits().add(unit);
    }

    public static boolean removeUnitTeacher(int mecNumber, Unit unit){
        return teachers.get(mecNumber).getUnits().remove(unit);
    }
}
