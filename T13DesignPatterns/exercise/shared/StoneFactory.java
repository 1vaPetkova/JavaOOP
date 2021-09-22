package T13DesignPatterns.exercise.shared;

import T13DesignPatterns.exercise.model.GameObject;
import T13DesignPatterns.exercise.model.Stone;


public class StoneFactory implements Factory {
    @Override
    public GameObject produce() {
        return new Stone();
    }

    public GameObject produceFastStone(){
        Stone stone = new Stone();
        stone.setSpeed(4);
        return stone;
    }
}
