package cn.amos.simple.thread.demo1;

import lombok.Data;

import java.util.concurrent.Callable;

/**
 * NOTE: 类说明
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/7
 */
public class MyCallable {

    public static void main(String[] args) {
        Callable callable = () -> new Person("DY", "HELLO", 18);
        try {
            System.out.println(callable.call());
            System.out.println(callable.call());
            System.out.println(callable.call());
            System.out.println(callable.call());
            System.out.println(callable.call());
            System.out.println(callable.call());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

@Data
class Person {

    private String name;
    private String message;
    private int age;

    Person(String name, String message, int age) {
        this.name = name;
        this.message = message;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", age=" + age +
                '}';
    }
}
