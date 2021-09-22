package T13DesignPatterns.exercise.command;

import T13DesignPatterns.exercise.core.Main;
import T13DesignPatterns.exercise.stone.Throw;

public class Fire implements Command{
    private Throw th;

    public Fire(Throw th) {
        this.th = th;
    }

    public Fire() {
    }
    @Override
    public void execute() {
        Main.player.throwStone(this.th);
    }
}
