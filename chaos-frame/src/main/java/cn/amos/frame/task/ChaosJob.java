package cn.amos.frame.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * PROJECT: chaos
 * DATE: 2018/2/27
 *
 * @author DaoyuanWang
 */
@Service
public class ChaosJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChaosJob.class);

    /**
     * "* * * * * ?" 每隔1秒执行一次
     * "0 0 0 1 * ?" 每月一日0点执行一次
     */
    @Scheduled(cron = "0 32 * * * ?")
    public void run() {
        LOGGER.info("Hello FirstJob  " + System.currentTimeMillis());
    }
}
