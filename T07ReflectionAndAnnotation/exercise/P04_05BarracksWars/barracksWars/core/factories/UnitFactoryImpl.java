package T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.core.factories;

import T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.interfaces.Unit;
import T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.Workshops.BoatRacingSimulator.models.units.";

    @Override
    public Unit createUnit(String unitType) {

        try {
            Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<Unit> constructor = unitClass.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException |
                InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;

        // TODO: implement for problem 3
//        switch (unitType) {
//            case "Archer":
//                return new Archer();
//            case "Pikeman":
//                return new Pikeman();
//            case "Swordsman":
//                return new Swordsman();
//            case "Horseman":
//                return new Horseman();
//            case "Gunner":
//                return new Gunner();
//        }
    }
}
