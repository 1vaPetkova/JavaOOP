package T08ExceptionAndErrorHandling.P05CustomException;

public class InvalidPersonNameException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Name cannot contain any special character or numeric value.";
    }
}
