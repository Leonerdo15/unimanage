package pt.iade.unimanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pt.iade.unimanage.models.repositories.StudentRepository;
import pt.iade.unimanage.models.repositories.UnitRepository;

@SpringBootApplication
public class UnimanageApplication {

	public static void main(String[] args) {
		UnitRepository.populate();
		StudentRepository.populate();
		SpringApplication.run(UnimanageApplication.class, args);
	}

}
