package T13DesignPatterns.exercise.model;

import T13DesignPatterns.exercise.core.Main;
import T13DesignPatterns.exercise.shared.Factory;
import T13DesignPatterns.exercise.shared.Movable;
import T13DesignPatterns.exercise.shared.StoneFactory;
import T13DesignPatterns.exercise.stone.Throw;


import java.util.concurrent.ThreadLocalRandom;

import static T13DesignPatterns.exercise.core.Main.gameObjects;

public class Player implements GameObject, Movable {
    private final int healthPoints;
    private final int damage;
    private Factory factory;
    private int row;
    private int prevRow;
    private int col;
    private int prevCol;

    public Player(int healthPoints, int damage) {
        this.healthPoints = healthPoints;
        this.damage = damage;
        this.factory = new StoneFactory();
        this.row = 15;
        this.prevRow = this.row;
        this.col = 7;
        this.prevCol = this.col;
    }

    @Override
    public void update() {
        int nextInt = ThreadLocalRandom.current().nextInt(1000);
        if (nextInt % 3 == 0) {
            gameObjects.add(this.factory.produce());
        } else if (nextInt % 7 == 0) {
            gameObjects.removeIf(g -> g.getClass().getSimpleName().equals("Stone"));
        }

    }

    @Override
    public void render() {
        Main.field.field[this.prevRow][this.prevCol] = '-';
        Main.field.field[this.row][this.col] = 'P';
    }

    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public int getCol() {
        return this.col;
    }

    @Override
    public void decreaseRow() {
        if (this.row > 0) {
            prevRow = this.row;
            this.row--;
        }
    }

    @Override
    public void decreaseCol() {
        if (this.col > 0) {
            prevCol = this.col;
            this.col--;
        }
    }

    @Override
    public void increaseRow() {
        if (this.row < 15) {
            prevRow = this.row;
            this.row++;
        }
    }

    @Override
    public void increaseCol() {
        if (this.col < 15) {
            prevCol = this.col;
            this.col++;
        }
    }

    public void throwStone(Throw th) {
       th.throwStone();
    }
}
