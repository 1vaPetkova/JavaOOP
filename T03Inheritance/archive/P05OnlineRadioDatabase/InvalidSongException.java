package T03Inheritance.archive.P05OnlineRadioDatabase;

public class InvalidSongException extends Throwable {
    private String message;

    public InvalidSongException(String message) {
        this.message = message;

    }

    @Override
    public String getMessage() {
        return message;
    }
}
