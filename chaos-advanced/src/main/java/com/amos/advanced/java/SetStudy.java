package com.amos.advanced.java;

import lombok.Data;

import java.util.HashSet;

/**
 * PROJECT: interview
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/3/25
 */
public class SetStudy {

    public static void main(String[] args) {
        Person person = new Person().setName("hello").setAge(16);
        Person person2 = new Person().setName("hello").setAge(16);
        System.out.println(person);
        System.out.println(person2);
        System.out.println(person.equals(person2));
        System.out.println(person == person2);

        HashSet<Person> hashSet = new HashSet<>();
        hashSet.add(person);
        hashSet.add(person2);
        System.out.println(hashSet.size());
    }

    @Data
    private static class Person {
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public Person setName(String name) {
            this.name = name;
            return this;
        }

        public Integer getAge() {
            return age;
        }

        public Person setAge(Integer age) {
            this.age = age;
            return this;
        }
    }

}
