package cn.amos.simple.thread.proxy;

import cn.amos.simple.thread.base.CarInterface;

import java.lang.reflect.Method;
public class $Proxy0 implements CarInterface {

    private InvocationHandler h;

    public $Proxy0(InvocationHandler h) {
        this.h = h;
    }
@Override
    public void move() {
        try{
        Method md = CarInterface.class.getMethod("move");
        h.invoke(this,md);
        }catch(Exception e){e.printStackTrace();}
    }}
