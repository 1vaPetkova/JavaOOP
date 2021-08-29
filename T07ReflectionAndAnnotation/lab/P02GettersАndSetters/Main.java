package T07ReflectionAndAnnotation.lab.P02GettersАndSetters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class clazz = Reflection.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Arrays.stream(declaredMethods)
                .filter(m -> m.getName().startsWith("get") || m.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName)).
                forEach(Main::print);
    }

    private static void print(Method m) {
        String out =
                m.getName().startsWith("get") ?
                        String.format("%s will return class %s", m.getName(), m.getReturnType().getName()) :
                        String.format("%s and will set field of class %s", m.getName(), m.getParameterTypes()[0].getName());
        System.out.println(out);
    }
}
