package T04InterfacesAndAbstraction.archive.P10MooD3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] info = scan.nextLine().split("\\s+\\|\\s+");

        GameObject gameObject = createGameObject(info);
        System.out.println(gameObject);
    }

    private static GameObject createGameObject(String[] info) {
        String username = info[0];
        String characterType = info[1];
        double specialPoints = Double.parseDouble(info[2]);
        int level = Integer.parseInt(info[3]);
        switch (characterType) {
            case "T04InterfacesAndAbstraction.archive.P10MooD3.Demon":
                return new Demon(username, level, specialPoints);
            case "T04InterfacesAndAbstraction.archive.P10MooD3.Archangel":
                return new Archangel(username, level, specialPoints);
        }
        return null;
    }
}
