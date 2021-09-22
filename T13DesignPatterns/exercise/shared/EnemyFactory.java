package T13DesignPatterns.exercise.shared;


import T13DesignPatterns.exercise.model.Enemy;
import T13DesignPatterns.exercise.model.GameObject;
import T13DesignPatterns.exercise.model.Initializer;

public class EnemyFactory implements Factory {
    @Override
    public GameObject produce() {
        int[] parameters = Initializer.dataStorage.load(Enemy.class);
        return new Enemy(parameters[0], parameters[1]);
    }

}
