package T01WorkingWithAbstraction.lab;

import java.util.Scanner;
import java.util.function.Predicate;

public class P01RhombusOfStars {
    public static void main(String[] args) {
        int size = readInput();
        String rhombusOfStars = buildRhombusOfStars(size);
        printOutput(rhombusOfStars);
    }


    private static String buildRhombusOfStars(int size) {
        return getMultipleRows(1, size, +1, size) + getMultipleRows(size - 1, 1, -1, size);
    }

    private static String getMultipleRows(int start, int end, int step, int size) {
        StringBuilder sb = new StringBuilder();
        Predicate<Integer> loopCondition = iter -> {
            if (step > 0) {
                return iter <= end;
            }
            return iter >= end;
        };
        for (int row = start; loopCondition.test(row); row += step) {
            sb.append(printLine(size - row, row)).append(System.lineSeparator());
        }
        return sb.toString();
    }

    private static String printLine(int spaces, int stars) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < spaces; i++) {
            sb.append(" ");
        }
        for (int j = 0; j < stars; j++) {
            sb.append("* ");
        }
        return sb.toString();
    }

    private static int readInput() {
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }

    private static void printOutput(String rhombusOfStars) {
        System.out.println(rhombusOfStars);
    }
}
