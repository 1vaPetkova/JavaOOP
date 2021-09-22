package T13DesignPatterns.exercise.model;

import T13DesignPatterns.exercise.core.Main;
import T13DesignPatterns.exercise.shared.Movable;

import static T13DesignPatterns.exercise.core.Main.player;

public class Stone implements GameObject, Movable {
    private int row;
    private int col;
    private int prevRow;
    private int speed;


    public Stone() {
        this.row = player.getRow();
        this.prevRow = this.row;
        this.col = player.getCol();
        this.speed = 1;
    }

    @Override
    public void update() {
        if (this.row >= 0) {
            this.prevRow = this.row;
            this.row-=speed;
        }

    }

    @Override
    public void render() {
        if (this.row > -1) {
            Main.field.field[this.prevRow][this.col] = '-';
            Main.field.field[this.row][this.col] = 'S';
        } else {
            Main.field.field[this.prevRow][this.col] = '-';
        }
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

    }

    @Override
    public void decreaseCol() {

    }

    @Override
    public void increaseRow() {

    }

    @Override
    public void increaseCol() {

    }

    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }
}
