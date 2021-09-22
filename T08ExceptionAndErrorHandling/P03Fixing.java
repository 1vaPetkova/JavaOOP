package T08ExceptionAndErrorHandling;

import java.util.Scanner;

public class P03Fixing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] weekdays = new String[5];
        weekdays[0] = "Monday";
        weekdays[1] = "Tuesday";
        weekdays[2] = "Wednesday";
        weekdays[3] = "Thursday";
        weekdays[4] = "Friday";

        try {
            for (int i = 0; i < weekdays.length; i++) {
                System.out.println(weekdays[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of Bounds");
        }
        scan.nextLine();
    }
}

