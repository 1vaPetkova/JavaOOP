package T03Inheritance.archive.P05OnlineRadioDatabase;

public class InvalidSongMinutesException extends InvalidSongLengthException{
    public InvalidSongMinutesException(String message) {
        super(message);
    }
}
