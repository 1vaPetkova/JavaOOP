package T13DesignPatterns.exercise.shared;

import T13DesignPatterns.exercise.model.GameObject;
import T13DesignPatterns.exercise.model.Initializer;
import T13DesignPatterns.exercise.model.Player;
import T13DesignPatterns.exercise.shared.Factory;

public class PlayerFactory implements Factory {


    @Override
    public GameObject produce() {
        int[] parameters = Initializer.dataStorage.load(Player.class);
        return new Player(parameters[0], parameters[1]);
    }
}
