package pt.iade.unimanage.models.repositories;

import java.time.LocalDate;
import java.util.ArrayList;

import pt.iade.unimanage.models.Student;

public class StudentRepository {
    private static ArrayList<Student> students = new ArrayList<Student>();

    public static void populate() {
        Student s; // auxiliary variable
        s = new Student("John", LocalDate.parse("2000-05-24"), 'M');
        s.setEmail("john@gmail.com");
        students.add(s);
        students.add(new Student("Mary", LocalDate.parse("1999-12-23"), 'F'));
        s = new Student("James", LocalDate.parse("2001-07-02"), 'M');
        students.add(s);
    }

    public static ArrayList<Student> getAllStudents(){
        return students;
    }

    public static Student getStudentByNumber(int number){
        for(int i = 0; i <= students.size(); i++){
            if(students.get(i).getNumber() == number){
                return students.get(i);
            }
        }
        return null;
    }

    public static boolean deleteStudent(int number){
        return students.removeIf((s) -> s.getNumber() == number);
        //for(int i = 0; i <= students.size(); i++){
        //    if(students.get(i).getNumber() == number){
        //        students.remove(i);
        //        return true;
        //    }
        //}
        //return false;
    }

    public static Student addStudent(Student student){
        students.add(student);
        return student ;
    }

}