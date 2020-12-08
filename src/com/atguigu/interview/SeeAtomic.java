package com.atguigu.interview;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author cyc
 * @Description volatile 不能保证原子性证明 && 如何不用synchronized 解决原子性问题
 * 利用java.util.concurrent.atomic实现原子性
 */
public class SeeAtomic {

    public static void main(String[] args) {
        MyData1 myData = new MyData1();

        for (int i = 1; i <= 20; i++) {
            new Thread(() ->{
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlusPlus();
                    myData.addMyAtoMic();
                }
            }, String.valueOf(i)).start();
        }

        //如果线程还没全部运行完成，不能执行下一步，需要等累加的线程完成之后才能执行到下一步
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t number finally value is " + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t number finally atomicInteger is " + myData.atomicInteger);
    }
}

class MyData1{

    volatile int number = 0;

    //利用volatile 和synchronized实现原子性，但是synchronized太笨重，不建议使用
    //volatile 保证可见性，及通知其他线程=》主物理内存的值已经被修改
    //synchronized 表示锁定方法，避免一个线程未操作完成时，被另外一个线程调用
    synchronized void addPlusPlus(){
        this.number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    void addMyAtoMic(){
        atomicInteger.getAndIncrement();
    }
}
