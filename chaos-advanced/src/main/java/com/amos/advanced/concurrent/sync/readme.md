# Synchronized 锁两种模式,四种方法

## 对象锁
- 代码块锁
    1. synchronized(this){}
    2. Object lock = new Object(); synchronized(lock){}
- 方法锁
    - private synchronized void method(){}

## 类锁
- .class 代码块锁
    - synchronized(*.class){}
- 静态方法锁
    - private static synchronized method(){}