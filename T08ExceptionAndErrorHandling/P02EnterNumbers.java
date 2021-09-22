package T08ExceptionAndErrorHandling;

import java.util.Scanner;
import java.util.stream.IntStream;

public class P02EnterNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            String start = scan.nextLine();
            String end = scan.nextLine();
            try {
                printNumbers(start, end);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void printNumbers(String start, String end) {
        int s;
        int e;
        try {
            s = Integer.parseInt(start);
            e = Integer.parseInt(end);

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Invalid Workshops.BoatRacingSimulator.input, please enter new range.", ex);
        }
        if (!(1 < s && s < e && e < 100)) {
            throw new IllegalArgumentException("Invalid Workshops.BoatRacingSimulator.input, please enter new range.");
        }
        IntStream.rangeClosed(s, e).forEach(System.out::println);
    }

}
