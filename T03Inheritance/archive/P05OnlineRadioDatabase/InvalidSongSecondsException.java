package T03Inheritance.archive.P05OnlineRadioDatabase;

public class InvalidSongSecondsException extends InvalidSongLengthException{
    public InvalidSongSecondsException(String message) {
        super(message);
    }
}
