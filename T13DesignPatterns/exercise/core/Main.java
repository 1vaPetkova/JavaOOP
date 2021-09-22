package T13DesignPatterns.exercise.core;

import T13DesignPatterns.exercise.command.CommandInterpreter;
import T13DesignPatterns.exercise.command.CommandListener;
import T13DesignPatterns.exercise.model.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<GameObject> gameObjects;
    public static Player player;
    public static Enemy enemy;
    public static Field field;
    public static Stone stone;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        gameObjects = Initializer.init();

        for (GameObject gameObject : gameObjects) {
            if (gameObject instanceof Player) {
                player = (Player) gameObject;
            } else if (gameObject instanceof Enemy) {
                enemy = (Enemy) gameObject;
            } else if (gameObject instanceof Field) {
                field = (Field) gameObject;
            } else if (gameObject instanceof Stone) {
                stone = (Stone) gameObject;
            }
        }
            CommandListener handler = new CommandInterpreter();

            boolean gameOver = false;
            String input = "";
            while (!gameOver) {
                ArrayList<GameObject> gameObjectsCopy = new ArrayList<>(new ArrayList<>(gameObjects));
                for (GameObject gameObject : gameObjectsCopy) {
                    gameObject.update();
                    gameObject.render();
                }
                System.out.println();
                System.out.println();
                System.out.println("=====================================================");
                System.out.println("Enter new command: ");
                input = scan.nextLine();
                try {
                    handler.handleCommand(input);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println();
                System.out.println();
                input = "";
            }

        }
    }
