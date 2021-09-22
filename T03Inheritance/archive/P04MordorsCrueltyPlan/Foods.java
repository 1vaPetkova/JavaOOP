package T03Inheritance.archive.P04MordorsCrueltyPlan;

import java.util.Arrays;

public enum Foods {
    CRAM(2),
    LEMBAS(3),
    APPLE(1),
    MELON(1),
    HONEYCAKE(5),
    MUSHROOMS(-10);

    private int points;

    Foods(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public static boolean contains(String food) {
        return Arrays.stream(Foods.values()).anyMatch(e -> e.name().equals(food.toUpperCase()));
    }
}
