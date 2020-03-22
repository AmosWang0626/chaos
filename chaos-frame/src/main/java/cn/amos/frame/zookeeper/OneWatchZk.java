package cn.amos.frame.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;

/**
 * DESCRIPTION: 数据变化 -- 监听当前节点，只监听一次
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/3/22
 */
public class OneWatchZk extends BaseWatch {

    public static void main(String[] args) throws Exception {
        OneWatchZk oneWatch = new OneWatchZk();
        oneWatch.initZkInstance();
        String defaultPath = "/java_test";
        String saveData = "Java代码测试数据";

        oneWatch.createNode(defaultPath, saveData);

        String data = oneWatch.getNode(defaultPath);
        System.out.println(">>>>>>> 获取节点数据：" + data);

        Thread.sleep(Long.MAX_VALUE);
        oneWatch.stop();
    }


    @Override
    public Watcher getDataWatcher() {
        return watchedEvent -> {
            try {
                dataWatchOne(watchedEvent.getPath());
            } catch (KeeperException | InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

    public void dataWatchOne(String defaultPath) throws KeeperException, InterruptedException {
        // 监听节点数据发生变化
        String data = new String(instance.getData(defaultPath, false, new Stat()));
        System.out.println(">>>>>>> 节点数据更新：" + data);
    }


    @Override
    public Watcher getChildDataWatcher() {
        return null;
    }

}
