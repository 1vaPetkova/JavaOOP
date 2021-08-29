package T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.core.commands;

import T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.interfaces.Executable;
import T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.interfaces.Inject;
import T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.interfaces.Repository;


public class Retire implements Executable {
    @Inject
    private String[] data;
    @Inject
    private Repository repository;

    public Retire() {

    }

    public Retire(String[] data, Repository repository) {
        this.data = data;
        this.repository = repository;
    }

    @Override
    public String execute() {
        String unitType = this.data[1];
        this.repository.removeUnit(unitType);
        return unitType + " retired!";
    }
}
