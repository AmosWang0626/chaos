package cn.amos.simple.thread.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface InvocationHandler {

    public void invoke(Object obj, Method method) throws InvocationTargetException, IllegalAccessException;
}
