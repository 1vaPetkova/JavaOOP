package T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars;

import T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.core.commands.CommandModel;
import T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.interfaces.CommandInterpreter;
import T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.interfaces.Repository;
import T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.interfaces.Runnable;
import T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.interfaces.UnitFactory;
import T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.core.Engine;
import T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.core.factories.UnitFactoryImpl;
import T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        CommandInterpreter commandInterpreter = new CommandModel(repository,unitFactory);
        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
