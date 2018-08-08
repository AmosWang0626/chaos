package cn.amos.simple.thread.demo1;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * NOTE: 类说明
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/7
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return Thread.currentThread().getId() + " Hello Callable!";
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 3; i++) {
            Callable<String> callable = new MyCallable();
            FutureTask<String> task = new FutureTask<>(callable);
            new Thread(task).start();
            // 获取异步线程返回的数据
            System.out.println(task.get());
        }
    }

    private static void simple() throws Exception {
        for (int i = 0; i < 3; i++) {
            Callable<String> callable = () -> Thread.currentThread().getId() + " Hello Callable!";
            FutureTask<String> futureTask = new FutureTask<>(callable);
            new Thread(futureTask).start();
            System.out.println(futureTask.get());
        }
    }

    private static void suggestAchieve() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(new Thread(() -> System.out.println("hello")));

        singleThreadPool.shutdown();
    }
}
