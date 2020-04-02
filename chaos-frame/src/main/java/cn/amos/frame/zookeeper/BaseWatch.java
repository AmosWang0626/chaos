package cn.amos.frame.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * DESCRIPTION: BaseWatch
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/3/22
 */
public abstract class BaseWatch {

    private static final String CONN_ZK_URL = "192.168.1.188:2181";
    private static final int SESSION_TIMEOUT = 50 * 1000;

    public ZooKeeper instance = null;


    /**
     * 获取 Data Watcher
     *
     * @return org.apache.zookeeper.Watcher
     */
    public abstract Watcher getDataWatcher();

    /**
     * 获取 Child Data Watcher
     *
     * @return org.apache.zookeeper.Watcher
     */
    public abstract Watcher getChildDataWatcher();

    public String getNode(String defaultPath) throws KeeperException, InterruptedException {
        // 获取节点数据
        return new String(instance.getData(defaultPath, getDataWatcher(), new Stat()));
    }

    public void createNode(String defaultPath, String saveData) throws InterruptedException {
        // 保存节点
        try {
            // 类似关掉防火墙 ZooDefs.Ids.OPEN_ACL_UNSAFE
            String resp = instance.create(defaultPath, saveData.getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(">>>>>>> 节点保存成功：" + resp);
        } catch (KeeperException e) {
            System.out.println(">>>>>>> 节点保存失败：节点已存在");
        }
    }

    /**
     * Watch = 异步 + 回调
     * 1.一次触发
     * 2.数据观察 + 子节点观察
     * 客户端注册监听它关心的目录节点，当目录节点发生变化是，ZK 会通知客户端
     */
    public void initZkInstance() throws IOException {
        instance = new ZooKeeper(CONN_ZK_URL, SESSION_TIMEOUT, getChildDataWatcher());
    }

    public void stop() throws InterruptedException {
        if (instance != null) {
            instance.close();
        }
    }
}
