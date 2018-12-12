package cn.amos.frame.disconf;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import org.springframework.context.annotation.Configuration;

/**
 * PROJECT: credit-external
 *
 * @author DaoYuanWang
 * @apiNote 短信模板
 * @date 2018/2/9
 */
@Configuration
@DisconfFile(filename = "redis.properties")
@DisconfUpdateService(confFileKeys = {"redis.properties"})
public class DisConfConfig implements IDisconfUpdate {

    /**
     * 域名
     */
    private String redisHost;
    /**
     * 端口
     */
    private String redisPort;

    @DisconfFileItem(name = "redis.host", associateField = "redisHost")
    public String getRedisHost() {
        return redisHost;
    }

    @DisconfFileItem(name = "redis.port", associateField = "redisPort")
    public String getRedisPort() {
        return redisPort;
    }

    @Override
    public void reload() throws Exception {

    }
}
