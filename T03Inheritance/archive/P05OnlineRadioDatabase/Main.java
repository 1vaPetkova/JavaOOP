package T03Inheritance.archive.P05OnlineRadioDatabase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        Playlist dataBase = new Playlist();
        while (lines-- > 0) {
            String[] info = scan.nextLine().split(";");
            String artist = info[0];
            String songName = info[1];
            String songLength = info[2];

            try {
                Song song = new Song(artist, songName, songLength);
                dataBase.addSong(song);
                System.out.println("T03Inheritance.archive.P05OnlineRadioDatabase.Song added.");
            } catch (InvalidSongException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(dataBase);
    }
}
