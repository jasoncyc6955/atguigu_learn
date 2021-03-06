package com.atguigu.interview;


import java.util.concurrent.atomic.AtomicReference;

class User{
    String name;
    Integer age;

    User(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class AtomicReferenceDemo {

    public static void main(String[] args){
        User z3 = new User("zs", 15);
        User li4 = new User("li4", 10);

        AtomicReference<User> atomicReference = new AtomicReference<>();

        atomicReference.set(z3);

        System.out.println(atomicReference.compareAndSet(z3, li4) + "\t" + atomicReference.get().toString());
    }
}
