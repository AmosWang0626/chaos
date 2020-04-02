package cn.amos.frame.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;

import java.util.List;

/**
 * DESCRIPTION: 数据变化 -- 监听子节点变化
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/3/22
 */
public class ChildWatchZk extends BaseWatch {

    private static String defaultPath = "/java_test";


    public static void main(String[] args) throws Exception {
        ChildWatchZk moreWatch = new ChildWatchZk();
        moreWatch.initZkInstance();

        Thread.sleep(Long.MAX_VALUE);
        moreWatch.stop();
    }


    @Override
    public Watcher getDataWatcher() {
        return null;
    }

    @Override
    public Watcher getChildDataWatcher() {
        return event -> {
            // 只监控指定路径下 child 变化
            if (event.getPath().equals(defaultPath) &&
                    event.getType() == Watcher.Event.EventType.NodeChildrenChanged) {
                process();
            }
        };
    }

    private void process() {
        try {
            List<String> children = instance.getChildren(defaultPath, true);
            System.out.println(children);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
