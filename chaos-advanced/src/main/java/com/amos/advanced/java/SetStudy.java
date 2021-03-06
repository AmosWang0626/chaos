package com.amos.advanced.java;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.*;

/**
 * PROJECT: interview
 * DESCRIPTION: Set学习，JPA、Hibernate 中常用
 *
 * @author Daoyuan
 * @date 2019/3/25
 */
public class SetStudy {

    /**
     * 此情可待成追忆，只是当时已惘然。
     */
    public static void main(String[] args) {
        range();

        Person person = new Person().setName("hello").setAge(16);
        Person person2 = new Person().setName("hello").setAge(16);

        System.out.println(person + "\t" + person.hashCode());
        System.out.println(person2 + "\t" + person2.hashCode());
        // equals 比较的是 hashCode
        System.out.println("equals ? " + person.equals(person2));

        // == 比较的是 内存地址
        System.out.println("person:" + System.identityHashCode(person));
        System.out.println("person2:" + System.identityHashCode(person2));
        System.out.println("== ? " + (person == person2));

        HashSet<Person> hashSet = new HashSet<>();
        hashSet.add(person);
        hashSet.add(person2);
        System.out.println("HashSet<Person>.size() = " + hashSet.size());
    }

    public static void range() {
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            strings.add(String.valueOf(new Random().nextInt(200) + 100));
        }
        strings.add(null);
//        System.out.println(strings);
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "\t");
        }
        System.out.println();
        strings.spliterator().forEachRemaining(s -> System.out.print(s + "\t"));
        System.out.println();
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    private static class Person {
        private String name;
        private Integer age;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Person person = (Person) o;
            return Objects.equals(name, person.name) &&
                    Objects.equals(age, person.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }

}
