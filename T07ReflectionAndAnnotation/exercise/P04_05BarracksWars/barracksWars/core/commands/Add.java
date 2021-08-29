package T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.core.commands;

import T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.interfaces.*;

public class Add implements Executable {
    @Inject
    private String[] data;
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public Add() {
    }

    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public String execute() {
        String unitType = this.data[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
