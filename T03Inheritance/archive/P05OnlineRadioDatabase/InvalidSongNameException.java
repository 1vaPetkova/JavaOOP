package T03Inheritance.archive.P05OnlineRadioDatabase;

public class InvalidSongNameException extends InvalidSongException{
    public InvalidSongNameException(String message) {
        super(message);
    }
}
