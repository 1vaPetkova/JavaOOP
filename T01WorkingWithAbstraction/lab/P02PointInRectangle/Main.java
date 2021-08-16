package T01WorkingWithAbstraction.lab.P02PointInRectangle;

import input.Reader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] rectanglePoints = Reader.readIntArray("\\s+");
        Point A = new Point(rectanglePoints[0], rectanglePoints[1]);
        Point B = new Point(rectanglePoints[2], rectanglePoints[3]);

        Rectangle rect = new Rectangle(A, B);

        int count = Reader.readIntArray("\\s+")[0];
        while (count-- > 0) {
            int[] singlePoint = Reader.readIntArray("\\s+");
            Point p = new Point(singlePoint[0], singlePoint[1]);

            boolean isWithin = rect.contains(p);
            System.out.println(isWithin);
        }
    }
}
