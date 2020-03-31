package cn.amos.frame.redis.service;

import cn.amos.frame.redis.config.RedisLock;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * DESCRIPTION: 手机秒杀业务
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/3/31
 */
@Service
public class SpikePhoneService {

    private static final int THREAD_COUNT = 500;

    @Resource
    private RedisLock defaultRedisLock;

    public int phoneCount = 20;

    private static final String SPIKE_PHONE_LOCK_KEY = "SPIKE_PHONE_LOCK_KEY";


    private ExecutorService service = Executors.newScheduledThreadPool(500);

    public void execute() {
        service.execute(() -> {
            String lock = defaultRedisLock.lock(SPIKE_PHONE_LOCK_KEY, 10000, 10000);
            if (lock != null && phoneCount > 0) {
                System.out.println("出售一台手机: " + phoneCount--);
            }
        });
    }

}
