package T07ReflectionAndAnnotation.lab.P04CreateAnnotation;

import java.lang.annotation.Annotation;

import java.lang.reflect.InvocationTargetException;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class clazz = Reflection.class;

        Annotation[] annotations = clazz.getAnnotations();
        System.out.println();
    }
}
