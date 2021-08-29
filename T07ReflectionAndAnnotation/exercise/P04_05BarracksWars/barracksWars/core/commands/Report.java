package T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.core.commands;

import T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.interfaces.Executable;
import T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.interfaces.Inject;
import T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.interfaces.Repository;


public class Report implements Executable {
    @Inject
    private Repository repository;

    public Report() {
    }

    public Report(Repository repository) {
        this.repository = repository;
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
