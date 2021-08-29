package T07ReflectionAndAnnotation.lab.P05CodingTracker;

public class Main {

    @Author(name = "George")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
        Tracker.printMethodsByAuthor(Reflection.class);
        Tracker.printMethodsByAuthor(Main.class);
    }

}
