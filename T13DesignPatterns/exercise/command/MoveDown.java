package T13DesignPatterns.exercise.command;

import static T13DesignPatterns.exercise.core.Main.player;

public class MoveDown implements Command {
    @Override
    public void execute() {
        player.increaseRow();
    }
}
