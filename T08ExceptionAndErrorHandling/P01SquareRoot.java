package T08ExceptionAndErrorHandling;

import java.util.Scanner;

public class P01SquareRoot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            double sqrt = sqrt(scan);
            System.out.println(sqrt);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Good bye");
        }
    }

    public static double sqrt(Scanner scan) {
        String s = scan.nextLine();

        for (char symbol : s.toCharArray()) {
            if (!Character.isDigit(symbol)) {
                throw new NumberFormatException("Invalid number");
            }
        }
        int number = Integer.parseInt(s);
        return Math.sqrt(number);
    }
}
