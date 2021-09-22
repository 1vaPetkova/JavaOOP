package T08ExceptionAndErrorHandling.P05CustomException;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) throws InvalidPersonNameException {
        setName(name);
        setEmail(email);
    }

    public void setName(String name) throws InvalidPersonNameException {
        for (char ch : name.toCharArray()) {
            if (!Character.isAlphabetic(ch)){
                throw new InvalidPersonNameException();
            }
        }
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
