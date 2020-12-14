package com.atguigu.interview;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * 什么是CAS ，比较并交换, compareAndSet
 */
public class CasDemo {




    public static void main(String[] args){

        AtomicInteger atomicInteger = new AtomicInteger(5);


        System.out.println(atomicInteger.compareAndSet(5, 2019) + "current value：" + atomicInteger.get());


        System.out.println(atomicInteger.compareAndSet(5, 2016) + "current value：" + atomicInteger.get());


        System.out.println(atomicInteger.compareAndSet(5, 2019) + "current value：" + atomicInteger.get());

    }
}
