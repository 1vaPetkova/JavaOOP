package T02Encapsulation.exercise.P05FootballTeamGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        if (this.players.stream().noneMatch(p -> p.getName().equals(name))) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", name, this.name));
        }
        players.removeIf(p -> p.getName().equals(name));
    }

    public double getRating() {
        return players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0);
    }

    @Override
    public String toString() {
        return this.name + " - " + String.format("%.0f", getRating());
    }
}
