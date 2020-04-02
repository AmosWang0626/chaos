package cn.amos.frame.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;

/**
 * DESCRIPTION: 数据变化 -- 监听当前节点，每次变化都监听
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/3/22
 */
public class MoreWatchZk extends BaseWatch {
    /**
     * 保存历史数据
     */
    private String oldValue;

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public static void main(String[] args) throws Exception {
        MoreWatchZk moreWatch = new MoreWatchZk();
        moreWatch.initZkInstance();
        String defaultPath = "/java_test";
        String saveData = "Java代码测试数据";

        moreWatch.createNode(defaultPath, saveData);

        String data = moreWatch.getNode(defaultPath);
        System.out.println(">>>>>>> 获取节点数据：" + data);
        moreWatch.setOldValue(data);

        Thread.sleep(Long.MAX_VALUE);
        moreWatch.stop();
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
        String data = new String(instance.getData(defaultPath, getDataWatcher(), new Stat()));
        if (data.equals(oldValue)) {
            System.out.println(">>>>>>> 节点数据更新：节点数据没有变化");
        } else {
            System.out.printf(">>>>>>> 节点数据更新：旧值:[%s], 新值:[%s]\n", oldValue, data);
            oldValue = data;
        }
    }


    @Override
    public Watcher getChildDataWatcher() {
        return null;
    }

}
