package T07ReflectionAndAnnotation.exercise.P04_05BarracksWars.barracksWars.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
