package pt.iade.unimanage.models.repositories;

import pt.iade.unimanage.models.Unit;

import java.util.ArrayList;
import java.util.List;

public class UnitRepository {
    private static final ArrayList<Unit> units = new ArrayList<>();

    public static void populate() {
        Unit u;
        u = new Unit("Matemática Discreta", 6);
        units.add(u);
        units.add(new Unit("Bases de Dados", 6));
        units.add(new Unit("POO", 6));
        units.add(new Unit("CC", 3));
        units.add(new Unit("Projeto Mobile", 3));
    }

    public static List<Unit> getUnits() {
        return units;
    }

    public static Unit getUnit(int id) {
        for (Unit unit : units)
            if (unit.getId() == id)
                return unit;
        return null;
    }

    public static boolean deleteUnit(int id) {
        return units.removeIf((u) -> u.getId() == id);
    }

    public static Unit addUnit(Unit unit) {
        units.add(unit);
        return unit;
    }
}
