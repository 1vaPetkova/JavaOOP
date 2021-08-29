package T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.core.commands;

import T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.interfaces.Executable;
import T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.interfaces.Repository;
import T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {
    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    public String[] getData() {
        return data;
    }

    public Repository getRepository() {
        return repository;
    }

    public UnitFactory getUnitFactory() {
        return unitFactory;
    }
}
