package com.atguigu.interview;

/**
 * 多线程下的单例模式
 */


public class SingletonDemo {

    private static volatile SingletonDemo instance = null;

    //构造方法
    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法SingletonDemo()");
    }


    //DCL -> Double Check Lock 双端检查机制，但是这种方法有一个隐患（可能运行几千万次之后才出现一次，由于指令优化重排，构造方法也会执行多次）
    //DCL(双端检锁)机制不一定线程安全，原因是有指令重排序的存在，加入volatile可以禁止指令重排序
    //原因在于某一线程执行到第一次检测，读取到的instance不为null时，instance的引用可能没有完成初始化
    /** instance = new SingletonDemo();可以分为以下3部完成
     * memory = allocate() //1.分配内存空间
     * instance(memory); //2.初始化对象
     * instance = memory; //3.设置instance指向刚分配的内存地址，此时instance != null
     * */
    //步骤2和步骤3不存在数据依赖关系，而且无论分配重排前还是重排后程序的执行结果在单线程中没有改变，因此这种重排序优化是允许的
    /**
     * memory = allocate(); // 1.分配对象内存空间
     * instance = memory; // 3.设置instance指向刚分配的内存地址，此时instance != null，但是对象还没有初始化完成！
     * instance(memory) // 2.初始化对象
     * 但是指令重排只会保证串行语义的执行的一致性（类似于单线程），但是并不会关心多线程间的语义的一致性。
     * 所以当一条线程访问instance不为null时，由于instance实例未必已初始化完成，也就造成了线程安全的问题
     */
    public static SingletonDemo getInstance(){
        if(instance == null){
            synchronized (SingletonDemo.class){
                if (instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args){
       // System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
       // System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
       // System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());

        for (int i = 1; i <= 10; i++){
            new Thread(() -> {
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
