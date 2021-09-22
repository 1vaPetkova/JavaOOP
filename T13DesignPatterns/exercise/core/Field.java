package T13DesignPatterns.exercise.core;

import T13DesignPatterns.exercise.model.GameObject;

import static T13DesignPatterns.exercise.core.Main.enemy;
import static T13DesignPatterns.exercise.core.Main.player;

public class Field implements GameObject {
    public char[][] field;


    public Field() {
        this.field = new char[16][16];
        for (int r = 0; r < 16; r++) {
            for (int c = 0; c < 16; c++) {
                this.field[r][c] = '-';
            }
        }

    }

    @Override
    public void update() {
    }

    @Override
    public void render() {
        for (int r = 0; r < 16; r++) {
            for (int c = 0; c < 16; c++) {
                System.out.print(this.field[r][c] + " ");
            }
            System.out.println();
        }
    }



}
