package T07ReflectionAndAnnotation.exercise.P02BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scan = new Scanner(System.in);
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        String input = "";
        Constructor<BlackBoxInt> declaredConstructor = clazz.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        BlackBoxInt blackBoxInt = declaredConstructor.newInstance();
        Field innerValue = clazz.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        while (!(input = scan.nextLine()).equals("END")) {
            String methodName = input.split("_")[0];
            int value = Integer.parseInt(input.split("_")[1]);

            Method method = clazz.getDeclaredMethod(methodName, int.class);

            method.setAccessible(true);
            method.invoke(blackBoxInt, value);
            int result = (int) innerValue.get(blackBoxInt);
            System.out.println(result);
        }
    }
}
