package pt.iade.unimanage.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.unimanage.models.Unit;
import pt.iade.unimanage.models.exceptions.NotFoundException;
import pt.iade.unimanage.models.exceptions.Response;
import pt.iade.unimanage.models.repositories.UnitRepository;

import java.util.List;


@RestController
@RequestMapping(path = "/api/units")
public class UnitController {
    private final Logger logger = LoggerFactory.getLogger(UnitController.class);

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Unit> getUnits() {
        logger.info("Getting " + UnitRepository.getUnits().size() + " units");
        return UnitRepository.getUnits();
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Unit getUnit(@PathVariable("id") int id) throws NotFoundException {
        logger.info("Getting unit # " + id);
        Unit unit = UnitRepository.getUnit(id);
        if (unit != null) return unit;
        else throw new NotFoundException("" + id, "Unit", "id");
    }

    @DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteUnit(@PathVariable("id") int id) {
        logger.info("Deleting unit #" + id);
        if (UnitRepository.deleteUnit(id)) {
            return new Response(id + " was delete.", null);
        } else {
            return new Response(id + " not found.", null);
        }
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Unit addUnit(@RequestBody Unit unit) {
        logger.info("Added unit " + unit.getName());
        UnitRepository.addUnit(unit);
        return unit;
    }
}