package T03Inheritance.archive.P05OnlineRadioDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist {
    private List<Song> playlist;

    public Playlist() {
        this.playlist = new ArrayList<>();
    }

    public void addSong(Song song) {
        this.playlist.add(song);
    }

    public List<Song> getPlaylist() {
        return Collections.unmodifiableList(this.playlist);
    }

    public String getTotalLengthOfSongs() {
        int sumLength = playlist.stream().mapToInt(Song::getLengthInSeconds).sum();
        int hours = sumLength / 3600 % 24;
        int minutes = sumLength % 3600 / 60;
        int seconds = sumLength % 3600 % 60;
        return String.format("%dh %dm %ds", hours, minutes, seconds);
    }

    @Override
    public String toString() {
        return String.format("Songs added: %d\nT03Inheritance.archive.P05OnlineRadioDatabase.Playlist length: %s", this.playlist.size(), this.getTotalLengthOfSongs());
    }
}
