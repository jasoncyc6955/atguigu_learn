package com.atguigu.interview;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class ABADemo {

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static volatile String name = "zhangSan";

    public static void main(String[] args) {

        new Thread(() -> {
            atomicReference.compareAndSet(100, 2019);
            name = "list";
        }, "t1").start();

        new Thread(() -> {
            try { TimeUnit.SECONDS.sleep(2); }catch (Exception e){ e.printStackTrace(); }
            System.out.println(name);
            System.out.println(atomicReference.get());
        }, "t2").start();
    }


}
