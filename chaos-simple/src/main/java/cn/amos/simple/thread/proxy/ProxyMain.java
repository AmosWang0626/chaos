package cn.amos.simple.thread.proxy;

import cn.amos.simple.thread.base.BaseCar;
import cn.amos.simple.thread.base.CarInterface;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ProxyMain {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, IOException, InvocationTargetException, ClassNotFoundException {
        BaseCar baseCar = new BaseCar();
        InvocationHandler handler = new TimeHandler(baseCar);
        CarInterface carInterface = (CarInterface) Proxy.newProxyInterface(CarInterface.class, handler);
        carInterface.move();
    }
}
