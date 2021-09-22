package T13DesignPatterns.exercise.model;

import T13DesignPatterns.exercise.core.Main;
import T13DesignPatterns.exercise.shared.Movable;

public class Enemy implements GameObject, Movable {

    private final int healthPoints;
    private final int damage;
    private int row;
    private int prevRow;
    private int col;
    private int prevCol;

    public Enemy(int healthPoints, int damage) {
        this.healthPoints = healthPoints;
        this.damage = damage;
        this.row = 0;
        this.col = 7;
        this.prevRow = 0;
        this.prevCol = 7;
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        Main.field.field[this.prevRow][this.prevCol] = '-';
        Main.field.field[this.row][this.col] = 'Е';
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
            prevCol = this.row;
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
}
