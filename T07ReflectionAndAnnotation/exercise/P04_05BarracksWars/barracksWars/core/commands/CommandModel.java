package T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.core.commands;

import T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.interfaces.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandModel implements CommandInterpreter {
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandModel(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        Executable executable;
        commandName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);
        try {
            Class clazz = Class.forName("T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.Workshops.BoatRacingSimulator.core.commands." + commandName);
            Constructor constr = clazz.getDeclaredConstructor();
            executable = (Executable) constr.newInstance();
            injectFields(executable, data);
            constr.setAccessible(true);
            return executable;
        } catch (ClassNotFoundException | NoSuchMethodException
                | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void injectFields(Executable executable, String[] data) throws IllegalAccessException {
        Field[] executableFields = executable.getClass().getDeclaredFields();
        Field[] localFields = this.getClass().getDeclaredFields();

        for (Field field : executableFields) {
            Inject annotation = field.getAnnotation(Inject.class);
            field.setAccessible(true);
            if (annotation != null) {
                if (field.getType() == String[].class) {
                    field.set(executable, data);
                } else {
                    for (Field localField : localFields) {
                        if (localField.getType() == field.getType()) {
                            field.set(executable, localField.get(this));
                        }
                    }
                }
            }
        }
    }
}

