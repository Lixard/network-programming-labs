package ru.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.student.annotation.HaveArea;
import ru.student.annotation.ReturnArea;

import java.lang.reflect.InvocationTargetException;

public class AreaCounter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AreaCounter.class);


    public void countArea(Object object) {
        if (object.getClass().isAnnotationPresent(HaveArea.class)) {
            final var name = object.getClass().getAnnotation(HaveArea.class).name();
            final var methods = object.getClass().getMethods();
            for (var method : methods) {
                if (method.isAnnotationPresent(ReturnArea.class)) {
                    try {
                        final var invoke = method.invoke(object);
                        LOGGER.info("{} area: {}", name, invoke);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            LOGGER.warn("Object annotation doesn't present");
        }
    }
}
