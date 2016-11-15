package org.ananichev;

import java.lang.reflect.Method;


/**
 * Created by sbt-ananichev-ld on 08.11.2016.
 */
public class BeanUtils {

    public static boolean isGetter(Method method) {
        return method.getName().startsWith("get") && method.getParameterTypes().length == 0 && !void.class.equals(method.getReturnType());
    }

    public static boolean isSetter(Method method) {
        return method.getName().startsWith("set") && method.getParameterTypes().length == 1;
    }


    public static void assign(Object to, Object from) {
        Class<?> clazz = from.getClass();
        Class<?> clazzz = to.getClass();
        for (Method m : clazz.getMethods()) {
            if (isGetter(m)) {
                for (Method method : clazzz.getMethods()) {
                    if (isSetter(method) && method.getName().contains(m.getName().split("get")[1])) {
                        try {
                            Object value = m.invoke(from);
                            for (Class<?> par : method.getParameterTypes()) {
                                if (par.equals(value.getClass()) || par.equals(value.getClass().getSuperclass())) {
                                    method.invoke(to, value);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
