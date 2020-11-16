package com.atguigu.demo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ContainerNotSaftDemo {


    public static void main(String[] args) {
        //ArrayList 线程不安全
        //ArrayList<String> list = new ArrayList<>();
        /**
         * ArrayList 线程不安全解决，三种方法，推荐第三种解决
         * 1.List<String> list = new Vector<>();
         * 2.List<String> list = Collections.synchronizedList(new ArrayList<>());
         * 3.List<String> list = new CopyOnWriteArrayList<>();
         */
        //同理Set也是线程不安全
        //Set<String> list = new HashSet<>();
        /**
         * Set 线程不安全解决办法
         * 1.Set<String> list = Collections.synchronizedSet(new HashSet<>());
         * 2.Set<String> list = new CopyOnWriteArraySet<>(new HashSet<>());
         * hashSet 的底层就是hashMap，hashSet.add(e) 相当于 hashMap.put(e, 常量对象(固定一个值))，也就是HashMap只关心
            key值，不关心value值是什么，value值是一个常量的话，就是HashSet。
         */

        //hashMap线程不安全
        Map<String, String> map = new HashMap<>();
        /**
         * 解决hashMap线程不安全方法：
         * 1.Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
         * 2.Map<String, String> map = new ConcurrentHashMap<>();
         */


        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
}
