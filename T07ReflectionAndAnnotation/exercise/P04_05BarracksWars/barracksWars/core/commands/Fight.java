package T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.core.commands;


import T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.interfaces.Executable;

public class Fight implements Executable {
    public Fight() {
    }

    @Override
    public String execute() {
        return "fight";
    }
}
