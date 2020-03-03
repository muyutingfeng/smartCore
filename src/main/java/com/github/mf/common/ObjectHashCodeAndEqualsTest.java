package com.github.mf.common;

import java.util.HashMap;
import java.util.Objects;

public class ObjectHashCodeAndEqualsTest {
    static class Person {
        private Integer id;
        private String name;

        public Person(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {return true;}
            if (!(o instanceof Person)) {return false;}
            Person person = (Person) o;
            return Objects.equals(id, person.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person(1,"mf");
        Person p2 = new Person(1,"mf2");

        System.out.println(p1.equals(p2));

        HashMap hashMap = new HashMap();
        hashMap.put(p1,"haha");
        System.out.println(hashMap.get(p2));
    }
}