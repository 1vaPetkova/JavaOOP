package T01WorkingWithAbstraction.lab.P02PointInRectangle;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean greaterOrEqual(Point A) {
        return this.x >= A.x && this.y >= A.y;
    }

    public boolean lessOrEqual(Point B) {
        return this.x <= B.x && this.y <= B.y;
    }

}
