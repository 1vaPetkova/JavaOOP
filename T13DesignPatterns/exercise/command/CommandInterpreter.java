package T13DesignPatterns.exercise.command;

import T13DesignPatterns.exercise.builder.MapBuilder;
import T13DesignPatterns.exercise.builder.MyMapBuilder;
import T13DesignPatterns.exercise.stone.ThrowFast;
import T13DesignPatterns.exercise.stone.ThrowSlow;

import java.util.Map;

public class CommandInterpreter implements CommandListener {
    private Map<String, Command> commands;

    public CommandInterpreter() {
        MapBuilder<String, Command> builder = new MyMapBuilder<>();
        this.commands = builder
                .entry("w", new MoveUp())
                .entry("s", new MoveDown())
                .entry("a", new MoveLeft())
                .entry("d", new MoveRight())
                .entry("as", new MoveLeftDown())
                .entry("fs", new Fire(new ThrowFast()))
                .entry("f",new Fire(new ThrowSlow()))
                .build();
    }

    @Override
    public void handleCommand(String type) {
        Command command = commands.get(type);
        if (command == null) {
            throw new IllegalArgumentException("Invalid command type!");
        }
        command.execute();
    }
}
