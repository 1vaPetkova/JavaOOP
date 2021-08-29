package T07ReflectionAndAnnotation.lab.P05CodingTracker;

import java.util.Arrays;
import java.util.Comparator;

public class Tracker {
    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<?> clazz) {
        Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> m.getDeclaredAnnotation(Author.class) != null)
                .sorted(Comparator.comparing(m -> m.getDeclaredAnnotation(Author.class).name()))
                .forEach(m ->
                        System.out.println(m.getAnnotation(Author.class).name() + ": " +
                                m.getName()));


//        System.out.printf("%s: %s()\n",
//                T07ReflectionAndAnnotation.lab.P05CodingTracker.T07ReflectionAndAnnotation.exercise.P01HarvestingFields.T07ReflectionAndAnnotation.exercise.P02BlackBoxInteger.T07ReflectionAndAnnotation.exercise.P01HarvestingFields.T07ReflectionAndAnnotation.exercise.P02BlackBoxInteger.Main.class.getMethods()[0].getAnnotation(T07ReflectionAndAnnotation.lab.P05CodingTracker.Author.class).name(),
//                T07ReflectionAndAnnotation.lab.P05CodingTracker.T07ReflectionAndAnnotation.exercise.P01HarvestingFields.T07ReflectionAndAnnotation.exercise.P02BlackBoxInteger.T07ReflectionAndAnnotation.exercise.P01HarvestingFields.T07ReflectionAndAnnotation.exercise.P02BlackBoxInteger.Main.class.getMethods()[0].getName());
//        System.out.printf("%s: %s()\n",
//                clazz.getMethods()[0].getAnnotation(T07ReflectionAndAnnotation.lab.P05CodingTracker.Author.class).name(),
//                clazz.getMethods()[0].getName());
    }
}
