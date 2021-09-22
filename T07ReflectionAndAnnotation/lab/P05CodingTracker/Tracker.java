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
//                T07ReflectionAndAnnotation.lab.P05CodingTracker.T07ReflectionAndAnnotation.exercise.P01HarvestingFields.T07ReflectionAndAnnotation.exercise.P02BlackBoxInteger.T07ReflectionAndAnnotation.exercise.P01HarvestingFields.T07ReflectionAndAnnotation.exercise.P02BlackBoxInteger.T03Inheritance.archive.P02BookShop.T03Inheritance.archive.P03Mankind.T03Inheritance.archive.P04MordorsCrueltyPlan.T03Inheritance.archive.P05OnlineRadioDatabase.T04InterfacesAndAbstraction.archive.P10MooD3.Workshops.BoatRacingSimulator.Main.class.getMethods()[0].getAnnotation(T07ReflectionAndAnnotation.lab.P05CodingTracker.Author.class).name(),
//                T07ReflectionAndAnnotation.lab.P05CodingTracker.T07ReflectionAndAnnotation.exercise.P01HarvestingFields.T07ReflectionAndAnnotation.exercise.P02BlackBoxInteger.T07ReflectionAndAnnotation.exercise.P01HarvestingFields.T07ReflectionAndAnnotation.exercise.P02BlackBoxInteger.T03Inheritance.archive.P02BookShop.T03Inheritance.archive.P03Mankind.T03Inheritance.archive.P04MordorsCrueltyPlan.T03Inheritance.archive.P05OnlineRadioDatabase.T04InterfacesAndAbstraction.archive.P10MooD3.Workshops.BoatRacingSimulator.Main.class.getMethods()[0].getName());
//        System.out.printf("%s: %s()\n",
//                clazz.getMethods()[0].getAnnotation(T07ReflectionAndAnnotation.lab.P05CodingTracker.Author.class).name(),
//                clazz.getMethods()[0].getName());
    }
}
