package pt.iade.unimanage.controllers;

import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.unimanage.models.Person;
import pt.iade.unimanage.models.Student;
import pt.iade.unimanage.models.Teacher;
import pt.iade.unimanage.models.exceptions.NotFoundException;
import pt.iade.unimanage.models.exceptions.Response;
import pt.iade.unimanage.models.repositories.StudentRepository;
import pt.iade.unimanage.models.repositories.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/teachers")
public class TeacherController {
    Logger logger;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Teacher> getTeachers() {
        logger.info("Sending all students");
        return TeacherRepository.getTeachers();
    }

    @GetMapping(path = "{mecNumber}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Teacher getTeacher(@PathVariable("mecNumber") int mecNumber)
            throws NotFoundException {
        logger.info("Sending teacher with number " + mecNumber);
        Teacher teacher = TeacherRepository.getTeacher(mecNumber);
        if (teacher != null) return teacher;
        else throw new NotFoundException("" + mecNumber, "teacher", "number");
    }

    @DeleteMapping(path = "teacher/{mecNumber}/unit/{unitNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteUnitTeacher(@PathVariable("mecNumber") int mecNumber,
                                      @PathVariable("unitNumber") int unitNumber) {
        logger.info("Deleting student with number " + mecNumber);
        if (TeacherRepository.removeUnitTeacher(mecNumber, unitNumber)) {
            return new Response(unitNumber + " was deleted", null);
        } else {
            return new Response(unitNumber + " not found!", null);
        }
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        TeacherRepository.addTeacher(teacher);
        return teacher;
    }
}
