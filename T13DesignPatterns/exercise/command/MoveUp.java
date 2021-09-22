package T13DesignPatterns.exercise.command;

import static T13DesignPatterns.exercise.core.Main.player;

public class MoveUp implements Command {
    @Override
    public void execute() {
player.decreaseRow();
    }
}
