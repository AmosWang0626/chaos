package cn.amos.common.simple.thread.sync;

/**
 * PROJECT: chaos
 * NOTE: 类说明
 *
 * @author AMOS
 * @date 2018/8/15 10:28
 */
public class SingleObject {

    public static void main(String[] args) {
        new Thread(() -> Single.getInstance(), "A").start();
        new Thread(() -> Single.getInstance(), "B").start();
        new Thread(() -> Single.getInstance(), "C").start();
        new Thread(() -> Single.getInstance(), "D").start();
        new Thread(() -> Single.getInstance(), "E").start();
    }
}

/**
 * 单例模式: 懒汉加载、饿汉加载
 * 懒汉，需要时再初始化；
 * <p>
 * 注意 volatile 关键字，普通得到变量赋值，是先创建出一个该变量的副本，然后修改副本，再将副本内容写入源变量；
 * 使用 volatile 之后，变量每次赋值，会直接修改源变量。
 */
class Single {
    private static volatile Single instance;

    private Single() {
        System.out.println("【构造方法】" + Thread.currentThread().getName());
    }

    static Single getInstance() {
        if (instance == null) {
            synchronized (Single.class) {
                if (instance == null) {
                    instance = new Single();
                }
            }
        }
        return instance;
    }
}