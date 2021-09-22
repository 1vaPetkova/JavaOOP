package T03Inheritance.archive.P05OnlineRadioDatabase;

public class Song {
    private String artistName;
    private String songName;
    private String length;

    public Song(String artistName, String songName, String length) throws InvalidSongException {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setLength(length);
    }

    private void setArtistName(String artistName) throws InvalidArtistNameException {
        if (artistName.length() < 3 || artistName.length() > 20) {
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = artistName;
    }

    private void setSongName(String songName) throws InvalidSongNameException {
        if (songName.length() < 3 || songName.length() > 30) {
            throw new InvalidSongNameException("T03Inheritance.archive.P05OnlineRadioDatabase.Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    private void setLength(String length) throws InvalidSongLengthException {
        String minutes = length.split(":")[0];
        if (!minutes.matches("\\d+")) {
            throw new InvalidSongMinutesException("Invalid song length.");
        }
        int minutesInteger = Integer.parseInt(length.split(":")[0]);
        if (minutesInteger < 0 || minutesInteger > 14) {
            throw new InvalidSongMinutesException("T03Inheritance.archive.P05OnlineRadioDatabase.Song minutes should be between 0 and 14.");
        }
        String seconds = length.split(":")[1];
        if (!seconds.matches("\\d+")) {
            throw new InvalidSongSecondsException("Invalid song length.");
        }
        int secondsInteger = Integer.parseInt(length.split(":")[1]);
        if (secondsInteger < 0 || secondsInteger > 59) {
            throw new InvalidSongSecondsException("T03Inheritance.archive.P05OnlineRadioDatabase.Song seconds should be between 0 and 59.");
        }
        this.length = length;
    }

    public String getLength() {
        return this.length;
    }

    public int getLengthInSeconds() {
        int minutes = Integer.parseInt(getLength().split(":")[0]);
        int seconds = Integer.parseInt(getLength().split(":")[1]);
        return minutes * 60 + seconds;
    }

}
