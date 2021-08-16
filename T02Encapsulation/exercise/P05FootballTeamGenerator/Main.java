package T02Encapsulation.exercise.P05FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        List<Team> teams = new ArrayList<>();
        while (!(input = scan.nextLine()).equals("END")) {
            String[] tokens = input.split(";");
            String teamName = tokens[1];

            switch (tokens[0]) {
                case "Team":
                    try {
                        teams.add(new Team(teamName));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Add":
                    String playerName = tokens[2];
                    int endurance = Integer.parseInt(tokens[3]);
                    int sprint = Integer.parseInt(tokens[4]);
                    int dribble = Integer.parseInt(tokens[5]);
                    int passing = Integer.parseInt(tokens[6]);
                    int shooting = Integer.parseInt(tokens[7]);
                    if (teams.stream().noneMatch(t -> t.getName().equals(teamName))) {
                        System.out.printf("Team %s does not exist.\n", teamName);
                    } else {
                        try {
                            teams.stream().filter(t -> t.getName().equals(teamName)).findFirst().
                                    ifPresent(t ->
                                            t.addPlayer(new Player(playerName, endurance, sprint, dribble, passing, shooting)));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Remove":
                    playerName = tokens[2];
                    try {
                        teams.stream().filter(t -> t.getName().equals(teamName)).findFirst().
                                ifPresent(t -> t.removePlayer(playerName));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Rating":
                    if (teams.stream().noneMatch(t -> t.getName().equals(teamName))) {
                        System.out.printf("Team %s does not exist.\n", teamName);
                    } else {
                        Team outputTeam = teams.stream().filter(t -> t.getName().equals(teamName)).findFirst().get();
                        System.out.println(outputTeam);
                        break;
                    }
            }
        }
    }
}