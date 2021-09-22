package T13DesignPatterns.exercise.shared;

import T13DesignPatterns.exercise.model.GameObject;


import java.util.List;

public interface ProduceMultiple {
    List<GameObject> produce();

    void setFactories(List<Factory> objectFactory);
}
