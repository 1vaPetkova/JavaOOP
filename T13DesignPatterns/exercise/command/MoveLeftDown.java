package T13DesignPatterns.exercise.command;

public class MoveLeftDown implements Command {
    private MoveLeft moveLeft = new MoveLeft();
    private MoveDown moveDown = new MoveDown();

    @Override
    public void execute() {
        moveLeft.execute();
        moveDown.execute();
    }
}
