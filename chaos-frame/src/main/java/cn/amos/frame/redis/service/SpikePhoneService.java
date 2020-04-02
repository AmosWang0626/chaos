package cn.amos.frame.redis.service;

import cn.amos.frame.redis.config.RedisLock;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.*;

/**
 * DESCRIPTION: 手机秒杀业务
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/3/31
 */
@Service
public class SpikePhoneService {

    @Resource
    private RedisLock defaultRedisLock;

    /**
     * 并发量
     */
    private static final int CONCURRENCY_COUNT = 1000;
    /**
     * 秒杀总量
     */
    public static int phoneCount = 100;
    /**
     * 秒杀完成耗时
     */
    public static Long totalTime = null;
    /**
     * 并发锁名字(保证分布式环境中只有一把锁)
     */
    private static final String SPIKE_PHONE_LOCK_KEY = "SPIKE_PHONE_LOCK_KEY";

    /**
     * 线程池配置
     */
    private ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build();
    private ExecutorService threadPool = new ThreadPoolExecutor(
            50, 80,
            100L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(20),
            threadFactory,
            new ThreadPoolExecutor.CallerRunsPolicy());


    /**
     * 线程池并发执行
     */
    public void execute() {
        defaultRedisLock.init(SPIKE_PHONE_LOCK_KEY);
        long beginTime = System.currentTimeMillis();

        // execute
        for (int i = 0; i < CONCURRENCY_COUNT; i++) {
            threadPool.execute(() -> {
                // 获取锁
                String lock = defaultRedisLock.lock(SPIKE_PHONE_LOCK_KEY, 1000, 1000);
                if (lock != null) {
                    // 这里，基本不用担心并发了，按部就班玩就行
                    if (phoneCount > 0) {
                        System.out.printf("[%s] 出售一台手机: 手机编号: [%s]\n",
                                Thread.currentThread().getId(), phoneCount--);
                    } else {
                        if (totalTime == null) {
                            totalTime = System.currentTimeMillis() - beginTime;
                        }
                        System.out.printf("已售罄...秒杀耗时: [%d]毫秒\n", totalTime);
                    }

                    // 释放锁
                    defaultRedisLock.unlock(SPIKE_PHONE_LOCK_KEY, lock);
                }
            });
        }
    }

}
