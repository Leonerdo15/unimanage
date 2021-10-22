package pt.iade.unimanage.controllers;

import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.iade.unimanage.models.Person;
import pt.iade.unimanage.models.repositories.StudentRepository;
import pt.iade.unimanage.models.repositories.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/persons")
public class PersonController {
    Logger logger;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getPersons() {
        logger.info("Sending all persons");
        ArrayList<Person> persons = new ArrayList<>();
        persons.addAll(StudentRepository.getAllStudents());
        persons.addAll(TeacherRepository.getTeachers());
        return persons;
    }

}
