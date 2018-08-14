package cn.amos.common.simple.thread.sync;

import lombok.Data;

/**
 * PROJECT: chaos
 * NOTE: 生产者-消费者问题
 * 1.商品有两个重要属性，简单生产者消费者会导致商品不一致；
 * - 另外可能会导致两个问题：（1）未生产就消费了（2）同商品多次消费。
 * 2.加上synchronized后，会解决商品属性一致的问题；其他问题无能为力。
 * 3.此时该问题就需要加上等待唤醒机制了，消费要等待生产完毕，反之生产完要等待消费完毕。
 * <br/>
 * 等待唤醒机制要使用到object的方法：
 * - wait()         等待（死等，还有个wait(long timeout)的活等）
 * - notify()       唤醒第一个等待线程
 * - notifyAll()    唤醒所有等待线程，谁优先级高谁有可能先执行
 * <br/>
 * 面试题：
 * sleep(long millis)   Thread方法，线程休眠，休眠完成自动唤醒
 * wait()               Object方法，要想唤醒，必须使用notify()或者notifyAll()
 * <br/>
 *
 * @author AMOS
 * @date 2018/8/13 20:44
 */
public class ProdConsume {

    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(new Producer(myData)).start();
        new Thread(new Consumer(myData)).start();
    }
}

@Data
class Producer implements Runnable {
    private MyData myData;

    Producer(MyData myData) {
        this.myData = myData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.myData.set(600 + i, "Hello " + i);
        }
    }
}

@Data
class Consumer implements Runnable {
    private MyData myData;

    Consumer(MyData myData) {
        this.myData = myData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            myData.get();
        }
    }
}

@Data
class MyData {
    private Integer id;
    private String name;

    /**
     * flag == true     生产,不允许消费
     * flag == false    消费,不允许生产
     */
    private volatile boolean flag = true;

    MyData() {
    }

    synchronized void set(Integer id, String name) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(180);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.id = id;
        this.name = name;
        flag = false;
        System.out.println("generate data " + this.toString());

        super.notify();
    }

    synchronized void get() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        flag = true;
        System.out.println("consume data " + this.toString());

        super.notify();
    }
}