package T08ExceptionAndErrorHandling.P05CustomException;


public class Main {
    public static void main(String[] args) {
        try {
            Student student = createStudent("Gos4ho", "gosho@gosho.com");
        } catch (InvalidPersonNameException e) {
            System.out.println(e.getMessage());
        }

    }

    private static Student createStudent(String name, String email) {
        return new Student(name, email);
    }
}
