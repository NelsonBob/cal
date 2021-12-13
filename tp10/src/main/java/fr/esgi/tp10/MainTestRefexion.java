package fr.esgi.tp10;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MainTestRefexion {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Class<LoggerFactory> loggerFactoryClass = LoggerFactory.class;
        final Constructor<LoggerFactory> declaredConstructor = loggerFactoryClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        final LoggerFactory loggerFactory = declaredConstructor.newInstance();
        System.out.println(loggerFactory != null);
    }
}
