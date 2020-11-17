package com.atguigu.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable{

    /**
     * 3个synchronized方法证明 synchronized 是可重入锁
     */
    public synchronized void sendMsg() {
        System.out.println(Thread.currentThread().getId() + "\t sendMsg");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getId() + "\t ####sendEmail");
        sendWechat();
    }

    public synchronized void sendWechat() {
        System.out.println(Thread.currentThread().getId() + "\t $$$$sendWechat");
    }

    /**
     * 证明ReenterLock 也是可重入锁
     */
    @Override
    public void run() {
        get();
    }
    Lock lock = new ReentrantLock();

    public void get(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t get");
            set();
        }finally {
            lock.unlock();
        }
    }

    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t set");
        }finally {
            lock.unlock();
        }
    }
}

public class ReenterLockDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(() -> {
            phone.sendMsg();
        }, "t1").start();

        new Thread(() -> {
            phone.sendMsg();
        }, "t2").start();


        Thread t3 = new Thread(phone, "t3");
        Thread t4 = new Thread(phone, "t4");

        t3.start();
        t4.start();
    }

}
