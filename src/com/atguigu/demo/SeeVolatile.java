package com.atguigu.demo;

import java.util.concurrent.TimeUnit;

/**
 * @author cyc
 * @Description  证明volatile的可见性以及JMM原理
 */
public class SeeVolatile {

    public static void main(String[] arg){
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            //等待三秒
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t update number value finish, number value is " + myData.number);
        }, "AAA").start();

        while (myData.number == 0){
            // 如果AAA线程没有通知
        }

        System.out.println(Thread.currentThread().getName() + "\t 收到修改number值得通知，number value is " + myData.number);
    }
}

class MyData{

    volatile Integer number = 0;

    public void addTo60(){
        this.number = 60;
    }
}
