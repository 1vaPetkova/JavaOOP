package T13DesignPatterns.exercise.stone;

import T13DesignPatterns.exercise.shared.StoneFactory;

import static T13DesignPatterns.exercise.core.Main.gameObjects;

public class ThrowFast implements Throw{
    @Override
    public void throwStone() {
        gameObjects.add(new StoneFactory().produceFastStone());
    }
}
