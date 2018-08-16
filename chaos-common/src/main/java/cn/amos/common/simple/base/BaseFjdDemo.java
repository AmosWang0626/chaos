package cn.amos.common.simple.base;

/**
 * PROJECT: chaos
 * NOTE: FJD 封装继承多态
 * 多态：1.要有继承、2.要有重写、3.要有父类对象引用子类对象
 *
 * @author AMOS
 * @date 2018/8/16 8:46
 */
public class BaseFjdDemo {
    public static void main(String[] args) {
        Person chinese = new Chinese();
        chinese.eat();
        Person english = new English();
        english.eat();
        English english1 = (English) english;
        english1.eat();
    }
}

class Person {
    void eat() {
        System.out.println("人吃饭");
    }
}

class Chinese extends Person {
    @Override
    public void eat() {
        System.out.println("中国人吃饭");
    }
}

class English extends Person {
    @Override
    public void eat() {
        System.out.println("英国人吃饭");
    }
}