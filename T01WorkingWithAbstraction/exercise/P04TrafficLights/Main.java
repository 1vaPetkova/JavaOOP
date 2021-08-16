package T01WorkingWithAbstraction.exercise.P04TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] colours = scan.nextLine().split("\\s+");

        int timesToChange = Integer.parseInt(scan.nextLine());
        List<TrafficLight> lights = new ArrayList<>();
        Arrays.stream(colours).forEach(c->lights.add(new TrafficLight(Colour.valueOf(c))));
        while (timesToChange-- > 0) {
            lights.forEach(l-> {
                l.updateTrafficLight();
                System.out.print(l.getColour() + " ");
            });
            System.out.println();
        }
    }
}
