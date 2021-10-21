package pt.iade.unimanage.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.unimanage.models.Student;
import pt.iade.unimanage.models.repositories.StudentRepository;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController {
    private final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Student> getStudents() {
        logger.info("Sending all students");
        return StudentRepository.getAllStudents();
    }

    @GetMapping(path = "{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudent(@PathVariable("number") int number) {
        return StudentRepository.getStudentByNumber(number);
    }

    @DeleteMapping(path = "{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteStudent(@PathVariable("number") int number) {
        logger.info("Deleting student with number " + number);
        if (StudentRepository.deleteStudent(number)) {
            return new Response(number + " was deleted", null);
        } else {
            return new Response(number + " not found!", null);
        }
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student addStudent(@RequestBody Student student) {
        StudentRepository.addStudent(student);
        return student;
    }
}

