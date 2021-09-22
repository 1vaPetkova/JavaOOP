package T13DesignPatterns.exercise.shared;

import T13DesignPatterns.exercise.core.Field;
import T13DesignPatterns.exercise.model.GameObject;


import java.util.ArrayList;
import java.util.List;

public class InitialGameObjectsFactory implements ProduceMultiple {
    private List<Factory> objectFactories;

    public InitialGameObjectsFactory() {
        this.objectFactories = new ArrayList<>();
    }

    @Override
    public List<GameObject> produce() {

        List<GameObject> gameObjects = new ArrayList<>();
        for (Factory objectFactory : objectFactories) {
            gameObjects.add(objectFactory.produce());
        }
        gameObjects.add(new Field());
        return gameObjects;
    }

    @Override
    public void setFactories(List<Factory> objectFactories) {
        this.objectFactories = objectFactories;
    }
}
